package com.bytelegend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class Author {

    private String date;

    public String getDate() {
        return date;
    }

    private String name;

    public String getName() {
        return name;
    }

    private String email;

    public String getEmail() {
        return email;
    }
}

class Committer {

    private String date;

    public String getDate() {
        return date;
    }

    private String name;

    public String getName() {
        return name;
    }

    private String email;

    public String getEmail() {
        return email;
    }
}

class Tree {

    private String url;

    public String getUrl() {
        return url;
    }

    private String sha;

    public String getSha() {
        return sha;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}

class Verification {
    private boolean isVerified;

    public boolean isVerified() {
        return isVerified;
    }

    private String reason;

    public String getReason() {
        return reason;
    }

    private String signature;

    public String getSignature() {
        return signature;
    }

    private String payload;

    public String  getPayload() {
        return payload;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}

public class GitHubApiCommitObject {
    public static GitHubApiCommitObject fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper =
                new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .setPropertyNamingStrategy(new PropertyNamingStrategy.SnakeCaseStrategy());
        return mapper.readValue(json, GitHubApiCommitObject.class);
    }

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(new File("./commit.json").toPath()));
        GitHubApiCommitObject commit = GitHubApiCommitObject.fromJson(json);
    }

    private String sha;

    public String getSha() {
        return sha;
    }

    private String nodeId;

    public String getNodeId() {
        return nodeId;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    private String htmlUrl;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    private Author author;

    public Author getAuthor() {
        return author;
    }

    private Committer committer;

    public Committer getCommitter() {
        return committer;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    private List<GitHubApiCommitObject> parents;

    public List<GitHubApiCommitObject> getParents() {
        return parents;
    }

    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    private Verification verification;

    public Verification getVerification() {
        return verification;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setParents(List<GitHubApiCommitObject> parents) {
        this.parents = parents;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }
}
