package com.iiht.training.datingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iiht.training.datingapp.dto.UserDto;

public interface UserService {

	public UserDto registerUser(UserDto user);

	public UserDto getById(Long userId);

	public UserDto updateUser(UserDto user);

	public boolean deleteUser(Long userId);

	public List<UserDto> findAll();

}
