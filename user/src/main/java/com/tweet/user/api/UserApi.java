package com.tweet.user.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweet.user.dto.TweetDTO;
import com.tweet.user.dto.UserDTO;
//import com.tweet.user.entity.User;
import com.tweet.user.exception.UserException;
//import com.tweet.user.repository.UserRepository;
import com.tweet.user.service.UserService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/users")
@Validated
@CrossOrigin
public class UserApi {
	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;

	@Autowired
	private WebClient.Builder webClientBuilder;

//	User Registration
	@PostMapping(value = "/userRegistration")
	public ResponseEntity<String> userRegistration(@RequestBody @Valid UserDTO userDTO) throws UserException {
		// Check if email already exists
		boolean userExists = userService.findEmailIfExists(userDTO.getEmail());
		if (userExists) {
			throw new UserException("Service.USER_ALREADY_EXISTS");
		}
		Integer num = userService.registerUser(userDTO);
		String msg = "You account has been successfully created : ";
		String successMsg = msg + num.toString();
		return new ResponseEntity<>(successMsg, HttpStatus.CREATED);
	}

//	User Authentication
	@PostMapping(value = "/userAuthentication")
	public ResponseEntity<String> userAuthentication(@RequestBody UserDTO userDTO) throws UserException {
		String email = userDTO.getEmail();
		String password = userDTO.getPassword();
		boolean credentialsAreCorrect = userService.checkCredentials(email, password);
		if (!credentialsAreCorrect) {
			throw new UserException("Service.INCORRECT_CREDENTIALS");
		}
		String successMsg = "Login successfull";
		return new ResponseEntity<>(successMsg, HttpStatus.FOUND);
	}

//	Updating User Profile
	@PutMapping(value = "/updateProfile")
	public ResponseEntity<String> updateUserProfile(@RequestBody UserDTO userDTO) {
		// No verification since User can only change profile after being logged in
		userService.updateUserProfile(userDTO);
		String successMsg = "You have successfully updated your details";
		return new ResponseEntity<>(successMsg, HttpStatus.ACCEPTED);
	}

//	While clicking on view profile of any other user i should see their info
//	Also able to see users tweets and retweets
	// Not Complete Api Call Modifications needed
	@GetMapping(value = "/getUserDetails/{email}")
	public ResponseEntity<UserDTO> getUserDetails(@Valid @PathVariable String email) throws UserException {
		boolean userExists = userService.findEmailIfExists(email);
		if (!userExists) {
			throw new UserException("Service.USER_NOT_FOUND");
		}
		UserDTO userDTO = userService.getUserDetails(email);
		// Fetch Tweets and related media of particular user
		List<TweetDTO> tweetDTOs = webClientBuilder.build().get()
				.uri("http://localhost:8080/tweet-api/user/{userId}/tweet", userDTO.getId()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<TweetDTO>>() {
				}).block();
		userDTO.setTweetDTOs(tweetDTOs);
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getUser/{userId}")
	public Mono<ResponseEntity<UserDTO>> getUserDetails(@Valid @PathVariable Integer userId) {
		System.out.println("Get user called with id: " + userId);

		return Mono.fromCallable(() -> userService.getUserDetails(userId)) // Wrap your existing service call
				.flatMap(userDTO -> {
					System.out.println("User ID from userDTO: " + userDTO.getId());
					String url = "http://localhost:8080/tweet-api/user/" + userDTO.getId() + "/tweet";
					System.out.println("Attempting to call URL: " + url);

					return webClientBuilder.build()
							.get()
							.uri(url)
							.retrieve()
							.bodyToFlux(TweetDTO.class) // Use Flux since it returns a list
							.collectList() // Collect Flux<TweetDTO> into List<TweetDTO>
							.doOnError(error -> {
								System.err.println("Error occurred while calling tweet service:");
								System.err.println("Error type: " + error.getClass().getName());
								System.err.println("Error message: " + error.getMessage());
								error.printStackTrace();
							})
							.defaultIfEmpty(new ArrayList<>()) // Return empty list on error
							.map(tweets -> {
								userDTO.setTweetDTOs(tweets);
								return ResponseEntity.ok(userDTO);
							});
				});
	}


	@GetMapping(value = "/getAllUsersDetails")
	public ResponseEntity<List<UserDTO>> getAllUsersDetails() {
		List<UserDTO> list = userService.getAllUsersInfo();
		List<UserDTO> res = new ArrayList<>();
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			String email = list.get(i).getEmail();
			UserDTO userDTO = userService.getUserDetails(email);
//			List<TweetDTO> tweetDTOs = webClientBuilder.build().get()
//					.uri("http://localhost:8083/tweet-api/user/{userId}/tweet", userDTO.getId()).retrieve()
//					.bodyToMono(new ParameterizedTypeReference<List<TweetDTO>>() {
//					}).block();
			List<TweetDTO> tweetDTOs = new ArrayList<>();
			try {

				tweetDTOs = webClientBuilder.build().get()
						.uri("http://localhost:8080/tweet-api/user/{userId}/tweet", userDTO.getId()).retrieve()
						.bodyToMono(new ParameterizedTypeReference<List<TweetDTO>>() {
						}).block();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			userDTO.setTweetDTOs(tweetDTOs);
			res.add(userDTO);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
