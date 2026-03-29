package com.example.githubproxy.dto;

public record GitHubBranchResponse(String name, Commit commit) { public record Commit(String sha) {} }