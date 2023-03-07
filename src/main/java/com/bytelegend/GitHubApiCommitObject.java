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
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    private Author author;
    private Committer committer;
    private String message;
    private Tree tree;
    private ArrayList<Parents> parents;
    private Verification verification;


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

    public static class Tree {
        private String url;
        private String sha;

        public String getUrl() {
            return url;
        }

        public String getSha() {
            return sha;
        }
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

    public String getSha() {
        return sha;
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