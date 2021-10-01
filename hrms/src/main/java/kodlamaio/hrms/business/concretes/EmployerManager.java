package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Listed employers");
	}

	@Override
	public DataResult<Employer> getEmployerByEmployerId(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id));
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer added.");
	}

	@Override
	public DataResult<Employer> getEmployerByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName));
	}

}
