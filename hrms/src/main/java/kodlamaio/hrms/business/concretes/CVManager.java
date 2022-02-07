package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVDao;
import kodlamaio.hrms.entities.concretes.CV;
import kodlamaio.hrms.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CVManager implements CVService {

	private final CVDao cvDao;

	@Override
	public DataResult<List<CV>> getCV(int candidateId) {
		if (cvDao.existsByCandidate_Id(candidateId)) {
			log.info("CVs are listed.");
			return new SuccessDataResult<List<CV>>(this.cvDao.getByCandidate_Id(candidateId));
		}
		throw new NotFoundException("Not found CV");
	}

	@Override
	@Transactional
	public Result add(CV cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Added successfully");
	}

	@Override
	@Transactional
	public Result updateCreationDate(int id) {
		if (cvDao.existsById(id)) {
			Date date = new Date(System.currentTimeMillis());
			this.cvDao.updateCreationDate(id, date);
			log.info("Creation date updated");
			return new SuccessResult("Creation date updated");
		}
		throw new NotFoundException("Not found exists id");
	}

}
