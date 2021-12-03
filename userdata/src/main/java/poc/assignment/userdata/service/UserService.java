package poc.assignment.userdata.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	// Search User by Name or Surname or mobileNo
	public List<User> searchUser(String field) {
		Long check;
		try {
			check = Long.parseLong(field);
		} catch (Exception e) {
			check = 0L;
		}
		return userRepo.findUserByUserNameOrSurNameOrMobileNo(field, field, check);
	}

	// Edit User base on user id
	public User updateUser(User user, Long id) {
		User getUser = user;
		getUser.setUserId(id);
		return userRepo.save(getUser);
	}

	// Sort User by DOB & Joining Date
	public List<User> getAllSortedByDob() {
		return userRepo.findAll(Sort.by(Direction.ASC, "dateOfBirth"));
	}

	public List<User> getAllSortedByDateOfJoining() {
		return userRepo.findAll(Sort.by(Direction.ASC, "dateOfJoining"));
	}
	
	public void deleteById(Long userId) {
		User user = userRepo.findById(userId).get();
		userRepo.deleteById(userId);
	}
	
	public void removeById(Long userId) {
		userRepo.deleteById(userId);
	}

}
