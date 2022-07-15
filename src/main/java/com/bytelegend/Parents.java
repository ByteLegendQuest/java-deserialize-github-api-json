package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parents {
    private String url;
    private String sha;
    @JsonProperty("html_url")
    private String htmlUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
