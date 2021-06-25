package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkdao;

	@Autowired
	public LinkManager(LinkDao linkdao) {
		super();
		this.linkdao = linkdao;
	}

	@Override
	public Result add(Link link) {
		this.linkdao.save(link);
		return new SuccessResult("Added link");
	}
}
