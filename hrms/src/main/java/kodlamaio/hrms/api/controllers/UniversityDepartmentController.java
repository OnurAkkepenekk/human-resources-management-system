package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/universitydepartments")
@RequiredArgsConstructor
public class UniversityDepartmentController {

	@NonNull
	private UniversityDepartmentService universityDepartmentService;

	@PostMapping("/add")
	public Result add(@RequestBody UniversityDepartment universityDepartment) {
		return this.universityDepartmentService.add(universityDepartment);

	}
}
