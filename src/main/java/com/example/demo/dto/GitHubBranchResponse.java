package com.example.demo.dto;

public record GitHubBranchResponse(String name, Commit commit) { public record Commit(String sha) {} }