package com.bytelegend;

public class Verification {
    private boolean verified;
    private String reason;
    private Object signature;
    private Object payload;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getSignature() {
        return signature;
    }

    public void setSignature(Object signature) {
        this.signature = signature;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
