package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService {

	@Override
	public DataResult<List<User>> getAll() {
		return null;
	}

}
