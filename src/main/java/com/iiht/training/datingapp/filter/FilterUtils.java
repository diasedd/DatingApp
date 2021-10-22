package com.iiht.training.datingapp.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.dto.UserDto;

public class FilterUtils {

	public static List<UserDto> applyAgeFilter(List<UserDto> filteredUsers, ArrayList<?> values) {
		int startAge = (Integer) values.get(0);
		int endAge = (Integer) values.get(1);
		List<UserDto> ageFiltered = new ArrayList<UserDto>();
		filteredUsers.forEach(user -> {
			if (user.getAge() >= startAge && user.getAge() <= endAge) {
				ageFiltered.add(user);
			}
		});
		return ageFiltered;
	}

	public static List<UserDto> applyLocationFilter(List<UserDto> filteredUsers, ArrayList<?> values, boolean byCity) {
		String location = values.get(0).toString();
		List<UserDto> locationFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			String userLocation = byCity ? user.getCity() : user.getCountry();
			if (userLocation.equalsIgnoreCase(location)) {
				locationFiltered.add(user);
			}
		});
		return locationFiltered;
	}

	public static List<UserDto> applyGenderFilter(List<UserDto> filteredUsers, ArrayList<?> values) {
		String gender = values.get(0).toString();
		List<UserDto> genderFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			String userSex = user.getGender();
			if (userSex.equals(gender)) {
				genderFiltered.add(user);
			}
		});
		return genderFiltered;
	}

	public static List<UserDto> filterLikedUsers(List<UserDto> filteredUsers, List<LikeDto> likes) {
		Set<Long> userIdSet = new HashSet<Long>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		likes.forEach(like -> {
			if (userIdSet.contains(like.getLikedUserId())) {
				userIdSet.remove(like.getLikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	public static List<UserDto> filterDislikedUsers(List<UserDto> filteredUsers, List<DislikeDto> dislikes) {
		Set<Long> userIdSet = new HashSet<Long>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		dislikes.forEach(like -> {
			if (userIdSet.contains(like.getDislikedUserId())) {
				userIdSet.remove(like.getDislikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}
}