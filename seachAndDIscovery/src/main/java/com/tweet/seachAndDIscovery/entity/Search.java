package com.tweet.seachAndDIscovery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Search {
	@Id
	private Integer id;
	private String dummyName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDummyName() {
		return dummyName;
	}
	public void setDummyName(String dummyName) {
		this.dummyName = dummyName;
	}
	
}
