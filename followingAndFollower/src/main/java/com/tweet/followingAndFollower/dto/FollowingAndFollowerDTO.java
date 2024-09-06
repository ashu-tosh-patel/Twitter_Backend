package com.tweet.followingAndFollower.dto;

public class FollowingAndFollowerDTO {
	private Integer id;
	private Integer followerId;
	private Integer followingId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Integer followerId) {
		this.followerId = followerId;
	}
	public Integer getFollowingId() {
		return followingId;
	}
	public void setFollowingId(Integer followingId) {
		this.followingId = followingId;
	}
	
}
