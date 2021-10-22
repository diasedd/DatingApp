package com.iiht.training.datingapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.datingapp.dto.InterestsDto;
import com.iiht.training.datingapp.exceptions.InvalidDataException;
import com.iiht.training.datingapp.service.InterestsService;

@RestController
@RequestMapping("/interests")
public class InterestsRestController {

	@Autowired
	private InterestsService interestsService;

	@PostMapping
	public ResponseEntity<? extends Object> addInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
        if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
		}
		interestsService.createInterest(interestsDto);
		return new ResponseEntity<InterestsDto>(interestsDto,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<? extends Object> updateInterests(@Valid @RequestBody InterestsDto interestsDto, BindingResult result) {
        if (result.hasErrors()) {
			throw new InvalidDataException("Invalid User Data");
		}
		interestsService.updateInterest(interestsDto);
		return new ResponseEntity<InterestsDto>(interestsDto,HttpStatus.OK);		
	}

	@DeleteMapping("/{interestId}")
	public ResponseEntity<? extends Object> deleteInterests(@PathVariable Long interestId) {
        interestsService.deleteInterest(interestId);
		return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
	}

	@GetMapping("/{interestId}")
	public ResponseEntity<InterestsDto> getInterestsById(@PathVariable Long interestId) {
        InterestsDto interestsDto = interestsService.getById(interestId);
		return new ResponseEntity<InterestsDto>(interestsDto,HttpStatus.OK);
	}

	@GetMapping("/by-user-id/{userId}")
	public ResponseEntity<List<InterestsDto>> getInterestsByUserId(@PathVariable Long userId) {
        List<InterestsDto> interestsDto = interestsService.getInterestsByUserId(userId);
		return new ResponseEntity<List<InterestsDto>>(interestsDto,HttpStatus.OK);		
	}

}
