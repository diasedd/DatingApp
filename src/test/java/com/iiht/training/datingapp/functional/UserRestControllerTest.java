package com.iiht.training.datingapp.functional;

import static com.iiht.training.datingapp.testutils.TestUtils.businessTestFile;
import static com.iiht.training.datingapp.testutils.TestUtils.currentTest;
import static com.iiht.training.datingapp.testutils.TestUtils.testReport;
import static com.iiht.training.datingapp.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.datingapp.controller.UserRestController;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.entity.User;
import com.iiht.training.datingapp.service.UserService;
import com.iiht.training.datingapp.testutils.MasterData;

@WebMvcTest(UserRestController.class)
@AutoConfigureMockMvc
public class UserRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterUser() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);

		when(this.userService.registerUser(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testRegisterUserIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);
		when(userService.registerUser(userDto)).then(new Answer<UserDto>() {

			@Override
			public UserDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedUserDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetAllUsers() throws Exception {
		List<UserDto> users = MasterData.getUserDtoList();

		when(this.userService.findAll()).thenReturn(users);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(users)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllUsersIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<UserDto> users = MasterData.getUserDtoList();
		when(this.userService.findAll()).then(new Answer<List<UserDto>>() {

			@Override
			public List<UserDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return users;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		System.out.println("Test user Name :"+userDto.getName());
        userDto.setUserId(1L);
		when(this.userService.deleteUser(1L)).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Result Response "+result.getResponse().getContentAsString());
		System.out.println("Expected Response "+MasterData.asJsonString(true));
		
		
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(true)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testDeleteUserIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		UserDto userDto = MasterData.getUserDto();
		when(this.userService.deleteUser(userDto.getUserId())).then(new Answer<Boolean>() {

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return true;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);
	}

	
	@Test
	public void testUpdateUser() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);

		when(this.userService.updateUser(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testUpdateUserIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);
		when(userService.updateUser(userDto)).then(new Answer<UserDto>() {

			@Override
			public UserDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedUserDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}


}
