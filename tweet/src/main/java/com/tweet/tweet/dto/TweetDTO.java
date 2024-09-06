package com.tweet.tweet.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TweetDTO {
	private Integer id;
	private Integer userId;
	private String message;
	private MediaDTO media;
	private LocalDateTime createdAt;
	List<String> hashtags;
	List<String> mentions;
	List<String> urls;

	public MediaDTO getMedia() {
		return media;
	}

	public void setMedia(MediaDTO media) {
		this.media = media;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public List<String> getMentions() {
		return mentions;
	}

	public void setMentions(List<String> mentions) {
		this.mentions = mentions;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

}