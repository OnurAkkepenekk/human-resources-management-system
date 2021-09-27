package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Job;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
@RequiredArgsConstructor
public class JobsController {
	@NonNull
	private JobService jobService;

	@GetMapping("/getall")
	public DataResult<List<Job>> getAll() {
		return this.jobService.getAll();
	}
}
