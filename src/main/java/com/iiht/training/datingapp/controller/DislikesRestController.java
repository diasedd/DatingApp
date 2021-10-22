package com.iiht.training.datingapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.exceptions.InvalidDataException;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.service.DislikesService;

@RestController
@RequestMapping("/dislikes")
public class DislikesRestController {

	@Autowired
	DislikesService dislikesService;

	@GetMapping("/{userId}")
	public ResponseEntity<? extends Object> getAllDislikedUsers(@PathVariable Long userId) {
        List<DislikeDto> dislikes =  dislikesService.getAllDislikes(userId);
        if(!dislikes.isEmpty()) {
            return new ResponseEntity<List<DislikeDto>>(dislikes,HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }        
	}

	@PostMapping
	public DislikeDto saveDislike(@Valid @RequestBody DislikeDto dislikeDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
        }        
		dislikesService.saveDislike(dislikeDto);
		return dislikeDto;
	}
}