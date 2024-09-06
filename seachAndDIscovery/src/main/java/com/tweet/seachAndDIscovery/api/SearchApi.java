package com.tweet.seachAndDIscovery.api;

import com.tweet.seachAndDIscovery.dto.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweet.seachAndDIscovery.dto.TweetDTO;
import com.tweet.seachAndDIscovery.dto.UserDTO;
import com.tweet.seachAndDIscovery.exception.SearchAndDiscoveryException;
import com.tweet.seachAndDIscovery.service.SearchService;

@RestController
@Validated
@CrossOrigin
@RequestMapping(value = "/search-api")
public class SearchApi {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private SearchService searchService;
	
	@GetMapping(value="/searchUsers/{text}")
	public ResponseEntity<List<UserDTO>> searchUsers(@PathVariable String text)throws SearchAndDiscoveryException{
		
		List<UserDTO> allUsersList = webClientBuilder.build().get().uri("http://localhost:8765/users/getAllUsersDetails").retrieve().bodyToMono(new ParameterizedTypeReference<List<UserDTO>>() {}).block();
		//Have to fetch all users data from UserMS
		List<UserDTO> list = searchService.filterList(allUsersList, text);
		
		if(list.isEmpty()) {
			throw new SearchAndDiscoveryException("Service.NO_USERS_FOUND");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchTweets/{text}")
	public ResponseEntity<List<TweetDTO>> searchTweets(@PathVariable String text)throws SearchAndDiscoveryException{
		
	    List<TweetDTO> allTweetsList =  webClientBuilder.build().get()
				.uri("http://localhost:8080/tweet-api/tweet")
				.retrieve().bodyToMono(new ParameterizedTypeReference<List<TweetDTO>>() {}).block();
		
		List<TweetDTO> list = searchService.filterListOfTweets(allTweetsList, text);
		
		if(list.isEmpty()) {
			throw new SearchAndDiscoveryException("Service.NO_TWEETS_FOUND");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}