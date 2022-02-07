package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/candidate")
@RequiredArgsConstructor
public class CandidateController {
	@NonNull
	private CandidateService candidateService;

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	@GetMapping("/findbyid")
	public DataResult<Candidate>findById(int id){
		return this.candidateService.getById(id); 
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Candidate candidate){
		return this.candidateService.add(candidate); 
	}
	
	@PutMapping("/update")
	public DataResult<CandidateDto> update(@RequestBody CandidateDto candidate) {
		return this.candidateService.update(candidate);
	}
}
