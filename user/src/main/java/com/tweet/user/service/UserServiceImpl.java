package com.tweet.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.user.dto.UserDTO;
import com.tweet.user.entity.Status;
import com.tweet.user.entity.User;
import com.tweet.user.exception.UserException;
import com.tweet.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean findEmailIfExists(String email) {
		Optional<User> obj = userRepository.findByEmail(email);
		if(!obj.isEmpty()) {
			return true;
		}
		return false;
				
	}
	
	public Integer registerUser(UserDTO userDTO) {
		User user = new User();
		user.setBio(userDTO.getBio());
		user.setCoverPic(userDTO.getCoverPic());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setId(userDTO.getId());
//		user.setFeedTweets(userDTO.getFeedTweets());
		user.setLocation(userDTO.getLocation());
		user.setName(userDTO.getName());
		user.setProfilePic(userDTO.getProfilePic());
		user.setUsername(userDTO.getUsername());
		user.setWebsite(userDTO.getWebsite());
//		user.setStatus(userDTO.getStatus());
		User res = userRepository.save(user);
		return res.getId();
	}
	
	
	public boolean checkCredentials(String email,String password){
		Optional<User> obj = userRepository.findByEmail(email);
		if(obj.isEmpty()) {
			return false;
		}
		// Check is email and password entered are correct
		String emailDB = obj.get().getEmail();
		String passwordDB = obj.get().getPassword();
		if(emailDB.equals(email) && passwordDB.equals(password)) {
//			obj.get().setStatus(Status.Logged_in);
			return true;
		}
		return false;
	}
	
	public void updateUserProfile(UserDTO userDTO) {
		Optional<User> obj = userRepository.findByEmail(userDTO.getEmail());
		obj.get().setBio(userDTO.getBio());
		obj.get().setCoverPic(userDTO.getCoverPic());
		obj.get().setLocation(userDTO.getLocation());
		obj.get().setProfilePic(userDTO.getProfilePic());
		obj.get().setWebsite(userDTO.getWebsite());
		return;
	}
	
	public UserDTO getUserDetails(String email) {
		Optional<User> obj = userRepository.findByEmail(email);
		UserDTO userDTO = new UserDTO();
		userDTO.setBio(obj.get().getBio());
		userDTO.setCoverPic(obj.get().getCoverPic());
		userDTO.setEmail(obj.get().getEmail());
		userDTO.setId(obj.get().getId());
//		userDTO.setFeedTweets(obj.get().getFeedTweets());
		userDTO.setLocation(obj.get().getLocation());
		userDTO.setName(obj.get().getName());
		userDTO.setPassword(obj.get().getPassword());
		userDTO.setProfilePic(obj.get().getProfilePic());
		userDTO.setUsername(obj.get().getUsername());
		userDTO.setWebsite(obj.get().getWebsite());
		return userDTO;
	}
	
	public List<UserDTO> getAllUsersInfo(){
		List<UserDTO> userDTO = new ArrayList<>();
		List<User> user = userRepository.findAll();
		for(int i = 0;i < user.size();i++) {
			UserDTO obj = new UserDTO();
			obj.setBio(user.get(i).getBio());
			obj.setCoverPic(user.get(i).getCoverPic());
			obj.setEmail(user.get(i).getEmail());
			obj.setId(user.get(i).getId());
			obj.setLocation(user.get(i).getLocation());
			obj.setName(user.get(i).getName());
			obj.setPassword(user.get(i).getPassword());
			obj.setProfilePic(user.get(i).getProfilePic());
			obj.setUsername(user.get(i).getUsername());
			obj.setWebsite(user.get(i).getWebsite());
			userDTO.add(obj);
		}
		return userDTO;
	}
}
