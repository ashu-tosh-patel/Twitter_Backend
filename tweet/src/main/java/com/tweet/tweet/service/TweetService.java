package com.tweet.tweet.service;

import java.util.List;
import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.exception.TweetException;

public interface TweetService {
	public List<TweetDTO> find();

	public List<TweetDTO> findByUserId(Integer id) throws TweetException;

	public void deleteById(Integer id);

	public Integer update(TweetDTO tweetDTO, Integer id) throws TweetException;

	public Integer add(TweetDTO tweetDTO) throws TweetException;
}
