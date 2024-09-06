package com.tweet.followingAndFollower.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FOLLOWING_AND_FOLLOWER")
public class FollowingAndFollower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
