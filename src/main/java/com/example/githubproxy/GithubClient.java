package com.example.githubproxy;

import com.example.githubproxy.dto.GitHubBranchResponse;
import com.example.githubproxy.dto.GitHubRepoResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class GithubClient {

    private final RestClient restClient;

    public GithubClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.github.com").build();
    }

    public List<GitHubRepoResponse> fetchRepositories(String username) {
        return restClient.get()
                .uri("/users/{user}/repos", username)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new UserNotFoundException("User not found");
                })
                .body(new ParameterizedTypeReference<>() {});
    }

    public List<GitHubBranchResponse> fetchBranches(String owner, String repo) {
        return restClient.get()
                .uri("/repos/{owner}/{repo}/branches", owner, repo)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}