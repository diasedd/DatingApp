package com.iiht.training.datingapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.DislikeDto;
import com.iiht.training.datingapp.entity.Dislike;
import com.iiht.training.datingapp.repository.DislikesRepository;
import com.iiht.training.datingapp.service.DislikesService;

@Service
public class DislikesServiceImpl implements DislikesService {

	@Autowired
	DislikesRepository dislikesRepository;

	public List<DislikeDto> getAllDislikes(Long userId) {
        List<Dislike> dislikes = dislikesRepository.getAllDislikedUsers(userId);
        List<DislikeDto> dislikeDtos = new ArrayList<>();
        if (dislikes.size()>0) {
            for (Dislike dislike: dislikes) {
                DislikeDto dislikeDto = new DislikeDto();
                BeanUtils.copyProperties(dislike, dislikeDto);
                dislikeDtos.add(dislikeDto);
            }
        }
		return dislikeDtos;
	}

	public DislikeDto saveDislike(DislikeDto dislikeDto) {
		Dislike dislike = new Dislike();
		BeanUtils.copyProperties(dislikeDto, dislike);
		dislikesRepository.save(dislike);
		return dislikeDto;
	}

}