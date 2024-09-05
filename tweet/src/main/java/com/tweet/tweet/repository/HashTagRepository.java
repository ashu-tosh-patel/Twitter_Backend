package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.tweet.entity.HashTag;

public interface HashTagRepository extends JpaRepository<HashTag, Integer> {
	List<HashTag> findByTweetId(Integer tweetId);
}
