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
    private Committer committer;

    private Author author;

    @JsonProperty("html_url")
    private String htmlUrl;

    private Tree tree;

    private String message;

    private String sha;

    private String url;

    private Verification verification;

    @JsonProperty("node_id")
    private String nodeId;

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
    }
}

class Author {

    private String date;

    private String name;

    private String email;

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Committer {

    private String date;

    private String name;

    private String email;

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class ParentsItem {

    @JsonProperty("html_url")
    private String htmlUrl;

    private String sha;

    private String url;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getSha() {
        return sha;
    }

    public String getUrl() {
        return url;
    }
}

class Tree {

    private String sha;

    private String url;

    public String getSha() {
        return sha;
    }

    public String getUrl() {
        return url;
    }
}

class Verification {

    private String reason;

    private Object signature;

    private Object payload;

    private boolean verified;

    public String getReason() {
        return reason;
    }

    public Object getSignature() {
        return signature;
    }

    public Object getPayload() {
        return payload;
    }

    public boolean isVerified() {
        return verified;
    }
}