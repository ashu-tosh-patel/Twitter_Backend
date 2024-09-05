package com.tweet.tweet.service;

import java.util.ArrayList;
import java.util.List;

import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.entity.Tweet;

public interface TweetService {
	public List<TweetDTO> find();

	public TweetDTO findById(Integer id);

	public void deleteById(Integer id);

	public Integer update(TweetDTO tweetDTO, Integer id);

	public Integer add(TweetDTO tweetDTO);
}
