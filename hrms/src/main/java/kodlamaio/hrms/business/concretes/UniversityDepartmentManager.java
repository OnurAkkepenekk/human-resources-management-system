package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UniversityDepartmentManager implements UniversityDepartmentService {

	private final UniversityDepartmentDao universityDepartmentDao;

	@Override
	public Result add(UniversityDepartment universityDepartment) {
		this.universityDepartmentDao.save(universityDepartment);
		return new SuccessResult("UniversityDepartment adding successful");
	}

}
