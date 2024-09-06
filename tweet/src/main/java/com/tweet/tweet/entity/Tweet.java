package com.tweet.tweet.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TWEET")
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer userId;
	private String message;
//	private String mediaLink;
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
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

//	public String getMediaLink() {
//		return mediaLink;
//	}
//
//	public void setMediaLink(String mediaLink) {
//		this.mediaLink = mediaLink;
//	}

//	public List<String> getHashtags() {
//		return hashtags;
//	}
//
//	public void setHashtags(List<String> hashtags) {
//		this.hashtags = hashtags;
//	}
//
//	public List<String> getMentions() {
//		return mentions;
//	}
//
//	public void setMentions(List<String> mentions) {
//		this.mentions = mentions;
//	}
//
//	public List<String> getUrls() {
//		return urls;
//	}
//
//	public void setUrls(List<String> urls) {
//		this.urls = urls;
//	}

}