package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillForCV;
import kodlamaio.hrms.entities.dtos.SkillWithCVDto;

public interface SkillForCVService {

	Result add(SkillForCV skillForCD);

	DataResult<List<SkillWithCVDto>> getSkillsByCvId(int cvId);
}
