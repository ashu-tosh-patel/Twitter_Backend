package com.tweet.user.service;

import java.util.List;

import com.tweet.user.dto.UserDTO;
import com.tweet.user.exception.UserException;

public interface UserService {
	public boolean findEmailIfExists(String email);
	public Integer registerUser(UserDTO userDTO);
	public boolean checkCredentials(String email,String password);
	public void updateUserProfile(UserDTO userDTO);
	public UserDTO getUserDetails(String email);
	public List<UserDTO> getAllUsersInfo();
//	public UserDTO findIdIfExists(Integer id);
}
