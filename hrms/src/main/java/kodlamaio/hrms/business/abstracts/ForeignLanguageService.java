package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDtoCv;

public interface ForeignLanguageService {

	public Result add(ForeignLanguage foreignLanguage);

	public DataResult<List<ForeignLanguageDtoCv>> getForeignLanguageListByCvId(int cvId);
}
