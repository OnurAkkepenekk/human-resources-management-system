package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDtoCv;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/foreignlanguage")
@RequiredArgsConstructor
@CrossOrigin
public class ForeignLanguageController {

	@NonNull
	private ForeignLanguageService foreignLanguageService;

	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage ForeignLanguage) {
		return this.foreignLanguageService.add(ForeignLanguage);
	}
	
	@GetMapping("/getForeignLanguageListByCvId")
	public DataResult<List<ForeignLanguageDtoCv>> getForeignLanguageList(@RequestParam int cvId) {
		return this.foreignLanguageService.getForeignLanguageListByCvId(cvId);
		
	}
}
