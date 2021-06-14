package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvert) {
		super();
		this.jobAdvertDao = jobAdvert;
	}

	@Override
	public Result add(JobAdvertisement jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advertisement has been added.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertDao.findAll(),"Listed job advertisement ");
	}

}
