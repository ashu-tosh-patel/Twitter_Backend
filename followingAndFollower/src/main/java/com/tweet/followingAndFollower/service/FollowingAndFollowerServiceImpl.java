package com.tweet.followingAndFollower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.followingAndFollower.entity.FollowingAndFollower;
import com.tweet.followingAndFollower.repository.FollowingAndFollowerRepository;

@Service
public class FollowingAndFollowerServiceImpl implements FollowingAndFollowerService {

	@Autowired
	FollowingAndFollowerRepository mr;

	@Override
	public List<Integer> getFollowers(Integer userId) {
		List<FollowingAndFollower> list = mr.findByFollowingId(userId);
		List<Integer> followers = list.stream().map(FollowingAndFollower::getFollowerId).toList();
		return followers;
	}

	@Override
	public List<Integer> getFollowing(Integer userId) {
		List<FollowingAndFollower> list = mr.findByFollowerId(userId);
		List<Integer> followings = list.stream().map(FollowingAndFollower::getFollowingId).toList();
		return followings;
	}
}
