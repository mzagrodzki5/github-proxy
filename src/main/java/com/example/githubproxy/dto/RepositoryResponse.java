package com.example.githubproxy.dto;

public record RepositoryResponse(String name, Owner owner, java.util.List<Branch> branches) {}