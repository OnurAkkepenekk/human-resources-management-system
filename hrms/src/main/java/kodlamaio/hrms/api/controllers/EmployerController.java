package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
@RequiredArgsConstructor
public class EmployerController {
	@NonNull
	private EmployerService employerService;

	@GetMapping("/getall")
	public DataResult<List<Employer>>getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/id")
	public DataResult<Employer>getEmployerByEmployerId(int id){
		return this.employerService.getEmployerByEmployerId(id);		
	}
}
