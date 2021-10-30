package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.ForeignLanguage;
import kodlamaio.hrms.entities.dtos.ForeignLanguageDtoCv;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.ForeignLanguageDtoCv" + "(f.language, f.languageLevel)"
			+ "From ForeignLanguage f Inner JOIN f.cv cv" 
			+ " on cv.id =:cvId")
	List<ForeignLanguageDtoCv> getForeignLanguageByCvId(int cvId);

}
