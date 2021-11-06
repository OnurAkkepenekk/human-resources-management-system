package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.dtos.LinkDto;

public interface LinkDao extends JpaRepository<Link, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.LinkDto"
			+ "(l.id , l.LinkName, l.url)"
			+ "From Link l INNER JOIN l.cv lcv"
			+ " Where lcv.id =:cvId")
	List<LinkDto> getLinksByCvId(@Param("cvId")int cvId);
}
