package com.iiht.training.datingapp.testutils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.dto.InterestsDto;
import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.entity.Dislike;
import com.iiht.training.datingapp.entity.Interests;
import com.iiht.training.datingapp.entity.Like;
import com.iiht.training.datingapp.entity.Match;
import com.iiht.training.datingapp.entity.User;

public class MasterData {

	public static UserDto getUserDto() {
		UserDto user = new UserDto();
		user.setUserId(1L);
		user.setName("Name");
		user.setEmail("name@mail.com");
		user.setAge(22);
		user.setGender("Male");
		user.setPhoneNumber(1234567890L);
		user.setCity("Mumbai");
		user.setCountry("India");
		return user;

	}

	public static List<UserDto> getUserDtoList() {
		List<UserDto> users = new ArrayList<>();
		UserDto user = new UserDto();
		user.setUserId(1L);
		user.setName("First");
		user.setEmail("first@mail.com");
		user.setAge(22);
		user.setGender("Male");
		user.setPhoneNumber(1234567890L);
		user.setCity("Mumbai");
		user.setCountry("India");
		users.add(user);
		user = new UserDto();
		user.setUserId(2L);
		user.setName("Second");
		user.setEmail("second@mail.com");
		user.setAge(23);
		user.setGender("Female");
		user.setPhoneNumber(99994567890L);
		user.setCity("London");
		user.setCountry("England");
		users.add(user);
		return users;
	}

	public static MatchDto getMatchDto() {
		MatchDto matchDto = new MatchDto();
		matchDto.setId(1L);
		matchDto.setUserId(2L);
		matchDto.setMatchedUserId(1L);
		return matchDto;
	}

	public static List<MatchDto> getMatchDtoList() {
		List<MatchDto> matches = new ArrayList<>();
		MatchDto matchDto = new MatchDto();
		matchDto.setId(1L);
		matchDto.setUserId(2L);
		matchDto.setMatchedUserId(1L);
		matches.add(matchDto);
		matchDto = new MatchDto();
		matchDto.setId(2L);
		matchDto.setUserId(2L);
		matchDto.setMatchedUserId(1L);
		matches.add(matchDto);
		return matches;
	}

	public static LikeDto getLikeDto() {
		LikeDto likeDto = new LikeDto();
		likeDto.setId(1L);
		likeDto.setUserId(2l);
		likeDto.setLikedUserId(3L);
		return likeDto;
	}

	public static List<LikeDto> getLikeDtoList() {
		List<LikeDto> likes = new ArrayList<>();
		LikeDto likeDto = new LikeDto();
		likeDto.setId(1L);
		likeDto.setUserId(2l);
		likeDto.setLikedUserId(3L);
		likes.add(likeDto);
		likeDto = new LikeDto();
		likeDto.setId(2L);
		likeDto.setUserId(2L);
		likeDto.setLikedUserId(3L);
		likes.add(likeDto);
		return likes;
	}

	public static DislikeDto getDislikeDto() {
		DislikeDto dislikeDto = new DislikeDto();
		dislikeDto.setId(1L);
		dislikeDto.setUserId(2L);
		dislikeDto.setDislikedUserId(3L);
		return dislikeDto;
	}

	public static List<DislikeDto> getDislikeDtoList() {
		List<DislikeDto> dislikes = new ArrayList<>();
		DislikeDto dislikeDto = new DislikeDto();
		dislikeDto.setId(1L);
		dislikeDto.setUserId(2l);
		dislikeDto.setDislikedUserId(1L);
		dislikes.add(dislikeDto);
		dislikeDto = new DislikeDto();
		dislikeDto.setId(2L);
		dislikeDto.setUserId(1L);
		dislikeDto.setDislikedUserId(2L);
		dislikes.add(dislikeDto);
		return dislikes;
	}

	public static InterestsDto getInterestsDto() {

		InterestsDto interestDto = new InterestsDto();
		interestDto.setInterestId(1L);
		interestDto.setUserId(2L);
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Playing Cricket");
		hobbies.add("Reading Books");
		hobbies.add("Travelling");
		interestDto.setHobbies(hobbies);
		interestDto.setInterestedIn("To Talk");
		interestDto.setNotInterestedIn("Getting up early in the morning");
		interestDto.setProfileUrl("www.abc.com");
		interestDto.setAbout("I am a Simple man");
		return interestDto;
	}

	public static List<InterestsDto> getInterestsDtoList() {
		List<InterestsDto> interests = new ArrayList<>();
		InterestsDto interestDto = new InterestsDto();
		interestDto.setInterestId(1L);
		interestDto.setUserId(2L);
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Playing Cricket");
		hobbies.add("Reading Books");
		hobbies.add("Travelling");
		interestDto.setHobbies(hobbies);
		interestDto.setInterestedIn("To Talk");
		interestDto.setNotInterestedIn("Getting up early in the morning");
		interestDto.setProfileUrl("www.abc.com");
		interestDto.setAbout("I am a Simple man");
		interests.add(interestDto);
		interestDto = new InterestsDto();
		interestDto.setInterestId(2L);
		interestDto.setUserId(1L);
		hobbies = new ArrayList<>();
		hobbies.add("Sleeping");
		hobbies.add("Playing Games");
		interestDto.setHobbies(hobbies);
		interestDto.setInterestedIn("Riding the Bikes");
		interestDto.setNotInterestedIn("Sleeping early");
		interestDto.setProfileUrl("www.example.com");
		interestDto.setAbout("Have passion for life");
		interests.add(interestDto);
		return interests;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
