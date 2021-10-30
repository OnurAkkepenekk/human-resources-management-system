package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobexperiences")
@RequiredArgsConstructor
@CrossOrigin
public class JobExperienceController {

	@NonNull
	private JobExperienceService jobExprienceService;

	@PostMapping("/add")
	public Result add(@RequestBody JobExperience JobExperience) {
		return this.jobExprienceService.add(JobExperience);

	}

	@GetMapping("/getjobexperiencesbyuserid")
	public DataResult<List<JobExperienceDto>> getJobExperiencesByUserId(@RequestParam int cadidateId) {
		return this.jobExprienceService.getJobExperiencesByUserId(cadidateId);
	}
}
