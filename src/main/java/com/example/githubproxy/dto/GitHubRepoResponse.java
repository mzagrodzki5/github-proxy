package com.example.githubproxy.dto;

public record GitHubRepoResponse(String name, Owner owner, boolean fork) {}