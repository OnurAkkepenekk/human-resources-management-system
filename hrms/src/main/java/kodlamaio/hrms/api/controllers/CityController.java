package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/cities")
@RequiredArgsConstructor
public class CityController {

	@NonNull
	private CityService cityService;

	@GetMapping("/getall")
	public DataResult<List<City>> getCities() {
		return this.cityService.getCities();
	}
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}

}
