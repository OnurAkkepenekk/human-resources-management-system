package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/candidate")
@CrossOrigin
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
}
