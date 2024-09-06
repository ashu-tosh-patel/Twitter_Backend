package com.tweet.seachAndDIscovery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweet.seachAndDIscovery.entity.Search;

@Repository
public interface SearchRepository extends JpaRepository<Search,Integer>{
	List<Search> findAllByUsername(String text);
	List<Search> findAllByName(String text);
	List<Search> findAllByBio(String text);
}
