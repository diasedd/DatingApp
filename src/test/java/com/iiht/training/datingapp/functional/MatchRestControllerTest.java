package com.iiht.training.datingapp.functional;

import static com.iiht.training.datingapp.testutils.TestUtils.businessTestFile;
import static com.iiht.training.datingapp.testutils.TestUtils.currentTest;
import static com.iiht.training.datingapp.testutils.TestUtils.testReport;
import static com.iiht.training.datingapp.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.iiht.training.datingapp.controller.MatchRestController;
import com.iiht.training.datingapp.controller.UserRestController;
import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.entity.Match;
import com.iiht.training.datingapp.entity.User;
import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.filter.Filter.FilterType;
import com.iiht.training.datingapp.service.MatchService;
import com.iiht.training.datingapp.service.UserService;
import com.iiht.training.datingapp.testutils.MasterData;

@WebMvcTest(MatchRestController.class)
@AutoConfigureMockMvc
public class MatchRestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MatchService matchService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}
    
	@Test
	public void testGetAllMatches() throws Exception {
		List<MatchDto> matches = MasterData.getMatchDtoList();

		when(this.matchService.getAllMatches(1L)).thenReturn(matches);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/match/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(matches)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllMatchesIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<MatchDto> matches = MasterData.getMatchDtoList();
		when(this.matchService.getAllMatches(1L)).then(new Answer<List<MatchDto>>() {

			@Override
			public List<MatchDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return matches;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/match/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}
	
	@Test
	public void testGetAllPotentialMatches() throws Exception {
		List<UserDto> matches = MasterData.getUserDtoList();
		List<Filter> filters = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("Mumbai");
		filters.add(new Filter(FilterType.CITY,list));
		when(this.matchService.getPotentialMatches(1L, filters)).thenReturn(matches);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/match/1").content(MasterData.asJsonString(filters)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Dia :MasterData.asJsonString"+ MasterData.asJsonString(matches));
		System.out.println("Dia :Result"+result.getResponse().getContentAsString());
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(matches)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllPotentialMatchesIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<UserDto> matches = MasterData.getUserDtoList();
		List<Filter> filters = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("Mumbai");
		filters.add(new Filter(FilterType.CITY,list));
		when(this.matchService.getPotentialMatches(1L, filters)).then(new Answer<List<UserDto>>() {

			@Override
			public List<UserDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return matches;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/match/1").content(MasterData.asJsonString(filters)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), count[0] > 0 ? true : false, businessTestFile);

	}
}
