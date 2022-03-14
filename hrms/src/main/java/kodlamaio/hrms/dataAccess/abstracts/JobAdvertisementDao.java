package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByIsActiveTrueOrderByPublishDate();

	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId);

	JobAdvertisement findByIdAndEmployer_Id(int jobadvertisement, int employerId);

	JobAdvertisement findById(int id);

	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(ja.id, e.id, ja.jobDescription, ja.minSalary, ja.maxSalary, ja.openPositionCount, ja.city.cityName,"
			+ " ja.jobPosition.jobTitle, ja.workTimeType.workTimeTypeName, ja.workType.workTypeName, e.companyName, "
			+ " ja.isActive, ja.publishDate, ja.lastApplyDate, e.webAddress, ja.clickCount)"
			+ " From JobAdvertisement ja Inner Join ja.employer e "
			+ "Where ja.city.id =?1 AND ja.jobPosition.id =?2 "
			+ "AND ja.workTimeType.workTimeTypeId =?3 AND ja.workType.workTypeId=?4 ")
	List<JobAdvertisementDto> searchJobAdvertisement(int cityId, int jobId, int workTimeTypeId, int workTypeId);
}
