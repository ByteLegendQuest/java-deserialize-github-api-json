package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Verification {
    @JsonProperty("verified")
    private boolean verified;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("signature")
    private Object signature;
    @JsonProperty("payload")
    private Object payload;

    public boolean isVerified() {
        return verified;
    }

    public String getReason() {
        return reason;
    }

    public Object getSignature() {
        return signature;
    }

    public Object getPayload() {
        return payload;
    }
}
