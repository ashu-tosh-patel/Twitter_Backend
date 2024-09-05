package com.tweet.followingAndFollower.service;

import java.util.List;

public interface FollowingAndFollowerService {
	List<Integer> getFollowers(Integer followingId);

	List<Integer> getFollowing(Integer followerId);
}