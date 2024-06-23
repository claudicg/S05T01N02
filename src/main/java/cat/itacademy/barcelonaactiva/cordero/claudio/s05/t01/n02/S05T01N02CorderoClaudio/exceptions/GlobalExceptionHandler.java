package cat.itacademy.barcelonaactiva.cordero.claudio.s05.t01.n02.S05T01N02CorderoClaudio.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ErrorMessage> invalidIdException(InvalidIdException exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
									HttpStatus.BAD_REQUEST.value(),
									new Date(),
									exception.getMessage(),
									request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NotFoundException.class) 
	public ResponseEntity<ErrorMessage> notFoundException(NotFoundException exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
									HttpStatus.NOT_FOUND.value(),
									new Date(),
									exception.getMessage(),
									request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidNameException.class)
	public ResponseEntity<ErrorMessage> invalidNameException(InvalidNameException exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
									HttpStatus.BAD_REQUEST.value(),
									new Date(),
									exception.getMessage(),
									request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	}
}
