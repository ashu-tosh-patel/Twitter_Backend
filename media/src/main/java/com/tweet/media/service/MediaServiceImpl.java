package com.tweet.media.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.media.dto.MediaDTO;
import com.tweet.media.entity.Media;
import com.tweet.media.repository.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	MediaRepository mr;

	@Override
	public MediaDTO findByTweetId(Integer tweetId) {
		Optional<Media> mediaOP = mr.findByTweetId(tweetId);
		if (!mediaOP.isPresent()) {
			MediaDTO dum = new MediaDTO();
			dum.setUrl("No media for this tweet");
			return dum;
		}
		Media media = mediaOP.get();
		MediaDTO mediaDTO = new MediaDTO();
		mediaDTO.setId(media.getId());
		mediaDTO.setMediaType(media.getMediaType());
		mediaDTO.setTweetId(media.getTweetId());
		mediaDTO.setUrl(media.getUrl());
		return mediaDTO;
	}

	@Override
	public String deleteByTweetId(Integer tweetId) {
		mr.deleteByTweetId(tweetId);
		return "Deleted tweet with id: " + tweetId;
	}

	@Override
	public Integer addMedia(MediaDTO mediaDTO) {
		Media media = new Media();
		media.setMediaType(mediaDTO.getMediaType());
		media.setTweetId(mediaDTO.getTweetId());
		media.setUrl(mediaDTO.getUrl());
		Media saved = mr.save(media);
		return saved.getId();
	}

}
