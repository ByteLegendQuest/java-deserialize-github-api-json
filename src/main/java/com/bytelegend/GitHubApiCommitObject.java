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
    public GitHubApiCommitObject() {
    }

    public String getSha() {
        return sha;
    }

    public String getNodeId() {
        return nodeID;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

    public String getSignature() {
        return signature;
    }

    public String getPayload() {
        return payload;
    }

    public GitHubApiCommitObject getTree() {
        return tree;
    }

    public GitHubApiCommitObject getCommitter() {
        return committer;
    }

    public GitHubApiCommitObject getVerification() {
        return verification;
    }

    public GitHubApiCommitObject getAuthor() {
        return author;
    }

    public List<GitHubApiCommitObject> getParents() {
        return parents;
    }
    private String sha;

    @JsonProperty("node_id")
    private String nodeID;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;


    @JsonProperty("message")
    private String message;

    @JsonProperty("date")
    private String date;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("payload")
    private String payload;

    @JsonProperty("author")
    private GitHubApiCommitObject author;

    @JsonProperty("committer")
    private GitHubApiCommitObject committer;

    @JsonProperty("tree")
    private GitHubApiCommitObject tree;
    @JsonProperty("verification")
    private GitHubApiCommitObject verification;

    @JsonProperty("parents")
    private List<GitHubApiCommitObject> parents;

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
