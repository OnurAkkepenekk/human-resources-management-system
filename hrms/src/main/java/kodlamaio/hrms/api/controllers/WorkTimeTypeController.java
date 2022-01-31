package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTimeType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/worktimetype")
@RequiredArgsConstructor
public class WorkTimeTypeController {
	@NonNull
	private WorkTimeTypeService workTimeTypeService;

	@PostMapping("/add")
	Result add(@RequestBody WorkTimeType workTimeType) {
		return this.workTimeTypeService.add(workTimeType);
	}

	@GetMapping("/getall")
	DataResult<List<WorkTimeType>> getAll() {
		return this.workTimeTypeService.getAll();
	}
}
