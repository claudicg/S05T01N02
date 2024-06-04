package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services;

import java.util.List;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;



public interface FlowerService {
	 
	public FlowerDTO add(String flowerName, String flowerCountry);
	public FlowerDTO update(int id, String flowerName, String flowerCountry);
	public void delete(int id);
	public FlowerDTO getOne(int id);
	public List<FlowerDTO> getAll();
}
