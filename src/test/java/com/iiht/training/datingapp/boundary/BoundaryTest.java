package com.iiht.training.datingapp.boundary;

import static com.iiht.training.datingapp.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.datingapp.testutils.TestUtils.currentTest;
import static com.iiht.training.datingapp.testutils.TestUtils.testReport;
import static com.iiht.training.datingapp.testutils.TestUtils.yakshaAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
import com.iiht.training.datingapp.testutils.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testUserNameNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setName("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserNameMinThree() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setName("Ab");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserNameMaxHundred() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		String name = "";
		for (int i = 0; i < 120; i++) {
			name.concat("A");
		}
		userDto.setName(name);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserAgeNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setAge(null);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserAgeMinEighteen() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setAge(10);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserAgeMaxSixty() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setAge(65);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserMobileNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setPhoneNumber(null);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserMobileMinTen() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setPhoneNumber(12345L);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserMobileMaxTen() throws Exception {
		UserDto userDto = MasterData.getUserDto();

		userDto.setPhoneNumber(123456789012L);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserGenderNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setGender("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserEmailNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setEmail("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserEmailMinThree() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setEmail("Ab");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserEmailMaxHundred() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		String name = "";
		for (int i = 0; i < 120; i++) {
			name.concat("A");
		}
		userDto.setEmail(name);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserEmailValidFormat() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setEmail("abc");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserCityNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setCity("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testUserCountryNotNull() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		userDto.setCountry("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsInterestedInNotNull() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setInterestedIn("");
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsInterestedInMinThree() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setInterestedIn("Ab");
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsInterestedInMaxHunderds() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		String interestedIn = "";
		for (int i = 0; i < 120; i++) {
			interestedIn.concat("A");
		}
		interestsDto.setInterestedIn(interestedIn);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsNotInterestedInNotNull() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setNotInterestedIn("");
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsNotInterestedInMinThree() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setNotInterestedIn("Ab");
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsNotInterestedInMaxHunderds() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		String notInterestedIn = "";
		for (int i = 0; i < 120; i++) {
			notInterestedIn.concat("A");
		}
		interestsDto.setInterestedIn(notInterestedIn);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsHobbiesNotNull() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setHobbies(null);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	

	@Test
	public void testInterestsProfileUrlNotNull() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setProfileUrl(null);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsAboutNotNull() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setAbout(null);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsAboutMinThree() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		interestsDto.setAbout("Ab");
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testInterestsAboutMaxHunderd() throws Exception {
		InterestsDto interestsDto = MasterData.getInterestsDto();
		String about = "";
		for (int i = 0; i < 120; i++) {
			about.concat("A");
		}
		interestsDto.setAbout(about);
		Set<ConstraintViolation<InterestsDto>> violations = validator.validate(interestsDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testLikesUserIdNotNull() throws Exception {
		LikeDto likeDto = MasterData.getLikeDto();
		likeDto.setUserId(null);
		Set<ConstraintViolation<LikeDto>> violations = validator.validate(likeDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testLikesLikedUserIdNotNull() throws Exception {
		LikeDto likeDto = MasterData.getLikeDto();
		likeDto.setLikedUserId(null);
		Set<ConstraintViolation<LikeDto>> violations = validator.validate(likeDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDislikeUserIdNotNull() throws Exception {
		DislikeDto dislikeDto = MasterData.getDislikeDto();
		dislikeDto.setUserId(null);
		Set<ConstraintViolation<DislikeDto>> violations = validator.validate(dislikeDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testDislikeDislikedUserIdNotNull() throws Exception {
		DislikeDto dislikeDto = MasterData.getDislikeDto();
		dislikeDto.setDislikedUserId(null);
		Set<ConstraintViolation<DislikeDto>> violations = validator.validate(dislikeDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testMatchUserIdNotNull() throws Exception {
		MatchDto matchDto = MasterData.getMatchDto();
		matchDto.setUserId(null);
		Set<ConstraintViolation<MatchDto>> violations = validator.validate(matchDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testMatchMatchedUserIdNotNull() throws Exception {
		MatchDto matchDto = MasterData.getMatchDto();
		matchDto.setMatchedUserId(null);
		Set<ConstraintViolation<MatchDto>> violations = validator.validate(matchDto);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
}
