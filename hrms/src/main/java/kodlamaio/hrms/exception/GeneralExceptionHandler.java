package kodlamaio.hrms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(x -> {
			String fieldName = ((FieldError) x).getField();
			String errorMessage = x.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailAlreadyExists.class)
	public ResponseEntity<?> emailAlreadyExists(EmailAlreadyExists e) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", e.getMessage());
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(CityAlreadyExists.class)
	public ResponseEntity<?> cityAlreadyExists(EmailAlreadyExists e) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", e.getMessage());
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(EmailAlreadyExists e) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", e.getMessage());
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	}
}
