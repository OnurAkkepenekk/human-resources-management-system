package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CV;

public interface CVDao extends JpaRepository<CV, Integer> {

	List<CV> getByCandidate_Id(int candidateId);

	@Modifying
	@Query("update CV c set c.creationDate = :date where c.id = :id")
	void updateCreationDate(int id, Date date);

	boolean findByCandidateId(int candidateId);

	boolean existsByCandidate_Id(int candidateId);
}
