package com.tweet.tweet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.entity.Tweet;
import com.tweet.tweet.repository.HashTagRepository;
import com.tweet.tweet.repository.LinkRepository;
import com.tweet.tweet.repository.MentionRepository;
import com.tweet.tweet.repository.TweetRepository;
import com.tweet.tweet.service.*;

@SpringBootTest
class TweetApplicationTests {

	@Mock
	private TweetRepository tweetRepo;

	@Mock
	MentionRepository mr;

	@Mock
	LinkRepository lr;

	@Mock
	HashTagRepository htr;

	@InjectMocks
	private TweetService tweetService = new TweetServiceImpl();

	@Test
	void addValidTweetTest() throws Exception {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage("Dummy tweet for testing");
		tweetDTO.setUserId(1);
		tweetDTO.setHashtags(new ArrayList<String>());
		tweetDTO.setMentions(new ArrayList<String>());
		tweetDTO.setUrls(new ArrayList<String>());
		Tweet tweet = new Tweet();
		tweet.setId(1);
		Mockito.when(tweetRepo.save(Mockito.any(Tweet.class))).thenReturn(tweet);
		Integer savedId = tweetService.add(tweetDTO);
		Assertions.assertEquals(1, savedId);
	}

	@Test
	void addInValidTweetTest() throws Exception {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage(
				"An artifact refers to any deployable component of our software application. This can include things like application binaries (.jar, .war, .exe, etc.), container images (.docker), build scripts (.gradle, .maven, etc.), npm packages, or any other type of file that is used in the software development and deployment process. Artifactory is an open-source tool from JFrog, that serves as a central repository for storing and managing these artifacts allowing for easy access, version control, and distribution across development teams. It also offers features for security, access control, and metadata management for the stored artifacts.");
		tweetDTO.setUserId(1);
		tweetDTO.setHashtags(new ArrayList<String>());
		tweetDTO.setMentions(new ArrayList<String>());
		tweetDTO.setUrls(new ArrayList<String>());
		Exception exp = Assertions.assertThrows(Exception.class, () -> {
			tweetService.add(tweetDTO);
		});
		String expectedMessage = "Tweet message length can't be greater than 280";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void findByUserIdWithNoTweets() throws Exception {
		Mockito.when(tweetRepo.findByUserId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Exception exp = Assertions.assertThrows(Exception.class, () -> {
			tweetService.findByUserId(1);
		});
		String expectedMessage = "This user does not have any tweet";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void findByUserIdWithTweets() throws Exception {
		Mockito.when(mr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Mockito.when(lr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Mockito.when(htr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		List<Tweet> al = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			Tweet t = new Tweet();
			t.setCreatedAt(LocalDateTime.now());
			al.add(t);
		}
		Mockito.when(tweetRepo.findByUserId(Mockito.anyInt())).thenReturn(al);
		List<TweetDTO> tweets = tweetService.findByUserId(1);
		Assertions.assertEquals(2, tweets.size());
	}
}
