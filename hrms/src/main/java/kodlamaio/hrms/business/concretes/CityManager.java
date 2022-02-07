package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.exception.CityAlreadyExists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CityManager implements CityService{

	public final CityDao cityDao;
	

	@Override
	public DataResult<List<City>> getCities() {
		log.info("Listed cities");
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Listed cities");
	}


	@Override
	@Transactional
	public Result add(City city) {
		if(!cityDao.existsByCityName(city.getCityName()))
		{
			this.cityDao.save(city);
			log.info("Listed cities");
			return new SuccessResult("Added success");	
		}
		throw new CityAlreadyExists("City already added"); 
	}

}
