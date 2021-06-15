package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByIsActiveTrueOrderByPublishDate();

	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId);

	JobAdvertisement findByIdAndEmployer_Id(int jobadvertisement, int employerId);
}
