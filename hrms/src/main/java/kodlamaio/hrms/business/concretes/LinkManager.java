package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LinkManager implements LinkService {

	private final LinkDao linkdao;

	@Override
	public Result add(Link link) {
		this.linkdao.save(link);
		return new SuccessResult("Added link");
	}
}
