package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.tweet.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet,Integer> {
	List<Tweet> findByUserId(Integer userId);
}
