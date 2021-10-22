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

import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.exceptions.InvalidDataException;
import com.iiht.training.datingapp.exceptions.UserNotFoundException;
import com.iiht.training.datingapp.service.LikesService;

@RestController
@RequestMapping("/likes")
public class LikesRestController {

	@Autowired
	LikesService likesService;

	@GetMapping("/{userId}")
	public ResponseEntity<? extends Object> getAllLikedUsers(@PathVariable Long userId) {
		List<LikeDto> likes =  likesService.getAllLikes(userId);
        if(!likes.isEmpty()) {
            return new ResponseEntity<List<LikeDto>>(likes,HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }  
	}

	@PostMapping
	public LikeDto saveLike(@Valid @RequestBody LikeDto likeDto, BindingResult result) {
        if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
        }        
		likesService.saveLike(likeDto);
		return likeDto;
	}
}