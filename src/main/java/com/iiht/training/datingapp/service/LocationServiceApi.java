package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.filter.Filter;

public interface LocationServiceApi {

	public List<UserDto> getUsersDto(List<Filter> filters);
}