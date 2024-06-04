package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerAddRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerResponseDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerUpdateRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services.FlowerService;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils.Constants;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils.Validations;

@RestController
public class FlowerController {

	@Autowired
	private FlowerService flowerService;
	
	private static Logger logger = LoggerFactory.getLogger(FlowerController.class);
	
	@PostMapping("/flowers/add")
	public ResponseEntity<FlowerResponseDTO> add(@RequestBody FlowerAddRequestDTO flowerAddRequestDto){
		
		if(!Validations.isValidName(flowerAddRequestDto.getFlowerName().trim())) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_NAME);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		if(!Validations.isValidName(flowerAddRequestDto.getFlowerCountry().trim())) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_COUNTRY);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		FlowerDTO flowerDto = flowerService.add(flowerAddRequestDto.getFlowerName().trim(), flowerAddRequestDto.getFlowerCountry().trim());
		
		if(flowerDto != null) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setMessage(Constants.Messages.ADDED);
			response.setFlower(flowerDto);
			logger.info("FlowerController :: add :: Flower was added correctly.");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.ERROR_INSERT);
			logger.info("FlowerController :: add :: Error trying to insert flower.");
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(response);
		}
	}
	
	@PutMapping("/flowers/update")
    public ResponseEntity<FlowerResponseDTO> update(@RequestBody FlowerUpdateRequestDTO flowerUpdateDto){
		
		if(!Validations.isValidNumber(Integer.toString(flowerUpdateDto.getFlowerId()))) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_ID);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		if(!Validations.isValidName(flowerUpdateDto.getFlowerName().trim())) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_NAME);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		FlowerDTO flowerDto = flowerService.update(flowerUpdateDto.getFlowerId(), flowerUpdateDto.getFlowerName().trim(), flowerUpdateDto.getFlowerCountry().trim());
		
		if(flowerDto != null) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setMessage(Constants.Messages.UPDATED);
			response.setFlower(flowerDto);
			logger.info("FlowerController :: update :: Flower was updated correctly.");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_COUNTRY);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	@DeleteMapping("/flowers/delete/{id}")
	public ResponseEntity<FlowerResponseDTO> delete(@PathVariable int id) {
		
		
		if(!Validations.isValidNumber(Integer.toString(id))) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_ID);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		flowerService.delete(id);
		
	    FlowerResponseDTO response = new FlowerResponseDTO();
	    response.setMessage(Constants.Messages.DELETED);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@GetMapping("/flowers/getOne/{id}")
	public ResponseEntity<FlowerResponseDTO> getOne(@PathVariable int id){
		
		if(!Validations.isValidNumber(Integer.toString(id))) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setError(Constants.Messages.INVALID_ID);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		FlowerDTO flowerDto = flowerService.getOne(id);
		
		if(flowerDto != null) {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setMessage(Constants.Messages.FOUND);
			response.setFlower(flowerDto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			FlowerResponseDTO response = new FlowerResponseDTO();
			response.setMessage(Constants.Messages.NOT_FOUND);
			response.setFlower(flowerDto); //FlowerDto is null.
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	@GetMapping("/flowers/getAll")
	public ResponseEntity<List<FlowerDTO>> getAll(){
		
		logger.info("FlowerController :: getAll :: List all flowers.");
		
		List<FlowerDTO> flowers = flowerService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(flowers);
	}
}
