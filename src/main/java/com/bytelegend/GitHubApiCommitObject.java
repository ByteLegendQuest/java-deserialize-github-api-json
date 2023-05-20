package com.bytelegend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GitHubApiCommitObject {
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

    private Person author;
    public Person getAuthor() {
        return author;
    }
    
    private Person committer;
    public Person getCommitter() {
        return committer;
    }

    private String message;
    public Object getMessage() {
        return message;
    }

    private GitHubApiCommitObject tree;
    public GitHubApiCommitObject getTree() {
        return tree;
    }

    private List<GitHubApiCommitObject> parents = new ArrayList<>();
    public List<GitHubApiCommitObject> getParents() {
        return parents;
    }

    private Verification verification;
    public Verification getVerification() {
        return verification;
    }
}

class Person {

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

class Verification {

    private boolean verified;
    public boolean isVerified() {
        return verified;
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
    public String getPayload() {
        return payload;
    }
    
}