package com.iiht.training.datingapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.LikeDto;
import com.iiht.training.datingapp.entity.Like;
import com.iiht.training.datingapp.repository.LikesRepository;
import com.iiht.training.datingapp.service.LikesService;
import com.iiht.training.datingapp.service.MatchService;

@Service
public class LikesServiceImpl implements LikesService {
	@Autowired
	LikesRepository likesRepository;

	@Autowired
	MatchService matchService;

	public List<LikeDto> getAllLikes(Long userId) {
        List<Like> likes = likesRepository.getAllLikedUsers(userId);
        List<LikeDto> likeDtos = new ArrayList<>();
        if (likes.size()>0) {
            for (Like like: likes) {
                LikeDto likeDto = new LikeDto();
                BeanUtils.copyProperties(like, likeDto);
                likeDtos.add(likeDto);
            }
        }
		return likeDtos;
	}

	public LikeDto saveLike(LikeDto likeDto) {
        Like like = new Like();
		BeanUtils.copyProperties(likeDto, like);
		likesRepository.save(like);
		return likeDto;
	}
}
