package com.test.ReviewDataEndpoint;

public class Review {

	private final String name;
	private final String avatarImageURL;
	private final String location;
	private final long rating;
	private final String content;

	public Review(String name, String avatarImageURL, String location, long rating, String content) {
		this.name = name;
		this.avatarImageURL = avatarImageURL;
		this.location = location;
		this.rating = rating;
		this.content = content;
	}
	
	public String getName() {
		return name;
	}

	public String getAvatar() {
		return avatarImageURL;
	}
	
	public String getLocation() {
		return location;
	}

	public long getRating() {
		return rating;
	}

	public String getContent() {
		return content;
	}
}
