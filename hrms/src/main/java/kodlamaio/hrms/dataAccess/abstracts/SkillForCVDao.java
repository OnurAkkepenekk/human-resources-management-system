package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.SkillForCV;
import kodlamaio.hrms.entities.dtos.SkillWithCVDto;

public interface SkillForCVDao extends JpaRepository<SkillForCV, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.SkillWithCVDto"
			+ "(s.skillName)"
			+ "From SkillForCV scv INNER JOIN scv.skill s INNER JOIN scv.cv cv"
			+ " Where cv.id =:cvId")
	List<SkillWithCVDto> getSkills(@Param("cvId")int cvId);
}