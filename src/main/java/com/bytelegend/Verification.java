package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification{

	@JsonProperty("reason")
	private String reason;

	@JsonProperty("signature")
	private Object signature;

	@JsonProperty("payload")
	private Object payload;

	@JsonProperty("verified")
	private boolean verified;

	public String getReason(){
		return reason;
	}

	public Object getSignature(){
		return signature;
	}

	public Object getPayload(){
		return payload;
	}

	public boolean isVerified(){
		return verified;
	}
}