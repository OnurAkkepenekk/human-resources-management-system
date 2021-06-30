package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV;

public interface CVService {

	DataResult<List<CV>> getCV(int candidateId);

	Result add(CV cv);
}
