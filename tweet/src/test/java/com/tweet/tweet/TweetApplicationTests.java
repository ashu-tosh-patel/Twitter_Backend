package com.tweet.tweet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.entity.HashTag;
import com.tweet.tweet.entity.Mention;
import com.tweet.tweet.entity.Tweet;
import com.tweet.tweet.exception.TweetException;
import com.tweet.tweet.entity.Link;
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
	void addValidTweetTest() throws TweetException {
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
	void addInValidTweetTest() throws TweetException {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage(
				"An artifact refers to any deployable component of our software application. This can include things like application binaries (.jar, .war, .exe, etc.), container images (.docker), build scripts (.gradle, .maven, etc.), npm packages, or any other type of file that is used in the software development and deployment process. Artifactory is an open-source tool from JFrog, that serves as a central repository for storing and managing these artifacts allowing for easy access, version control, and distribution across development teams. It also offers features for security, access control, and metadata management for the stored artifacts.");
		tweetDTO.setUserId(1);
		tweetDTO.setHashtags(new ArrayList<String>());
		tweetDTO.setMentions(new ArrayList<String>());
		tweetDTO.setUrls(new ArrayList<String>());
		TweetException exp = Assertions.assertThrows(TweetException.class, () -> {
			tweetService.add(tweetDTO);
		});
		String expectedMessage = "Tweet message length can't be greater than 280";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void findByUserIdWithNoTweets() throws TweetException {
		Mockito.when(tweetRepo.findByUserId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Exception exp = Assertions.assertThrows(Exception.class, () -> {
			tweetService.findByUserId(1);
		});
		String expectedMessage = "This user does not have any tweet";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void findByUserIdWithTweets() throws TweetException {
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

	@Test
	void updateTweetTest() throws TweetException {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage("Updated tweet message");
		tweetDTO.setUserId(1);

		Tweet existingTweet = new Tweet();
		existingTweet.setId(1);
		existingTweet.setMessage("Old message");
		existingTweet.setUserId(1);

		Mockito.when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(existingTweet));
		Mockito.when(tweetRepo.save(Mockito.any(Tweet.class))).thenReturn(existingTweet);

		Integer updatedId = tweetService.update(tweetDTO, 1);
		Assertions.assertEquals(1, updatedId);
		Assertions.assertEquals("Updated tweet message", existingTweet.getMessage());
	}

	@Test
	void updateTweetNotFoundTest() {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage("Updated tweet message");
		tweetDTO.setUserId(1);

		Mockito.when(tweetRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());

		Exception exp = Assertions.assertThrows(TweetException.class, () -> {
			tweetService.update(tweetDTO, 1);
		});
		String expectedMessage = "No tweet found with given id";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void findAllTweetsTest() {
		List<Tweet> tweets = new ArrayList<>();
		Tweet tweet1 = new Tweet();
		tweet1.setId(1);
		tweet1.setCreatedAt(LocalDateTime.now().minusDays(1));
		tweets.add(tweet1);

		Tweet tweet2 = new Tweet();
		tweet2.setId(2);
		tweet2.setCreatedAt(LocalDateTime.now());
		tweets.add(tweet2);

		Mockito.when(tweetRepo.findAll()).thenReturn(tweets);
		Mockito.when(mr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Mockito.when(lr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());
		Mockito.when(htr.findByTweetId(Mockito.anyInt())).thenReturn(new ArrayList<>());

		List<TweetDTO> tweetDTOs = tweetService.find();
		Assertions.assertEquals(2, tweetDTOs.size());
		Assertions.assertEquals(2, tweetDTOs.get(0).getId());
		Assertions.assertEquals(1, tweetDTOs.get(1).getId());
	}

	@Test
	void deleteTweetByIdTest() {
		Mockito.doNothing().when(tweetRepo).deleteById(Mockito.anyInt());

		Assertions.assertDoesNotThrow(() -> tweetService.deleteById(1));
	}

	@Test
	void findByUserIdNotFoundTest() throws TweetException {
		Mockito.when(tweetRepo.findByUserId(Mockito.anyInt())).thenReturn(new ArrayList<>());

		Exception exp = Assertions.assertThrows(Exception.class, () -> {
			tweetService.findByUserId(999);
		});
		String expectedMessage = "This user does not have any tweet";
		Assertions.assertEquals(expectedMessage, exp.getMessage());
	}

	@Test
	void addTweetWithDetailsTest() throws TweetException {
		TweetDTO tweetDTO = new TweetDTO();
		tweetDTO.setId(1);
		tweetDTO.setMessage("Tweet with hashtags, mentions, and links");
		tweetDTO.setUserId(1);
		tweetDTO.setHashtags(List.of("tag1", "tag2"));
		tweetDTO.setMentions(List.of("user1", "user2"));
		tweetDTO.setUrls(List.of("http://example.com"));

		Tweet tweet = new Tweet();
		tweet.setId(1);
		Mockito.when(tweetRepo.save(Mockito.any(Tweet.class))).thenReturn(tweet);

		Mockito.when(htr.save(Mockito.any(HashTag.class))).thenAnswer(invocation -> invocation.getArgument(0));
		Mockito.when(mr.save(Mockito.any(Mention.class))).thenAnswer(invocation -> invocation.getArgument(0));
		Mockito.when(lr.save(Mockito.any(Link.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Integer savedId = tweetService.add(tweetDTO);
		Assertions.assertEquals(1, savedId);

		Mockito.verify(htr, Mockito.times(2)).save(Mockito.any(HashTag.class));
		Mockito.verify(mr, Mockito.times(2)).save(Mockito.any(Mention.class));
		Mockito.verify(lr, Mockito.times(1)).save(Mockito.any(Link.class));
	}

}
