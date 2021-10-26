package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/educationinformations")
@RequiredArgsConstructor
@CrossOrigin
public class EducationInformationController {

	@NonNull
	private EducationInformationService educationInformationService;

	@PostMapping("/add")
	public Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);

	}

	@GetMapping("/getEducationInformationsByUserId")
	public DataResult<List<EducationInformationDto>> getEducationInformationsByUserId(@RequestParam("candidateId") int candidateId) {

		return this.educationInformationService.getEducationInformationsByUserId(candidateId);
	}
}
