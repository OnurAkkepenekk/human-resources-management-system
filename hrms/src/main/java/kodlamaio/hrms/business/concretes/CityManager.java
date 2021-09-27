package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityManager implements CityService{

	public final CityDao cityDao;
	

	@Override
	public DataResult<List<City>> getCities() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Listed cities");
	}


	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Added success");
	}

}
