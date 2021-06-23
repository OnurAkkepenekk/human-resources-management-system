package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationDto"
			+ "(candidate.firstName, candidate.lastName, u.universityName, d.departmentName,i.startDate,i.graduateDate) "
			+ "From Candidate candidate Inner Join candidate.cvs c Inner Join c.educationInformations i Inner Join i.universityDepartment d Inner Join i.university u"
			+ " Where candidate.id =:id ORDER BY i.startDate DESC")
	List<EducationInformationDto> getEducationInformations(@Param("id") int id);
}
