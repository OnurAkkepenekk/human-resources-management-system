package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CV;

public interface CVDao extends JpaRepository<CV, Integer> {

	List<CV> getByCandidate_Id(int candidateId);
}
