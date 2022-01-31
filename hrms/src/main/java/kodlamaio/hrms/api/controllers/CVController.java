package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/cvs")
@RequiredArgsConstructor
public class CVController {

	@NonNull
	private CVService cvService;

	@PostMapping("/add")
	public Result add(@RequestBody CV cv) {
		return this.cvService.add(cv);
	}

	@GetMapping("/getcv")
	public DataResult<List<CV>> getCv(@RequestParam int candidateId) {
		return this.cvService.getCV(candidateId);
	}
	
	@Transactional
	@PutMapping("/updateCvCreationDate")
	public Result updateCvCreationDate(@RequestParam int id) {
		return this.cvService.updateCreationDate(id);
		
	}
}
