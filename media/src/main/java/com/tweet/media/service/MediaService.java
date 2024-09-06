package com.tweet.media.service;

import java.util.List;

import com.tweet.media.dto.MediaDTO;

public interface MediaService {
	List<MediaDTO> findByTweetId(Integer tweetId);

	String deleteByTweetId(Integer tweetId);

	Integer addMedia(MediaDTO mediaDTO);
}