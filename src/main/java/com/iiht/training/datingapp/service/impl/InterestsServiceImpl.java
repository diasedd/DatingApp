package com.iiht.training.datingapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.InterestsDto;
import com.iiht.training.datingapp.entity.Interests;
import com.iiht.training.datingapp.exceptions.InterestsNotFoundException;
import com.iiht.training.datingapp.repository.InterestsRepository;
import com.iiht.training.datingapp.service.InterestsService;

@Service
public class InterestsServiceImpl implements InterestsService {

	@Autowired
	private InterestsRepository interestsRepository;

	@Override
	public InterestsDto createInterest(InterestsDto interestsDto) {
        Interests interest = new Interests();
		BeanUtils.copyProperties(interestsDto, interest);
		interestsRepository.save(interest);
		return interestsDto;
	}

	@Override
	public InterestsDto updateInterest(InterestsDto interestsDto) {
        Interests interests = new Interests();
		BeanUtils.copyProperties(interestsDto, interests);
		interestsRepository.save(interests);
		return interestsDto;
	}

	@Override
	public boolean deleteInterest(Long interestId) {
        Optional<Interests> interest = interestsRepository.findById(interestId);
        if (interest.isPresent()) {
            interestsRepository.delete(interest.get());  
            return true;      
		} else {
            throw new InterestsNotFoundException("Interest with Id - " + interestId + " not Found!");
		}    
		
	}

	@Override
	public InterestsDto getById(Long interestId) {
        Optional<Interests> interest = interestsRepository.findById(interestId);
        if (interest.isPresent()) {
           InterestsDto interestDto = new InterestsDto();
			BeanUtils.copyProperties(interest.get(), interestDto);
			return interestDto;
		} else {
            throw new InterestsNotFoundException("Interest with Id - " + interestId + " not Found!");
		}

	}

	@Override
	public List<InterestsDto> getInterestsByUserId(Long userId) {  
        List<Interests> interest = interestsRepository.findByUserId(userId);
        List<InterestsDto> interestDtoList = new ArrayList<>(); 
        if (interest.size()>0) {            
            for (Interests i:interest) {
                InterestsDto iDto = new InterestsDto();
                BeanUtils.copyProperties(i, iDto);
                interestDtoList.add(iDto);
            } 
        }
        return interestDtoList;
	}

}
