package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.filter.Filter;

public interface MatchService {

	public List<MatchDto> getAllMatches(Long userId);

	public MatchDto saveMatch(MatchDto match);

	public List<UserDto> getPotentialMatches(Long userId, List<Filter> filters);
}