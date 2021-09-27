package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobExperienceManager implements JobExperienceService {

	private final JobExperienceDao jobExperienceDao;

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Add successfull");
	}

	@Override
	public DataResult<List<JobExperienceDto>> getJobExperiencesByUserId(int candidateId) {
		return new SuccessDataResult<List<JobExperienceDto>>(this.jobExperienceDao.getJobExperiences(candidateId));
	}
}
