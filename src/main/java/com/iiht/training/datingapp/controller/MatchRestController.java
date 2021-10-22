package com.iiht.training.datingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.datingapp.dto.MatchDto;
import com.iiht.training.datingapp.dto.UserDto;
import com.iiht.training.datingapp.filter.Filter;
import com.iiht.training.datingapp.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchRestController {

	@Autowired
	MatchService matchService;


    @GetMapping("/{userId}")
    public List<MatchDto> getMatches(@PathVariable Long userId) {
		return matchService.getAllMatches(userId);
	}

	@PostMapping("/{userId}")
	public List<UserDto> getCandidates(@PathVariable Long userId, @RequestBody List<Filter> filters) {
		return matchService.getPotentialMatches(userId, filters);
	}
}