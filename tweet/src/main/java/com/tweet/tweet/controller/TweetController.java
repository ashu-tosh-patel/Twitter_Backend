package com.tweet.tweet.controller;

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
@RequestMapping(value = "/tweet-api")
public class TweetController {

	@Autowired
	private TweetService ts;

	@Autowired
	private WebClient.Builder webBuilder;

	@GetMapping(value = "/tweet")
	public ResponseEntity<List<TweetDTO>> getAllTweets() {
		List<TweetDTO> tweetDTOs = ts.find();
		return new ResponseEntity<>(tweetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/tweet/{id}")
	public ResponseEntity<TweetDTO> getById(@PathVariable Integer id) {
		TweetDTO tweetDTO = ts.findById(id);
//		MediaDTO mediaDTO = webBuilder.build().get().uri("http:")
		return new ResponseEntity<>(tweetDTO, HttpStatus.OK);
	}

	@PostMapping(value = "/tweet")
	public ResponseEntity<Integer> add(@RequestBody TweetDTO tweetDTO) {
		return new ResponseEntity<>(ts.add(tweetDTO), HttpStatus.CREATED);
	}

	@PutMapping(value = "/tweet/{id}")
	public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody TweetDTO tweetDTO) {
		return new ResponseEntity<>(ts.update(tweetDTO, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/tweet/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		ts.deleteById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}