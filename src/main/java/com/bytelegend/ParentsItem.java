package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentsItem{

    @JsonProperty("html_url")
    private String htmlUrl;

    private String sha;

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