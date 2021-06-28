package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillForCVDao;
import kodlamaio.hrms.entities.concretes.SkillForCV;

@Service
public class SkillForCVManager implements SkillForCVService {

	SkillForCVDao skillForCVDao;

	@Autowired
	public SkillForCVManager(SkillForCVDao skillForCVDao) {
		super();
		this.skillForCVDao = skillForCVDao;
	}

	@Override
	public Result add(SkillForCV skillForCV) {
		this.skillForCVDao.save(skillForCV);
		return new SuccessResult("Skill For CV added");
	}

}
