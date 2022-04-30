package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GitHubApiCommitObject {
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("committer")
    private Committer committer;
    @JsonProperty("message")
    private String message;
    @JsonProperty("tree")
    private Tree tree;
    @JsonProperty("parents")
    private List<Parents> parents;
    @JsonProperty("verification")
    private Verification verification;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getSha() {
        return sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getUrl() {
        return url;
    }

    public Author getAuthor() {
        return author;
    }

    public Committer getCommitter() {
        return committer;
    }

    public String getMessage() {
        return message;
    }

    public Tree getTree() {
        return tree;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public Verification getVerification() {
        return verification;
    }

    public static GitHubApiCommitObject fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper =
                new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, GitHubApiCommitObject.class);
    }

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(new File("./commit.json").toPath()));
        GitHubApiCommitObject commit = GitHubApiCommitObject.fromJson(json);
    }
}
