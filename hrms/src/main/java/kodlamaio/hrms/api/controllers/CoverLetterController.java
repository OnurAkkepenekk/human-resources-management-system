package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequestMapping("api/coverletter")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CoverLetterController {

	@NonNull
	private CoverLetterService coverLetterService;

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	
	@GetMapping("/getCoverLetterByCvId")
	public DataResult<List<CoverLetterDto>>getCoverLetterByCvId(@RequestParam int cvId){
		return this.coverLetterService.getCoverLetterByCvId(cvId);
	}
}
