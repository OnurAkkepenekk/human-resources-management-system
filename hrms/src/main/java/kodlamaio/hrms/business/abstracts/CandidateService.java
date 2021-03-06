package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getById(int id);
	
	Result add(Candidate candidate);

	DataResult<CandidateDto> update(CandidateDto candidate);
}
