package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkType;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/worktype")
@RequiredArgsConstructor
public class WorkTypeController {
	@NonNull
	private WorkTypeService workTypeService;

	@PostMapping("/add")
	Result add(@RequestBody WorkType workType) {
		return this.workTypeService.add(workType);
	}

	@GetMapping("/getall")
	DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
}
