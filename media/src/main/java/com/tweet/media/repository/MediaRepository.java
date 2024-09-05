package com.tweet.media.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.media.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Integer> {
	List<Media> findByTweetId(Integer tweetId);

	void deleteByTweetId(Integer tweetId);
}