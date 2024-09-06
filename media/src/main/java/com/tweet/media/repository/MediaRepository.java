package com.tweet.media.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.media.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Integer> {
	Optional<Media> findByTweetId(Integer tweetId);

	void deleteByTweetId(Integer tweetId);
}