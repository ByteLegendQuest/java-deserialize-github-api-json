package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tree {
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("url")
    private String url;

    public String getSha() {
        return sha;
    }

    public String getUrl() {
        return url;
    }
}
