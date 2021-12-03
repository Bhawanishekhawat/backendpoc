package poc.assignment.userdata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.assignment.userdata.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	List<User> findUserByUserNameOrSurNameOrMobileNo(String userName, String surName, Long mobileNo);

}
