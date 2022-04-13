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
    @JsonProperty("committer")
    private Committer committer;

    @JsonProperty("author")
    private Author author;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("tree")
    private Tree tree;

    @JsonProperty("message")
    private String message;

    @JsonProperty("sha")
    private String sha;

    @JsonProperty("url")
    private String url;

    @JsonProperty("verification")
    private Verification verification;

    @JsonProperty("node_id")
    private String nodeId;

    @JsonProperty("parents")
    private List<ParentsItem> parents;

    public Committer getCommitter() {
        return committer;
    }

    public Author getAuthor() {
        return author;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public Tree getTree() {
        return tree;
    }

    public String getMessage() {
        return message;
    }

    public String getSha() {
        return sha;
    }

    public String getUrl() {
        return url;
    }

    public Verification getVerification() {
        return verification;
    }

    public String getNodeId() {
        return nodeId;
    }

    public List<ParentsItem> getParents() {
        return parents;
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
        System.out.println(commit);
    }
}
