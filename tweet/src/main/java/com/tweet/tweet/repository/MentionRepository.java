package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.tweet.entity.Mention;

public interface MentionRepository extends JpaRepository<Mention, Integer> {
	List<Mention> findByTweetId(Integer tweetId);
}