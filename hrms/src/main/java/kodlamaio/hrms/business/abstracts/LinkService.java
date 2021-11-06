package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.dtos.LinkDto;

public interface LinkService {

	Result add(Link link);

	DataResult<List<LinkDto>> getLinksByCvId(int cvId);
}
