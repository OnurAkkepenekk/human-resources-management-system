package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillForCV;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/skillForCV")
@RequiredArgsConstructor
public class SkillForCVController {
	@NonNull
	private SkillForCVService skillForCVService;

	@PostMapping("/add")
	public Result add(@RequestBody SkillForCV skillForCV) {
		return this.skillForCVService.add(skillForCV);

	}
}
