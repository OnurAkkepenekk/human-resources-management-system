package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoverLetterManager implements CoverLetterService {

	private final CoverLetterDao coverLetterDao;
	
	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Added successfully");
	}

	@Override
	public DataResult<List<CoverLetterDto>> getCoverLetterByCvId(int cvId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CoverLetterDto>>(this.coverLetterDao.getCoverLetterByCvId(cvId));
	}

}
