package com.tweet.followingAndFollower.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.followingAndFollower.service.FollowingAndFollowerService;

@RestController
@RequestMapping(value = "/followingAndFollower-api")
@CrossOrigin
public class FollowingAndFollowerController {
	@Autowired
	private FollowingAndFollowerService ffs;

	@GetMapping(value = "/followers/{userId}")
	public ResponseEntity<List<Integer>> getFollowers(@PathVariable Integer userId) {
		return new ResponseEntity<>(ffs.getFollowers(userId), HttpStatus.OK);
	}

	@GetMapping(value = "/following/{userId}")
	public ResponseEntity<List<Integer>> getFollowing(@PathVariable Integer userId) {
		return new ResponseEntity<>(ffs.getFollowing(userId), HttpStatus.OK);
	}
}