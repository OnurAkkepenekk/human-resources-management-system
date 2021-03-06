package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobManager implements JobService {

	private final JobDao jobDao;

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Listed jobs");
	}

	@Override
	@Transactional
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("Job added successfully");
	}

}
