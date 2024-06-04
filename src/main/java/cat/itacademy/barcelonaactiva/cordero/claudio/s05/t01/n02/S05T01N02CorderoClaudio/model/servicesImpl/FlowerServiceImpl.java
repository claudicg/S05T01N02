package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.enums.CountryTypeEnum;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain.CountryEntity;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain.FlowerEntity;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services.FlowerService;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.repositories.CountryRepository;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.repositories.FlowerRepository;

@Service("FlowerService")
public class FlowerServiceImpl implements FlowerService {

	
	@Autowired
	FlowerRepository flowerRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	
	@Override
	public FlowerDTO add(String flowerName, String flowerCountry) {
		
		FlowerEntity flowerEntity = new FlowerEntity(null, flowerName, flowerCountry);
		FlowerEntity responseEntity = flowerRepository.save(flowerEntity);
		CountryEntity countryEntity = countryRepository.findById(responseEntity.getFlowerCountry()).orElseThrow();
		
		return mappingEntityToDTO(responseEntity, countryEntity);

	}

	@Override
	public FlowerDTO update(int id, String flowerName, String flowerCountry) {
		
		CountryEntity countryEntity = countryRepository.findById(flowerCountry).orElse(null);
		
		if(countryEntity != null) {
			FlowerEntity flowerEntity = new FlowerEntity(id, flowerName, countryEntity.getCountryName());
			FlowerEntity responseEntity = flowerRepository.save(flowerEntity);
			return mappingEntityToDTO(responseEntity, countryEntity);
		}else {
			return null;
		}		
	}

	@Override
	public void delete(int id) {
		
		FlowerEntity flower = flowerRepository.findById(id).orElseThrow(null);
		
		if(flower != null) {
			flowerRepository.deleteById(id);
		}	
	}
		

	@Override
	public FlowerDTO getOne(int id) {
		
		FlowerEntity flowerEntity = flowerRepository.findById(id).orElse(null);
		CountryEntity countryEntity = countryRepository.findById(flowerEntity.getFlowerCountry()).orElseThrow();
		
		return mappingEntityToDTO(flowerEntity, countryEntity);
	}

	@Override
	public List<FlowerDTO> getAll() {
		
		List<FlowerEntity> flowers = flowerRepository.findAll();
		
		List<FlowerDTO> flowerDtoList = flowers.stream().map(flower 
				-> {
					CountryEntity countryEntity = countryRepository.findById(flower.getFlowerCountry()).orElseThrow();
					 return mappingEntityToDTO(flower, countryEntity);
				}).collect(Collectors.toList());
		
		return flowerDtoList;
	}

	private FlowerDTO mappingEntityToDTO(FlowerEntity flowerEntity, CountryEntity countryEntity) {
		
		FlowerDTO flowerDto = new FlowerDTO();
		
		flowerDto.setFlowerId(flowerEntity.getFlowerId());
		flowerDto.setFlowerName(flowerEntity.getFlowerName());
		flowerDto.setFlowerCountry(flowerEntity.getFlowerCountry());
		flowerDto.setFlowerType(countryEntity.getCountryType()
				.equalsIgnoreCase(CountryTypeEnum.EU.getType())
				? CountryTypeEnum.EU.getType() : CountryTypeEnum.NON_EU.getType());
		
		
		return flowerDto;
	}	
	
}
