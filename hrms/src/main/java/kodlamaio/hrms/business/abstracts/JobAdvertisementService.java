package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvert);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();
	
	DataResult<List<JobAdvertisement>>finfByIsActiveTrueAndEmployer_Id(int employerId);
}
