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

import com.iiht.training.datingapp.controller.LikesRestController;
import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.entity.Like;
import com.iiht.training.datingapp.service.LikesService;
import com.iiht.training.datingapp.testutils.MasterData;

@WebMvcTest(LikesRestController.class)
@AutoConfigureMockMvc
public class LikesRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LikesService likesService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAllLikedUsers() throws Exception {
		List<LikeDto> likes = MasterData.getLikeDtoList();

		when(this.likesService.getAllLikes(1L)).thenReturn(likes);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/likes/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(likes)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllLikedUsersIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<LikeDto> likes = MasterData.getLikeDtoList();
		when(this.likesService.getAllLikes(1L)).then(new Answer<List<LikeDto>>() {

			@Override
			public List<LikeDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return likes;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/likes/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testSaveLike() throws Exception {
		LikeDto likeDto = MasterData.getLikeDto();
		LikeDto savedLikeDto = MasterData.getLikeDto();
		savedLikeDto.setId(1L);

		when(this.likesService.saveLike(likeDto)).thenReturn(savedLikeDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/likes").content(MasterData.asJsonString(likeDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedLikeDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testSaveLikeIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		LikeDto likeDto = MasterData.getLikeDto();
		LikeDto savedLikeDto = MasterData.getLikeDto();
		savedLikeDto.setId(1L);
		when(this.likesService.saveLike(likeDto)).then(new Answer<LikeDto>() {

			@Override
			public LikeDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return likeDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/likes").content(MasterData.asJsonString(likeDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

}
