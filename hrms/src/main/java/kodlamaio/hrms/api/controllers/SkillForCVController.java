package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillForCV;
import kodlamaio.hrms.entities.dtos.SkillWithCVDto;
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

	@GetMapping("/getSkillsInfoByCvId")
	public DataResult<List<SkillWithCVDto>> getSkillsInfoByCvId(@RequestParam int cvId) {
		return this.skillForCVService.getSkillsByCvId(cvId);
	}
}
