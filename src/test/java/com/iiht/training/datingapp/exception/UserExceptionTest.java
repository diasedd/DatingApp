package com.iiht.training.datingapp.exception;

import static com.iiht.training.datingapp.testutils.TestUtils.currentTest;
import static com.iiht.training.datingapp.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.datingapp.testutils.TestUtils.testReport;
import static com.iiht.training.datingapp.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.datingapp.controller.UserRestController;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.entity.User;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.model.exception.ExceptionResponse;
import com.iiht.training.datingapp.service.UserService;
import com.iiht.training.datingapp.testutils.MasterData;

@WebMvcTest(UserRestController.class)
@AutoConfigureMockMvc
public class UserExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterUserInvalidDataException() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);

		userDto.setName("ab");

		when(this.userService.registerUser(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("testRegisterUserInvalidDataException"+result.getResponse().getContentAsString());

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testUpdateUserInvalidDataException() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setUserId(1L);

		userDto.setName("ab");
		when(this.userService.updateUser(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users").content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testDeleteUserNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("User with Id - 2 not Found!", System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());

		when(this.userService.deleteUser(2L)).thenThrow(new UserNotFoundException("User with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}

}
