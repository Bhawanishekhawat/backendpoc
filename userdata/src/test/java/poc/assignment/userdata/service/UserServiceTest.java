package poc.assignment.userdata.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.repo.UserRepo;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserRepo userRepo;

//	@Test
//	void testSaveUser() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testSearchUser() {
		
		User user = new User();
		List<User> userList = new ArrayList();
		userList.add(user);
		user.setUserName("mohan");
		user.setSurName("Sharma");
		user.setDateOfJoining(new Date(2021 / 10 / 27));
		user.setDateOfBirth(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmail("kartik@gmail.com");
		user.setCity("dwarka");
		user.setState("delhi");
		List<User> usersList=  userService.searchUser("name");
		when(userRepo.findUserByUserNameOrSurNameOrMobileNo("mohan","Sharma",9876545789L)).
				thenReturn(userList);
		
		assertEquals(usersList.size(), userList.size());
	}
		
		

//
//	@Test
//	void testUpdateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllSortedByDob() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllSortedByDateOfJoining() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRemoveById() {
//		fail("Not yet implemented");
//	}

}
