package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillManager implements SkillService {

	private final SkillDao skillDao;
	
	@Override
	@Transactional
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill added.");
	}

}
