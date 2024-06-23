package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.enums.CountryTypeEnum;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.InvalidNameException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.NotFoundException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain.CountryEntity;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.domain.FlowerEntity;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerAddRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerUpdateRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services.FlowerService;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.repositories.CountryRepository;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.repositories.FlowerRepository;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils.Constants;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils.Validations;

@Service("FlowerService")
public class FlowerServiceImpl implements FlowerService {

	
	@Autowired
	FlowerRepository flowerRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	
	@Override
	public FlowerDTO add(FlowerAddRequestDTO flowerAddRequestDto) throws InvalidNameException {
		
		if(!Validations.isValidName(flowerAddRequestDto.getFlowerName().trim())) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_NAME);
		}
		
		if(!Validations.isValidName(flowerAddRequestDto.getFlowerCountry().trim())) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_COUNTRY);
		}
		
		FlowerEntity flowerEntity = new FlowerEntity(null, flowerAddRequestDto.getFlowerName(), flowerAddRequestDto.getFlowerCountry());
		FlowerEntity responseEntity = flowerRepository.save(flowerEntity);
		CountryEntity countryEntity = countryRepository.findById(responseEntity.getFlowerCountry()).orElseThrow();
		
		return mappingEntityToDTO(responseEntity, countryEntity);

	}

	@Override
	public FlowerDTO update(FlowerUpdateRequestDTO flowerUpdateDto) throws NotFoundException, InvalidNameException {
		
		if(!Validations.isValidNumber(Integer.toString(flowerUpdateDto.getFlowerId()))) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_ID);
		}
		
		if(!Validations.isValidName(flowerUpdateDto.getFlowerName().trim())) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_NAME);
		}
		
		if(!Validations.isValidName(flowerUpdateDto.getFlowerCountry().trim())) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_COUNTRY);
		}
		
		CountryEntity countryEntity = countryRepository.findById(flowerUpdateDto.getFlowerCountry().trim())
				.orElseThrow(() -> new NotFoundException(Constants.Messages.NOT_FOUND));
		
		FlowerEntity flowerEntity = new FlowerEntity(flowerUpdateDto.getFlowerId(), flowerUpdateDto.getFlowerName().trim(), countryEntity.getCountryName().trim());
		FlowerEntity responseEntity = flowerRepository.save(flowerEntity);
		
		return mappingEntityToDTO(responseEntity, countryEntity);
		
	}

	@Override
	public void delete(int id) throws InvalidNameException, NotFoundException {
		
		if(!Validations.isValidNumber(Integer.toString(id))) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_ID);
		}
				
		FlowerEntity flower = flowerRepository.findById(id)
						.orElseThrow(() -> new NotFoundException(Constants.Messages.NOT_FOUND));
		
		flowerRepository.deleteById(flower.getFlowerId());
	}
		

	@Override
	public FlowerDTO getOne(int id) throws InvalidNameException, NotFoundException {
		
		if(!Validations.isValidNumber(Integer.toString(id))) {
			
			throw new InvalidNameException(Constants.Messages.INVALID_ID);
		}
		
		FlowerEntity flower = flowerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(Constants.Messages.NOT_FOUND));
		
		CountryEntity countryEntity = countryRepository.findById(flower.getFlowerCountry())
				.orElseThrow(() -> new NotFoundException(Constants.Messages.NOT_FOUND));
		
		return mappingEntityToDTO(flower, countryEntity);
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
