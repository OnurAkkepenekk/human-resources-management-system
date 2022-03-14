package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Role;

public interface UserService {
	User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);

    User getUser(String email);

    List<User> getUsers();
}
