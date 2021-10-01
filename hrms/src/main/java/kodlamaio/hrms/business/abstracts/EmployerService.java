package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer>getEmployerByEmployerId(int id);
	DataResult<Employer>getEmployerByCompanyName(String companyName);
	Result add(Employer employer);
}
