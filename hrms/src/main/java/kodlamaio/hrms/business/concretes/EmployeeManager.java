package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.exception.NotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

	private final EmployeeDao employeeDao;

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "Listed employee");
	}
	@Override
	public DataResult<Employee> getById(int id) {
		if(employeeDao.existsById(id)) {
			return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
		}
		throw new NotFoundException("Employee not found");
		
	}
	@Override
	@Transactional
	public Result add(Employee employee){
		this.employeeDao.save(employee);
		return new SuccessResult("Successfull added.");
	}
}
