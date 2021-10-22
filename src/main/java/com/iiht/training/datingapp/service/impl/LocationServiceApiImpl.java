package com.iiht.training.datingapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.filter.FilterUtils;
import com.iiht.training.datingapp.service.LocationServiceApi;
import com.iiht.training.datingapp.service.UserService;

@Service
public class LocationServiceApiImpl implements LocationServiceApi {

	@Autowired
	@Qualifier("user")
	private UserService userService;
	
	private List<UserDto> USER_DATA;

	
	@Override
	public List<UserDto> getUsersDto(List<Filter> filters) {
		USER_DATA = userService.findAll();
		List<UserDto> filteredUsers = USER_DATA;
		if (filters != null && !filters.isEmpty()) {
			for (Filter filter : filters) {
				filteredUsers = applyFilter(filter, filteredUsers);
			}
		}
		return filteredUsers;
	}

	private List<UserDto> applyFilter(Filter filter, List<UserDto> filteredUsers) {
		switch (filter.getType()) {
		case AGE:
			filteredUsers = FilterUtils.applyAgeFilter(filteredUsers, filter.getValues());
			break;
		case CITY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), true);
			break;
		case COUNTRY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), false);
			break;
		case GENDER:
			filteredUsers = FilterUtils.applyGenderFilter(filteredUsers, filter.getValues());
			break;
		}
		return filteredUsers;
	}

}