package com.tweet.tweet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.tweet.dto.TweetDTO;
import com.tweet.tweet.entity.HashTag;
import com.tweet.tweet.entity.Link;
import com.tweet.tweet.entity.Mention;
import com.tweet.tweet.entity.Tweet;
import com.tweet.tweet.exception.TweetException;
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
			List<String> mentionedNames = mentions.stream().map(Mention::getUserName).toList();
			List<Link> links = lr.findByTweetId(tweet.getId());
			List<String> linkUrls = links.stream().map(Link::getUrl).toList();
			List<HashTag> hashtags = htr.findByTweetId(tweet.getId());
			List<String> tags = hashtags.stream().map(HashTag::getTag).toList();
			tweetDTO.setId(tweet.getId());
			tweetDTO.setMentions(mentionedNames);
			tweetDTO.setMessage(tweet.getMessage());
			tweetDTO.setUrls(linkUrls);
			tweetDTO.setUserId(tweet.getUserId());
			tweetDTO.setHashtags(tags);
			tweetDTO.setCreatedAt(tweet.getCreatedAt());
			tweetDTOs.add(tweetDTO);
		}
		tweetDTOs.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
		return tweetDTOs;
	}

	public List<TweetDTO> findByUserId(Integer userId) throws TweetException {
		List<Tweet> tweets = tr.findByUserId(userId);
		if (tweets == null || tweets.isEmpty()) {
			throw new TweetException("This user does not have any tweet");
		}
		List<TweetDTO> tweetDTOs = new ArrayList<>();
		for (Tweet tweet : tweets) {
			List<Mention> mentions = mr.findByTweetId(tweet.getId());
			List<String> mentionedNames = mentions.stream().map(Mention::getUserName).toList();
			List<Link> links = lr.findByTweetId(tweet.getId());
			List<String> linkUrls = links.stream().map(Link::getUrl).toList();
			List<HashTag> hashtags = htr.findByTweetId(tweet.getId());
			List<String> tags = hashtags.stream().map(HashTag::getTag).toList();
			TweetDTO tweetDTO = new TweetDTO();
			tweetDTO.setId(tweet.getId());
			tweetDTO.setMentions(mentionedNames);
			tweetDTO.setMessage(tweet.getMessage());
			tweetDTO.setUrls(linkUrls);
			tweetDTO.setHashtags(tags);
			tweetDTO.setUserId(tweet.getUserId());
			tweetDTO.setCreatedAt(tweet.getCreatedAt());
			tweetDTOs.add(tweetDTO);
		}
		tweetDTOs.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
		return tweetDTOs;
	}

	public void deleteById(Integer id) {
		tr.deleteById(id);
	}

	public Integer update(TweetDTO tweetDTO, Integer id) throws TweetException {
		Optional<Tweet> tweetOP = tr.findById(id);
		if (!tweetOP.isPresent()) {
			throw new TweetException("No tweet found with given id");
		}
		Tweet tweet = tweetOP.get();
		tweet.setId(tweetDTO.getId());
		tweet.setMessage(tweetDTO.getMessage());
		tweet.setUserId(tweetDTO.getUserId());
		return tr.save(tweet).getId();
	}

	public Integer add(TweetDTO tweetDTO) throws TweetException {
		if (tweetDTO.getMessage().length() > 280) {
			throw new TweetException("Tweet message length can't be greater than 280");
		}
		Tweet tweet = new Tweet();
		tweet.setMessage(tweetDTO.getMessage());
		tweet.setUserId(tweetDTO.getUserId());
		Tweet saved = tr.save(tweet);
		List<String> hashtags = tweetDTO.getHashtags();
		for (String hashtag : hashtags) {
			HashTag ht = new HashTag();
			ht.setTag(hashtag);
			ht.setTweetId(saved.getId());
			htr.save(ht);
		}
		List<String> mentions = tweetDTO.getMentions();
		for (String mention : mentions) {
			Mention mn = new Mention();
			mn.setUserName(mention);
			mn.setTweetId(saved.getId());
			mr.save(mn);
		}
		List<String> urls = tweetDTO.getUrls();
		for (String url : urls) {
			Link l = new Link();
			l.setUrl(url);
			l.setTweetId(saved.getId());
			lr.save(l);
		}
		return saved.getId();
	}
}