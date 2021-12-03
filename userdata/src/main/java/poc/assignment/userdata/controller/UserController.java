package poc.assignment.userdata.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.service.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/userdata")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		System.out.println(user);
		User userSave = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
	}

	@GetMapping("/findByfield/{field}")
	public ResponseEntity<List<User>> findByfield(@PathVariable String field) {
		List<User> getUserByName = userService.searchUser(field);
		return ResponseEntity.status(HttpStatus.OK).body(getUserByName);
	}

	@PostMapping("/updateById/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long userId) {
		User updateById = userService.updateUser(user, userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateById);
	}

	@GetMapping("/sortByDob")
	public ResponseEntity<List<User>> sortByDob(){
		List<User> findAllSorted = userService.getAllSortedByDob();
		return ResponseEntity.status(HttpStatus.OK).body(findAllSorted);
	}
	@GetMapping("/sortByDoj")
	public ResponseEntity<List<User>> sortByDateOfJoining(){
		List<User> findAllSorted = userService.getAllSortedByDateOfJoining();
		return ResponseEntity.status(HttpStatus.OK).body(findAllSorted);
	}
	@GetMapping("/deleteUser/{userId}")
	public String deleteById(@PathVariable Long userId){
		userService.deleteById(userId);
		return "user deleted sucessfully";
	}
	
	@GetMapping("/removeUser/{userId}")
	public String removeById(@PathVariable Long userId){
		userService.removeById(userId);
		return "user removed sucessfully";
	}
}
