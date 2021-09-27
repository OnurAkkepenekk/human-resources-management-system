package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillForCVDao;
import kodlamaio.hrms.entities.concretes.SkillForCV;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillForCVManager implements SkillForCVService {

	private final SkillForCVDao skillForCVDao;

	@Override
	public Result add(SkillForCV skillForCV) {
		this.skillForCVDao.save(skillForCV);
		return new SuccessResult("Skill For CV added");
	}

}
