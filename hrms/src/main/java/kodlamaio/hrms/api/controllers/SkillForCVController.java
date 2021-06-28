package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillForCV;

@RestController
@RequestMapping("api/skillForCV")
public class SkillForCVController {

	SkillForCVService skillForCVService;

	@Autowired
	public SkillForCVController(SkillForCVService skillForCVService) {
		super();
		this.skillForCVService = skillForCVService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SkillForCV skillForCV) {
		return this.skillForCVService.add(skillForCV);

	}
}
