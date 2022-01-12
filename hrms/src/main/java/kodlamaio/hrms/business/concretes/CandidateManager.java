package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public DataResult<Candidate> getById(@RequestParam int id) {
		if (this.candidateDao.existsById(id)) {
			return new SuccessDataResult<Candidate>(this.candidateDao.findById(id));
		}
		return new ErrorDataResult<>("User not found");
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added successfully");
	}


	@Override
	public DataResult<CandidateDto> update(CandidateDto candidateDto) {
		if (this.candidateDao.existsById(candidateDto.getId())) {
			Candidate candidate = new Candidate();
			candidate.setFirstName(candidateDto.getFirstName());
			candidate.setLastName(candidateDto.getLastName());
			candidate.setBirthDate(candidateDto.getBirthDate());
			candidate.setEmail(candidateDto.getEmail());
			candidate.setGender(candidateDto.getGender());
			candidate.setIdentityNumber(candidateDto.getIdentityNumber());
			candidate.setId(candidateDto.getId());
			this.candidateDao.save(candidate);
			
			System.out.println(this.candidateDao.findById(candidateDto.getId()));
			return new SuccessDataResult<CandidateDto>(candidateDto,"Update successfull");
		}
		return new SuccessDataResult<CandidateDto>("Update Error");
	}

}
