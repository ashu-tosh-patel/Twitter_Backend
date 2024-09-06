package com.tweet.tweet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.tweet.dto.MediaDTO;
import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.entity.HashTag;
import com.tweet.tweet.entity.Link;
import com.tweet.tweet.entity.Mention;
import com.tweet.tweet.entity.Tweet;
import com.tweet.tweet.repository.HashTagRepository;
import com.tweet.tweet.repository.LinkRepository;
import com.tweet.tweet.repository.MentionRepository;
import com.tweet.tweet.repository.TweetRepository;

@Service(value = "tweetService")
public class TweetServiceImpl implements TweetService {

	@Autowired
	TweetRepository tr;

	@Autowired
	MentionRepository mr;

	@Autowired
	LinkRepository lr;

	@Autowired
	HashTagRepository htr;

	public List<TweetDTO> find() {
		List<TweetDTO> tweetDTOs = new ArrayList<>();
		List<Tweet> tweets = tr.findAll();
		for (Tweet tweet : tweets) {
			TweetDTO tweetDTO = new TweetDTO();
			List<Mention> mentions = mr.findByTweetId(tweet.getId());
			List<String> mentionedNames = mentions.stream().map(Mention::getUserName).collect(Collectors.toList());
			List<Link> links = lr.findByTweetId(tweet.getId());
			List<String> linkUrls = links.stream().map(Link::getUrl).collect(Collectors.toList());
			List<HashTag> hashtags = htr.findByTweetId(tweet.getId());
			List<String> tags = hashtags.stream().map(HashTag::getTag).collect(Collectors.toList());
			tweetDTO.setId(tweet.getId());
//			tweetDTO.setMediaLink(tweet.getMediaLink());
			tweetDTO.setMentions(mentionedNames);
			tweetDTO.setMessage(tweet.getMessage());
			tweetDTO.setUrls(linkUrls);
			tweetDTO.setUserId(tweet.getUserId());
			tweetDTO.setHashtags(tags);
			tweetDTO.setCreatedAt(tweet.getCreatedAt());
			tweetDTOs.add(tweetDTO);
		}
		return tweetDTOs;
	}

	public List<TweetDTO> findByUserId(Integer userId) {
		List<Tweet> tweets = tr.findByUserId(userId);
//		List<Tweet> tweet = tweetOP.get();
		List<TweetDTO> tweetDTOs = new ArrayList<>();
		for (Tweet tweet : tweets) {
			List<Mention> mentions = mr.findByTweetId(tweet.getId());
			List<String> mentionedNames = mentions.stream().map((m) -> m.getUserName()).collect(Collectors.toList());
			List<Link> links = lr.findByTweetId(tweet.getId());
			List<String> linkUrls = links.stream().map(Link::getUrl).collect(Collectors.toList());
			List<HashTag> hashtags = htr.findByTweetId(tweet.getId());
			List<String> tags = hashtags.stream().map(HashTag::getTag).collect(Collectors.toList());
			TweetDTO tweetDTO = new TweetDTO();
			tweetDTO.setId(tweet.getId());
//		tweetDTO.setMediaLink(tweet.getMediaLink());
			tweetDTO.setMentions(mentionedNames);
			tweetDTO.setMessage(tweet.getMessage());
			tweetDTO.setUrls(linkUrls);
			tweetDTO.setHashtags(tags);
			tweetDTO.setUserId(tweet.getUserId());
//		tweetDTO.setUserId(tweet.getUserId());
			tweetDTO.setCreatedAt(tweet.getCreatedAt());
			tweetDTOs.add(tweetDTO);
		}
		return tweetDTOs;
	}

	public void deleteById(Integer id) {
		tr.deleteById(id);
	}

	public Integer update(TweetDTO tweetDTO, Integer id) {
		Optional<Tweet> tweetOP = tr.findById(id);
		Tweet tweet = tweetOP.get();
		tweet.setId(tweetDTO.getId());
//		tweet.setMediaLink(tweetDTO.getMediaLink());
		tweet.setMessage(tweetDTO.getMessage());
		tweet.setUserId(tweetDTO.getUserId());
		return tr.save(tweet).getId();
	}

	public Integer add(TweetDTO tweetDTO) {
		Tweet tweet = new Tweet();
		tweet.setId(tweetDTO.getId());
//		tweet.setMediaLink(tweetDTO.getMediaLink());
		tweet.setMessage(tweetDTO.getMessage());
		tweet.setUserId(tweetDTO.getUserId());
		Tweet saved = tr.save(tweet);
		return saved.getId();
	}
}