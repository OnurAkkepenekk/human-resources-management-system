package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDtoCv;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ForeignLanguageManager implements ForeignLanguageService {

	private final ForeignLanguageDao foreignLanguageDao;

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Added Successfully");
	}

	@Override
	public DataResult<List<ForeignLanguageDtoCv>> getForeignLanguageListByCvId(int cvId) {
		return new SuccessDataResult<List<ForeignLanguageDtoCv>>(this.foreignLanguageDao.getForeignLanguageByCvId(cvId));
	}

}
