package poc.assignment.userdata.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import poc.assignment.userdata.entity.User;
import poc.assignment.userdata.repo.UserRepo;
import poc.assignment.userdata.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
class UserControllerTest {
	
	@Autowired
	UserController userController;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	@Test
	@DisplayName("should create user")
	void testSaveUser() {

		MockHttpServletRequestBuilder saveUserRequestBuilder = MockMvcRequestBuilders.post("/userdata/saveUser")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "	\"userName\" : \"kartik\",\r\n" + "	\"surName\" : \"Sharma\",\r\n"
						+ "	\"dateOfJoining\" : \"2021/10/27\",\r\n" + "	\"dateOfBirth\" : \"2021/11/10\",\r\n"
						+ "	\"mobileNo\" : 9876545789,\r\n" + "	\"email\":\"kartik@gmail.com\",\r\n"
						+ "	\"city\" : \"dwarka\",\r\n" + "	\"state\" : \"delhi\"\r\n" + "	\r\n" + "	\r\n"
						+ "	\r\n" + "}");

		User user = new User();
		user.setUserName("kartik");
		user.setSurName("Sharma");
		user.setDateOfJoining(new Date(2021 / 10 / 27));
		user.setDateOfBirth(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmail("kartik@gmail.com");
		user.setCity("dwarka");
		user.setState("delhi");

		when(userService.saveUser(user)).thenReturn(user);

		try {
			mockMvc.perform(saveUserRequestBuilder).andExpect(status().isCreated());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	@Test
	@DisplayName("Not Null validation check for field")
	void testSaveUsernull() {

		MockHttpServletRequestBuilder saveUserRequestBuilder = MockMvcRequestBuilders.post("/userdata/saveUser")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "	\"surName\" : \"Sharma\",\r\n"
						+ "	\"dateOfJoining\" : \"2021/10/27\",\r\n" + "	\"dateOfBirth\" : \"2021/11/10\",\r\n"
						+ "	\"mobileNo\" : 9876545789,\r\n" + "	\"email\":\"kartik@gmail.com\",\r\n"
						+ "	\"city\" : \"dwarka\",\r\n" + "	\"state\" : \"delhi\"\r\n" + "	\r\n" + "	\r\n"
						+ "	\r\n" + "}");

		User user = new User();
		user.setUserName("kartik");
		user.setSurName("Sharma");
		user.setDateOfJoining(new Date(2021 / 10 / 27));
		user.setDateOfBirth(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmail("kartik@gmail.com");
		user.setCity("dwarka");
		user.setState("delhi");

//		User savedUser = new User();
////		savedUser.setUserId(1L);
//		savedUser.setUserName("kartik");
//		savedUser.setSurName("Sharma");
//		savedUser.setDateOfJoining(new Date(2021 / 10 / 27));
//		savedUser.setDateOfBirth(new Date(2021 / 11 / 10));
//		savedUser.setMobileNo(9876545789L);
//		savedUser.setEmail("kartik@gmail.com");
//		savedUser.setCity("dwarka");
//		savedUser.setState("delhi");
		when(userService.saveUser(user)).thenReturn(user);

		try {
			mockMvc.perform(saveUserRequestBuilder).andExpect(status().isCreated());
//			Assert.assertNotNull(user.getUserId());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	@Test
	void testFindByfield() {
		
		MockHttpServletRequestBuilder findUserRequestBuilder = MockMvcRequestBuilders.get("/userdata//findByfield/mohan")
		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		User user = new User();
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		user.setUserName("mohan");
		user.setSurName("Sharma");
		user.setDateOfJoining(new Date(2021 / 10 / 27));
		user.setDateOfBirth(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmail("kartik@gmail.com");
		user.setCity("dwarka");
		user.setState("delhi");
		when(userService.searchUser("mohan")).thenReturn(userList);
		
		try {
			mockMvc.perform(findUserRequestBuilder).andExpect(status().isOk());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
//
//	@Test
//	void testUpdateUserById() {
//		fail("Not yet implemented");
	
//	}
//
//	@Test
//	void testSortByDob() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByDateOfJoining() {
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
//
}
