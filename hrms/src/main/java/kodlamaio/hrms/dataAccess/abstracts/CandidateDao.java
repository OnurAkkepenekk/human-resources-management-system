package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	Candidate findById(int id);
	Boolean existsByEmail(String email);
	@Query(" select count(c)>0 from Candidate c where c.email =:email")
	Boolean findByEmail(String email);
}
