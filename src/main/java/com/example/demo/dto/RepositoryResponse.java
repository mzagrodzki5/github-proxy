package com.example.demo.dto;

import java.util.List;

public record RepositoryResponse(String name, Owner owner, List<Branch> branches) {}