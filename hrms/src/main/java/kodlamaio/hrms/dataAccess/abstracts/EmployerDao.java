package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findById(int id);
	Employer findByCompanyName(String companyName);
	boolean existsByEmail(String email);
}
