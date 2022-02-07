package kodlamaio.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = -9028567632061974148L;

	public EmailAlreadyExists(String message) {
		super(message);

	}
}
