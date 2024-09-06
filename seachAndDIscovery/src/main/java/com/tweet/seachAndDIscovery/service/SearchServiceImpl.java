package com.tweet.seachAndDIscovery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tweet.seachAndDIscovery.dto.*;
import com.tweet.seachAndDIscovery.exception.SearchAndDiscoveryException;
import com.tweet.seachAndDIscovery.repository.SearchRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	private SearchRepository searchRepository;

	public List<UserDTO> filterList(List<UserDTO> users, String text){
		List<UserDTO> list = new ArrayList<>();
		// Filter by user names || name || bio
		list = users.stream().filter(
				(x) -> x.getUsername().contains(text) || x.getName().contains(text) || x.getBio().contains(text))
				.toList();

//		if (list.isEmpty()) {
//			throw new SearchAndDiscoveryException("No User Found");
//		}

		return list;
	}
	
	public List<TweetDTO> filterListOfTweets(List<TweetDTO> tweets,String text){
		List<TweetDTO> list = new ArrayList<>();
		
		list = tweets.stream().filter(
				(x) -> x.getMessage().contains(text) || x.getHashtags().contains(text)).toList();
		
		return list;
	}
}
