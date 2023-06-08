package com.bytelegend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GitHubApiCommitObject {

    private String nodeId;
    private String url;
    private String sha;
    private String htmlUrl;
    private Person author;
    private Person committer;
    private String message;
    private Node tree;
    private List<NodeWithHtml> parents;
    private Verification verification;

    public String getNodeId() {
        return nodeId;
    }

    public String getUrl() {
        return url;
    }

    public String getSha() {
        return sha;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public Person getAuthor() {
        return author;
    }

    public Person getCommitter() {
        return committer;
    }

    public String getMessage() {
        return message;
    }

    public Node getTree() {
        return tree;
    }

    public List<NodeWithHtml> getParents() {
        return parents;
    }

    public Verification getVerification() {
        return verification;
    }

    public static GitHubApiCommitObject fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper =
                new ObjectMapper()
                        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, GitHubApiCommitObject.class);
    }

    public static void main(String[] args) throws IOException {
        String json = new String(Files.readAllBytes(new File("./commit.json").toPath()));
        GitHubApiCommitObject commit = GitHubApiCommitObject.fromJson(json);
    }

    public static class Verification {
        boolean verified;
        String reason;
        String signature;
        String payload;

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

    public static class Node {
        String url;
        String sha;

        public String getUrl() {
            return url;
        }

        public String getSha() {
            return sha;
        }
    }

    public static class NodeWithHtml extends Node {
        String htmlUrl;

        public String getHtmlUrl() {
            return htmlUrl;
        }
    }

    public static class Person {
        String date;
        String name;
        String email;

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
}
