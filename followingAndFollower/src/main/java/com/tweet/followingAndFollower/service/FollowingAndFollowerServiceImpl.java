package com.tweet.followingAndFollower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.followingAndFollower.entity.FollowingAndFollower;
import com.tweet.followingAndFollower.repository.FollowingAndFollowerRepository;

@Service
public class FollowingAndFollowerServiceImpl implements FollowingAndFollowerService {

	@Autowired
	FollowingAndFollowerRepository ffr;

	@Override
	public List<Integer> getFollowers(Integer userId) {
		List<FollowingAndFollower> list = ffr.findByFollowingId(userId);
		List<Integer> followers = list.stream().map(FollowingAndFollower::getFollowerId).toList();
		return followers;
	}

	@Override
	public List<Integer> getFollowing(Integer userId) {
		List<FollowingAndFollower> list = ffr.findByFollowerId(userId);
		List<Integer> followings = list.stream().map(FollowingAndFollower::getFollowingId).toList();
		return followings;
	}

	@Override
	public Integer follow(Integer followedById, Integer followedToId) {
		FollowingAndFollower ff = new FollowingAndFollower();
		ff.setFollowerId(followedById);
		ff.setFollowingId(followedToId);
		FollowingAndFollower saved = ffr.save(ff);
		return saved.getId();
	}
}
