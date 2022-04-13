package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentsItem{

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("sha")
	private String sha;

	@JsonProperty("url")
	private String url;

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public String getSha(){
		return sha;
	}

	public String getUrl(){
		return url;
	}
}