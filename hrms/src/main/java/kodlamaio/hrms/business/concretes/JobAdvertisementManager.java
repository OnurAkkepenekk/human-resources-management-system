package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
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
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertDao.findAll(), "Listed job advertisement ");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertDao.findByIsActiveTrueOrderByPublishDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> finfByIsActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertDao.findByIsActiveTrueAndEmployer_Id(employerId),
				"Listed job advertisement for employerId");
	}

	@Override
	public DataResult<JobAdvertisement> findByIdAndEmployer_Id(int jobadvertisementId, int employerId) {
		JobAdvertisement jobAdvertisementToUpdate = this.jobAdvertDao.findByIdAndEmployer_Id(jobadvertisementId,
				employerId);
		if (jobAdvertisementToUpdate == null)
			return new ErrorDataResult<JobAdvertisement>(
					"Job advertisements were not found to match the criteria. No such job posting for this job posting does not belong to this company.");
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		this.jobAdvertDao.save(jobAdvertisementToUpdate);
		return new SuccessDataResult<JobAdvertisement>("The specified job advertisement has been "
				+ (jobAdvertisementToUpdate.isActive() ? "active" : "deactivated"));
	}

}
