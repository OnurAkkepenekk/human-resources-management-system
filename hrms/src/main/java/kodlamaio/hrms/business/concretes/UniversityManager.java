package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import kodlamaio.hrms.entities.concretes.University;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UniversityManager implements UniversityService {

	private final UniversityDao universityDao;

	@Override
	public Result add(University university) {
		this.universityDao.save(university);
		return new SuccessResult("Adding successful");
	}

}
