package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class JobAdvertisementManager implements JobAdvertisementService {

	private final JobAdvertisementDao jobAdvertDao;

	@Override
	@Transactional
	public Result add(JobAdvertisement jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		log.info("Job advertisement added");
		return new SuccessResult("Job advertisement added");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {

		ArrayList<JobAdvertisementDto> jobAdvertisementDtoList = new ArrayList<JobAdvertisementDto>();

		for (JobAdvertisement advertisement : this.jobAdvertDao.findAll()) {
			JobAdvertisementDto jobAdvertisementDto = new JobAdvertisementDto();
			jobAdvertisementDto.setId(advertisement.getId());
			jobAdvertisementDto.setCityName(advertisement.getCity().getCityName());
			jobAdvertisementDto.setEmployerId(advertisement.getEmployer().getId());
			jobAdvertisementDto.setActive((advertisement.isActive()));
			jobAdvertisementDto.setCompanyName(advertisement.getEmployer().getCompanyName());
			jobAdvertisementDto.setJobDescription(advertisement.getJobDescription());
			jobAdvertisementDto.setJobPosition(advertisement.getJobPosition().getJobTitle());
			jobAdvertisementDto.setMaxSalary(advertisement.getMaxSalary());
			jobAdvertisementDto.setMinSalary(advertisement.getMinSalary());
			jobAdvertisementDto.setOpenPositionCount(advertisement.getOpenPositionCount());
			jobAdvertisementDto.setWorkTimeTypeName(advertisement.getWorkTimeType().getWorkTimeTypeName());
			jobAdvertisementDto.setWorkTypeName(advertisement.getWorkType().getWorkTypeName());
			jobAdvertisementDto.setLastApplyDate(advertisement.getLastApplyDate());
			jobAdvertisementDto.setPublishDate(advertisement.getPublishDate());
			jobAdvertisementDto.setWebAddress(advertisement.getEmployer().getWebAddress());
			jobAdvertisementDto.setClickCount(advertisement.getClickCount());
			jobAdvertisementDtoList.add(jobAdvertisementDto);
		}
		return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisementDtoList);
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
			return new ErrorDataResult<JobAdvertisement>("Job advertisements were not found to match the criteria. "
					+ "No such job posting for this job posting does not belong to this company.");
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		this.jobAdvertDao.save(jobAdvertisementToUpdate);
		return new SuccessDataResult<JobAdvertisement>("The specified job advertisement has been "
				+ (jobAdvertisementToUpdate.isActive() ? "active" : "deactivated"));
	}

	@Override
	public DataResult<JobAdvertisementDto> findById(int id) {
		if (jobAdvertDao.existsById(id)) {
			JobAdvertisementDto jobAdvertisementDto = new JobAdvertisementDto();
			JobAdvertisement advertisement = this.jobAdvertDao.findById(id);
			jobAdvertisementDto.setId(advertisement.getId());
			jobAdvertisementDto.setCityName(advertisement.getCity().getCityName());
			jobAdvertisementDto.setEmployerId(advertisement.getEmployer().getId());
			jobAdvertisementDto.setActive(advertisement.isActive());
			jobAdvertisementDto.setCompanyName(advertisement.getEmployer().getCompanyName());
			jobAdvertisementDto.setJobDescription(advertisement.getJobDescription());
			jobAdvertisementDto.setJobPosition(advertisement.getJobPosition().getJobTitle());
			jobAdvertisementDto.setMaxSalary(advertisement.getMaxSalary());
			jobAdvertisementDto.setMinSalary(advertisement.getMinSalary());
			jobAdvertisementDto.setWebAddress(advertisement.getEmployer().getWebAddress());
			jobAdvertisementDto.setOpenPositionCount(advertisement.getOpenPositionCount());
			jobAdvertisementDto.setWorkTimeTypeName(advertisement.getWorkTimeType().getWorkTimeTypeName());
			jobAdvertisementDto.setWorkTypeName(advertisement.getWorkType().getWorkTypeName());
			jobAdvertisementDto.setPublishDate(advertisement.getPublishDate());
			jobAdvertisementDto.setLastApplyDate(advertisement.getLastApplyDate());
			jobAdvertisementDto.setClickCount(advertisement.getClickCount());
			log.info(String.format("Job Posting number %d found!", id));
			return new SuccessDataResult<JobAdvertisementDto>(jobAdvertisementDto);
		}
		throw new NotFoundException(String.format("Job advertisement number %d not found", id));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> searchJobAdvertisement(int cityId, int jobId, int workTimeTypeId,
			int workTypeId, String orderBy, String orderDirection) {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertDao.searchJobAdvertisement(cityId, jobId, workTimeTypeId, workTypeId), "Searched");
	}

	@Override
	public Result increaseClickCount(int id) {
		JobAdvertisement advertisement = jobAdvertDao.findById(id);
		advertisement.setClickCount(advertisement.getClickCount() + 1);
		jobAdvertDao.save(advertisement);
		return new SuccessResult("Increased the number of clicks");
	}
}
