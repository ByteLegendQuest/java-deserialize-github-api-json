package com.bytelegend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class GitHubApiCommitObject {
    private String sha;
    private String node_id;
    private String url;
    private String html_url;
    private Author author;
    private Committer committer;
    private String message;
    private Tree tree;
    private ArrayList<Parents> parents;
    private Verification verification;

    public String getSha() {
        return sha;
    }
    public String getNodeId() {
        return node_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return html_url;
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

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public static GitHubApiCommitObject fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper =
                new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, GitHubApiCommitObject.class);
    }

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(new File("commit.json").toPath()));
        GitHubApiCommitObject commit = GitHubApiCommitObject.fromJson(json);
    }
}

class Verification{
    private boolean verified;
    private String reason;
    private String signature;
    private String payload;

    public boolean isVerified() {
        return verified;
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
}

class Parents{
    private String url;
    private String sha;
    private  String html_url;

    public String getUrl() {
        return url;
    }

    public String getSha() {
        return sha;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}

class Tree {
    private String url;
    private String sha;

    public String getUrl() {
        return url;
    }

    public String getSha() {
        return sha;
    }
}

class Author{
    private String name;
    private String email;
    private String date;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }
}

class Committer{
    private String name;
    private String email;
    private String date;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }
}
