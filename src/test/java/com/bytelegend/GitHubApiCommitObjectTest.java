package com.bytelegend;

import com.github.hcsp.test.helper.ClassInspector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

public class GitHubApiCommitObjectTest {
    @Test
    public void test() throws Exception {
        String json = new String(Files.readAllBytes(new File("./commit.json").toPath()));
        GitHubApiCommitObject commit = GitHubApiCommitObject.fromJson(json);

        Assertions.assertEquals("7638417db6d59f3c431d3e1f261cc637155684cd", commit.getSha());
        Assertions.assertEquals(
                "MDY6Q29tbWl0NmRjYjA5YjViNTc4NzVmMzM0ZjYxYWViZWQ2OTVlMmU0MTkzZGI1ZQ==",
                commit.getNodeId());
        Assertions.assertEquals(
                "https://api.github.com/repos/octocat/Hello-World/git/commits/7638417db6d59f3c431d3e1f261cc637155684cd",
                commit.getUrl());
        Assertions.assertEquals(
                "https://github.com/octocat/Hello-World/commit/7638417db6d59f3c431d3e1f261cc637155684cd",
                commit.getHtmlUrl());
        Assertions.assertEquals("2014-11-07T22:01:45Z", commit.getAuthor().getDate());
        Assertions.assertEquals("Monalisa Octocat", commit.getAuthor().getName());
        Assertions.assertEquals("octocat@github.com", commit.getAuthor().getEmail());
        Assertions.assertEquals("2014-11-07T22:01:45Z", commit.getCommitter().getDate());
        Assertions.assertEquals("Monalisa Octocat", commit.getCommitter().getName());
        Assertions.assertEquals("octocat@github.com", commit.getCommitter().getEmail());
        Assertions.assertEquals(
                "added readme, because im a good github citizen", commit.getMessage());
        Assertions.assertEquals(
                "https://api.github.com/repos/octocat/Hello-World/git/trees/691272480426f78a0138979dd3ce63b77f706feb",
                commit.getTree().getUrl());
        Assertions.assertEquals(
                "691272480426f78a0138979dd3ce63b77f706feb", commit.getTree().getSha());
        Assertions.assertEquals(1, commit.getParents().size());
        Assertions.assertEquals(
                "https://api.github.com/repos/octocat/Hello-World/git/commits/1acc419d4d6a9ce985db7be48c6349a0475975b5",
                commit.getParents().get(0).getUrl());
        Assertions.assertEquals(
                "1acc419d4d6a9ce985db7be48c6349a0475975b5", commit.getParents().get(0).getSha());
        Assertions.assertEquals(
                "https://github.com/octocat/Hello-World/commit/7638417db6d59f3c431d3e1f261cc637155684cd",
                commit.getParents().get(0).getHtmlUrl());

        Assertions.assertFalse(commit.getVerification().isVerified());
        Assertions.assertEquals("unsigned", commit.getVerification().getReason());
        Assertions.assertNull(commit.getVerification().getSignature());
        Assertions.assertNull(commit.getVerification().getPayload());
    }

    @Test
    public void noPublicFields() {
        ClassInspector.assertNoPublicFields(GitHubApiCommitObject.class);
    }
}
