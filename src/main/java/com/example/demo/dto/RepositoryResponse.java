package com.example.demo.dto;

public record RepositoryResponse(String name, Owner owner, java.util.List<Branch> branches) {}