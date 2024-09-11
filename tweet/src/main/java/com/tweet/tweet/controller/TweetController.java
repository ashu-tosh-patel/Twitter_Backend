package com.tweet.tweet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.tweet.tweet.dto.MediaDTO;
import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.service.TweetService;

@RestController
@CrossOrigin
@RequestMapping(value = "/tweet-api/user")
public class TweetController {

	@Autowired
	private TweetService ts;

	@Autowired
	private WebClient.Builder webBuilder;

	@GetMapping(value = "/tweet")
	public ResponseEntity<List<TweetDTO>> getAllTweets() {
		List<TweetDTO> tweetDTOs = ts.find();
		for (int i = 0; i < tweetDTOs.size(); i++) {
			MediaDTO mediaDTO = webBuilder.build().get()
					.uri("http://localhost:8081/media-api/media/" + tweetDTOs.get(i).getId()).retrieve()
					.bodyToMono(MediaDTO.class).block();
			tweetDTOs.get(i).setMedia(mediaDTO);
		}
		return new ResponseEntity<>(tweetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "{userId}/tweet")
	public ResponseEntity<List<TweetDTO>> getByUserId(@PathVariable Integer userId) throws Exception {
		List<TweetDTO> tweetDTOs = ts.findByUserId(userId);

		for (int i = 0; i < tweetDTOs.size(); i++) {
			MediaDTO mediaDTO = webBuilder.build().get()
					.uri("http://localhost:8081/media-api/media/" + tweetDTOs.get(i).getId()).retrieve()
					.bodyToMono(MediaDTO.class).block();
			tweetDTOs.get(i).setMedia(mediaDTO);
		}
		return new ResponseEntity<>(tweetDTOs, HttpStatus.OK);
	}

	@PostMapping(value = "{userId}/tweet")
	public ResponseEntity<Integer> add(@PathVariable Integer userId, @RequestBody TweetDTO tweetDTO) throws Exception {
		tweetDTO.setUserId(userId);
		MediaDTO mediaDTO = tweetDTO.getMedia();
		Integer addedTweetId = ts.add(tweetDTO);
		mediaDTO.setTweetId(addedTweetId);
		Integer mediaId = webBuilder.build().post().uri("http://localhost:8081/media-api/media").bodyValue(mediaDTO)
				.retrieve().bodyToMono(Integer.class).block();
		return new ResponseEntity<>(addedTweetId, HttpStatus.CREATED);
	}

	@PutMapping(value = "{userId}/tweet/{id}")
	public ResponseEntity<Integer> update(@PathVariable Integer userId, @PathVariable Integer id,
			@RequestBody TweetDTO tweetDTO) {
		return new ResponseEntity<>(ts.update(tweetDTO, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "{userId}/tweet/{id}")
	public ResponseEntity delete(@PathVariable Integer userId, @PathVariable Integer id) {
		ts.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}