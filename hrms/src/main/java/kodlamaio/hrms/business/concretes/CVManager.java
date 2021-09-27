package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVDao;
import kodlamaio.hrms.entities.concretes.CV;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CVManager implements CVService {

	private final CVDao cvDao;

	@Override
	public DataResult<List<CV>> getCV(int candidateId) {
		return new SuccessDataResult<List<CV>>(this.cvDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result add(CV cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Added successfully");
	}

}
