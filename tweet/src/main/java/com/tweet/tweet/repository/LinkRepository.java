package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.tweet.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Integer> {
	List<Link> findByTweetId(Integer tweetId);
}
