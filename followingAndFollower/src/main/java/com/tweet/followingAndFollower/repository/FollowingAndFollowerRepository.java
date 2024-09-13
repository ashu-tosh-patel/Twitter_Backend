package com.tweet.followingAndFollower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.followingAndFollower.entity.FollowingAndFollower;

import jakarta.transaction.Transactional;

public interface FollowingAndFollowerRepository extends JpaRepository<FollowingAndFollower, Integer> {
	List<FollowingAndFollower> findByFollowingId(Integer followingId);

	List<FollowingAndFollower> findByFollowerId(Integer followerId);

	@Transactional
	void deleteByFollowerIdAndFollowingId(Integer followerId, Integer followingId);
}