package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.CoverLetterDto"
			+ "(cl.id , cl.covverLetter)"
			+ "From CoverLetter cl INNER JOIN cl.cv clcv"
			+ " Where clcv.id =:cvId")
	List<CoverLetterDto> getCoverLetterByCvId(int cvId);

}
