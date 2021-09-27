package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/foreignlanguage")
@RequiredArgsConstructor
public class ForeignLanguageController {

	@NonNull
	private ForeignLanguageService foreignLanguageService;

	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage ForeignLanguage) {
		return this.foreignLanguageService.add(ForeignLanguage);
	}
}
