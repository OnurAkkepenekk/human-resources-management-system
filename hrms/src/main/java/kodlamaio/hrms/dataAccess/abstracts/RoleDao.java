package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{
	 Role findByName(String roleName);
}
