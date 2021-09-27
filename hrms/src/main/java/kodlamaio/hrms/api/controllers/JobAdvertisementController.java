package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
@RequiredArgsConstructor
public class JobAdvertisementController {
	@NonNull
	private JobAdvertisementService advertisementService;


	@PostMapping("/add")
	public Result Add(@RequestBody JobAdvertisement jobAdvert) {
		return this.advertisementService.add(jobAdvert);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.advertisementService.getAll();
	}

	@GetMapping("/findByIsActiveTrueOrderByPublishDate")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate() {
		return this.advertisementService.findByIsActiveTrueOrderByCreateDate();
	}

	@GetMapping("/finfByIsActiveTrueAndEmployer_Id")
	public DataResult<List<JobAdvertisement>> finfByIsActiveTrueAndEmployer_Id(int employer_Id) {
		return this.advertisementService.finfByIsActiveTrueAndEmployer_Id(employer_Id);
	}

	@GetMapping("/changeStatus")
	public DataResult<JobAdvertisement> changeStatus(int advertisementId, int employer_Id) {
		return this.advertisementService.findByIdAndEmployer_Id(advertisementId, employer_Id);
	}
	@GetMapping("/id")
	public DataResult<JobAdvertisement> findById(int id) {
		return this.advertisementService.findById(id);
	}
}
