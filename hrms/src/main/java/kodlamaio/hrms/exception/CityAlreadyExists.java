package kodlamaio.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CityAlreadyExists extends RuntimeException {
	private static final long serialVersionUID = 394578272842746651L;

	public CityAlreadyExists(String message) {
		super(message);
	}
}
