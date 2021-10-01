package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employee;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
@RequiredArgsConstructor
public class EmployeeController {
	@NonNull
	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public DataResult<List<Employee>>getAll(){
		return this.employeeService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee){
		 
		 return this.employeeService.add(employee);
	}
}
