package com.iiht.training.datingapp.service;

import java.util.List;

import com.iiht.training.datingapp.dto.LikeDto;

public interface LikesService {

	public List<LikeDto> getAllLikes(Long userId);

	public LikeDto saveLike(LikeDto like);
}
