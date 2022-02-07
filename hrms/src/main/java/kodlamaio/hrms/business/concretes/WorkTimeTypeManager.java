package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeTypeDao;
import kodlamaio.hrms.entities.concretes.WorkTimeType;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkTimeTypeManager implements WorkTimeTypeService {

	private final WorkTimeTypeDao workTimeTypeDao;


	@Override
	@Transactional
	public Result add(WorkTimeType workTimeType) {
		this.workTimeTypeDao.save(workTimeType);
		return new SuccessResult("Added successfully");
	}

	@Override
	public DataResult<List<WorkTimeType>> getAll() {
		return new SuccessDataResult<List<WorkTimeType>>(this.workTimeTypeDao.findAll());
	}

}
