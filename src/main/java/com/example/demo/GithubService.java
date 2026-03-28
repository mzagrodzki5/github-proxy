package com.example.demo;

import com.example.demo.dto.Branch;
import com.example.demo.dto.Owner;
import com.example.demo.dto.RepositoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubService {

    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public List<RepositoryResponse> getUserRepositories(String username) {
        var repos = githubClient.fetchRepositories(username);

        return repos.stream()
                .filter(repo -> !repo.fork())
                .map(repo -> {
                    var branches = githubClient.fetchBranches(repo.owner().login(), repo.name());

                    var branchList = branches.stream()
                            .map(b -> new Branch(b.name(), b.commit().sha()))
                            .toList();

                    return new RepositoryResponse(repo.name(), new Owner(repo.owner().login()), branchList);
                })
                .toList();
    }
}