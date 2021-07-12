package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTimeType;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/worktimetype")
@CrossOrigin
public class WorkTimeTypeController {

	WorkTimeTypeService workTimeTypeService;

	@Autowired
	public WorkTimeTypeController(WorkTimeTypeService workTimeTypeService) {
		super();
		this.workTimeTypeService = workTimeTypeService;
	}

	@PostMapping("/add")
	Result add(@RequestBody WorkTimeType workTimeType) {
		return this.workTimeTypeService.add(workTimeType);
	}

	@GetMapping("/getall")
	DataResult<List<WorkTimeType>> getAll() {
		return this.workTimeTypeService.getAll();
	}
}
