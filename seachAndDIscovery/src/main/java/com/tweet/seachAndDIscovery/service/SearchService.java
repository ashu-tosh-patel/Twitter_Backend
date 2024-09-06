package com.tweet.seachAndDIscovery.service;

import java.util.List;

import com.tweet.seachAndDIscovery.dto.TweetDTO;
import com.tweet.seachAndDIscovery.dto.UserDTO;
import com.tweet.seachAndDIscovery.exception.SearchAndDiscoveryException;

public interface SearchService {
	public List<UserDTO> filterList(List<UserDTO> users, String text);
	public List<TweetDTO> filterListOfTweets(List<TweetDTO> tweets,String text);
}
