package com.bytelegend;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

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

    public String getSha() {
        return Sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getMessage() {
        return message;
    }

    private String Sha;
    @JsonProperty("node_id")
    private String nodeId;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    private String message;

    public void setSha(String sha) {
        Sha = sha;
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

    public void setMessage(String message) {
        this.message = message;
    }


    public static class Author {
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

    private Author author;

    public Author getAuthor() {
        return author;
    }

    public static class Committer {
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

    private Committer committer;

    public Committer getCommitter() {
        return committer;
    }

    public static class Tree {
        private String url;
        private String sha;

        public String getSha() {
            return sha;
        }

        public String getUrl() {
            return url;
        }
    }

    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    public static class Parents {
        private String url;
        private String sha;
        @JsonProperty("html_url")
        private String htmlUrl;

        public String getUrl() {
            return url;
        }

        public String getSha() {
            return sha;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }
    }

    ArrayList<Parents> parents;

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public static class Verification {
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

    Verification verification;

    public Verification getVerification() {
        return verification;
    }
}
