package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services;

import java.util.List;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.InvalidNameException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.NotFoundException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerAddRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerUpdateRequestDTO;



public interface FlowerService {
	 
	public FlowerDTO add(FlowerAddRequestDTO flowerAddRequestDto) throws InvalidNameException;
	public FlowerDTO update(FlowerUpdateRequestDTO flowerUpdateDto) throws NotFoundException, InvalidNameException;
	public void delete(int id) throws InvalidNameException, NotFoundException;
	public FlowerDTO getOne(int id) throws InvalidNameException, NotFoundException;
	public List<FlowerDTO> getAll();
}
