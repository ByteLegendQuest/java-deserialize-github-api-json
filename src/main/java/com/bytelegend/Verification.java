package com.bytelegend;

public class Verification{

    private String reason;

    private Object signature;

    private Object payload;

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