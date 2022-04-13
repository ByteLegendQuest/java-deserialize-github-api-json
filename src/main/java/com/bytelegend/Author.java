package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author{

	@JsonProperty("date")
	private String date;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	public String getDate(){
		return date;
	}

	public String getName(){
		return name;
	}

	public String getEmail(){
		return email;
	}
}