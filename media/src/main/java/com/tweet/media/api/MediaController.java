package com.tweet.media.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.media.dto.MediaDTO;
import com.tweet.media.service.MediaService;

@RestController
@RequestMapping(value = "/media-api")
@CrossOrigin
public class MediaController {
	@Autowired
	private MediaService ms;

	@GetMapping(value = "/media/{tweetId}")
	public ResponseEntity<List<MediaDTO>> findByTweetId(@PathVariable Integer tweetId) {
		return new ResponseEntity<>(ms.findByTweetId(tweetId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/media/{tweetId}")
	public ResponseEntity<String> deleteByTweetId(@PathVariable Integer tweetId) {
		return new ResponseEntity<>(ms.deleteByTweetId(tweetId), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/media")
	public ResponseEntity<Integer> addMedia(@RequestBody MediaDTO mediaDTO) {
		return new ResponseEntity<>(ms.addMedia(mediaDTO), HttpStatus.CREATED);
	}
}
