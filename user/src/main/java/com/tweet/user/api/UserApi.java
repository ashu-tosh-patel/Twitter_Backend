package com.tweet.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
//import org.apache.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.user.dto.UserDTO;
//import com.tweet.user.entity.User;
import com.tweet.user.exception.UserException;
//import com.tweet.user.repository.UserRepository;
import com.tweet.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@Validated
@CrossOrigin
public class UserApi {
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
//	private WebClient webClient = WebClient.build();
	
//	User Registration
	@PostMapping(value = "/userRegistration")
	public ResponseEntity<String> userRegistration(@RequestBody @Valid UserDTO userDTO) throws UserException{
		// Check if email already exists
		boolean userExists = userService.findEmailIfExists(userDTO.getEmail());
		if(userExists) {
			throw new UserException("Service.USER_ALREADY_EXISTS");
		}
		Integer num = userService.registerUser(userDTO);
		String msg = "You account has been successfully created : ";
		String successMsg = msg + num.toString();
		return new ResponseEntity<>(successMsg,HttpStatus.CREATED);
	}
	
//	User Authentication
	@PostMapping(value="/userAuthentication")
	public ResponseEntity<String> userAuthentication(@RequestBody UserDTO userDTO) throws UserException{
		String email = userDTO.getEmail();
		String password = userDTO.getPassword();
		boolean credentialsAreCorrect = userService.checkCredentials(email,password);
		if(!credentialsAreCorrect) {
			throw new UserException("Service.INCORRECT_CREDENTIALS");
		}
		String successMsg = "Login successfull";
		return new ResponseEntity<>(successMsg,HttpStatus.FOUND);
	}
	
//	Updating User Profile
	@PostMapping(value="/updateProfile")
	public ResponseEntity<String> updateUserProfile(@RequestBody UserDTO userDTO){
		//No verification since User can only change profile after being logged in
		userService.updateUserProfile(userDTO);
		String successMsg = "You have successfully updated your details";
		return new ResponseEntity<>(successMsg,HttpStatus.ACCEPTED);
	}
	
//	While clicking on view profile of any other user i should see their info
//	Also able to see users tweets and retweets
	// Not Complete Api Call Modifications needed
	@GetMapping(value="/getUserDetails/{email}")
	public ResponseEntity<UserDTO> getUserDetails(@Valid @PathVariable String email)throws UserException{
		boolean userExists = userService.findEmailIfExists(email);
		if(!userExists) {
			throw new UserException("Service.USER_NOT_FOUND");
		}
		UserDTO userDTO = userService.getUserDetails(email);
		// Fetch Details of Tweets & Retweets Of User
		// Fetch Media of Respective Tweets should be there on there profile page
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllUsersDetails")
	public ResponseEntity<List<UserDTO>> getAllUsersDetails(){
		List<UserDTO> list = userService.getAllUsersInfo();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
