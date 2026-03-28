package com.example.demo.dto;

public record GitHubRepoResponse(String name, Owner owner, boolean fork) {}