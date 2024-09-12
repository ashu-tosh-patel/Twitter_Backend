package com.tweet.user.dto;

import java.util.List;

import com.tweet.user.entity.Status;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {
	private Integer id;
	@NotEmpty(message="{user.name.invalid}")
	@Pattern(regexp="[A-Z][A-Za-z]+( [A-Z][A-Za-z]+)*",message="{user.name.validation}")
	private String name;
	private String username;
	@NotEmpty(message="{user.email.invalid}")
	@Pattern(regexp="[a-z._0-9]+[@][a-z]+[.](com|org|in)",message="{user.email.validation}")
	private String email;
	@NotEmpty(message="{user.password.invalid}")
	@Pattern(regexp="[A-Za-z0-9!@_]+",message="{user.password.validation}")
	@Size(min=8,max=16,message="{user.password.length}")
	private String password;
	private String profilePic;
	private String coverPic;
	private String bio;
	private String location;
	private String website;
	private List<TweetDTO> tweetDTOs;
//	private Status status;
//    public Status getStatus() {
//		return status;
//	}
//	public void setStatus(Status status) {
//		this.status = status;
//	}
	//	private List<Integer> feedTweets;
	
	public Integer getId() {
		return id;
	}
	public List<TweetDTO> getTweetDTOs() {
		return tweetDTOs;
	}
	public void setTweetDTOs(List<TweetDTO> tweetDTOs) {
		this.tweetDTOs = tweetDTOs;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
//	public List<Integer> getFeedTweets() {
//		return feedTweets;
//	}
//	public void setFeedTweets(List<Integer> feedTweets) {
//		this.feedTweets = feedTweets;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", profilePic=" + profilePic + ", coverPic=" + coverPic + ", bio=" + bio + ", location="
				+ location + ", website=" + website + ", tweetDTOs=" + tweetDTOs + "]";
	}
	
	
	
}
