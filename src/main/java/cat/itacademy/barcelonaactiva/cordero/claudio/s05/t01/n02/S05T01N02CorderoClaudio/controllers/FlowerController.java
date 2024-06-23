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

import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.InvalidNameException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions.NotFoundException;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerAddRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.dto.FlowerUpdateRequestDTO;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.model.services.FlowerService;
import cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.utils.Constants;


@RestController
public class FlowerController {

	@Autowired
	private FlowerService flowerService;
	
	private static Logger logger = LoggerFactory.getLogger(FlowerController.class);
	
	
	@PostMapping("/flowers/add")
	public ResponseEntity<FlowerDTO> add(@RequestBody FlowerAddRequestDTO flowerAddRequestDto) throws InvalidNameException{
		
		logger.info("FlowerController :: add :: Add a flower.");
		
		return ResponseEntity.status(HttpStatus.OK).body(flowerService.add(flowerAddRequestDto));
	}
	
	
	@PutMapping("/flowers/update")
    public ResponseEntity<FlowerDTO> update(@RequestBody FlowerUpdateRequestDTO flowerUpdateDto) throws NotFoundException, InvalidNameException{
		
		logger.info("FlowerController :: update :: Update a flower.");
		
		return ResponseEntity.status(HttpStatus.OK).body(flowerService.update(flowerUpdateDto));
		
	}
	
	@DeleteMapping("/flowers/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) throws InvalidNameException, NotFoundException {
		
		logger.info("FlowerController :: delete :: Delete a flower.");
		
		flowerService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(Constants.Messages.DELETED);

	}
	
	@GetMapping("/flowers/getOne/{id}")
	public ResponseEntity<FlowerDTO> getOne(@PathVariable int id) throws InvalidNameException, NotFoundException{
		
		logger.info("FlowerController :: getOne :: Find a flower.");
		
		return ResponseEntity.status(HttpStatus.OK).body(flowerService.getOne(id));
		
	}
	
	@GetMapping("/flowers/getAll")
	public ResponseEntity<List<FlowerDTO>> getAll(){
		
		logger.info("FlowerController :: getAll :: List all flowers.");
		
		List<FlowerDTO> flowers = flowerService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(flowers);
	}
}
