package com.iiht.training.datingapp.functional;

import static com.iiht.training.datingapp.testutils.TestUtils.businessTestFile;
import static com.iiht.training.datingapp.testutils.TestUtils.currentTest;
import static com.iiht.training.datingapp.testutils.TestUtils.testReport;
import static com.iiht.training.datingapp.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
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

import com.iiht.training.datingapp.controller.DislikesRestController;
import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.entity.Dislike;
import com.iiht.training.datingapp.service.DislikesService;
import com.iiht.training.datingapp.testutils.MasterData;

@WebMvcTest(DislikesRestController.class)
@AutoConfigureMockMvc
public class DislikeRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DislikesService dislikesService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAllDislikedUsers() throws Exception {
		List<DislikeDto> dislikes = MasterData.getDislikeDtoList();

		when(this.dislikesService.getAllDislikes(1L)).thenReturn(dislikes);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dislikes/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(dislikes)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllDislikedUsersIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<DislikeDto> dislikes = MasterData.getDislikeDtoList();
		when(this.dislikesService.getAllDislikes(1L)).then(new Answer<List<DislikeDto>>() {

			@Override
			public List<DislikeDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return dislikes;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dislikes/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testSaveDislike() throws Exception {
		DislikeDto dislikeDto = MasterData.getDislikeDto();
		DislikeDto savedDislikeDto = MasterData.getDislikeDto();
		savedDislikeDto.setId(1L);

		when(this.dislikesService.saveDislike(dislikeDto)).thenReturn(savedDislikeDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/dislikes").content(MasterData.asJsonString(dislikeDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedDislikeDto)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testSaveDislikeIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		DislikeDto dislikeDto = MasterData.getDislikeDto();
		DislikeDto savedDislikeDto = MasterData.getDislikeDto();
		savedDislikeDto.setId(1L);
		when(this.dislikesService.saveDislike(dislikeDto)).then(new Answer<DislikeDto>() {

			@Override
			public DislikeDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedDislikeDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/dislikes").content(MasterData.asJsonString(dislikeDto))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

}
