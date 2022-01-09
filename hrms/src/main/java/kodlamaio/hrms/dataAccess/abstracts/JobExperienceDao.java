package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.JobExperienceDto"
			+ "(e.id, j.firstName,j.lastName,e.workPlaceName,e.jobPosition,e.startDate,e.quitDate)"
			+ "From Candidate j Inner Join j.cvs c Inner Join c.jobExperiences e "
			+ "Where j.id =:id")
	List<JobExperienceDto> getJobExperiences(@Param("id") int id);
}