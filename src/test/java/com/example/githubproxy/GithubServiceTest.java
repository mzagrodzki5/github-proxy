package com.example.githubproxy;

import com.example.githubproxy.dto.GitHubRepoResponse;
import com.example.githubproxy.dto.Owner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubServiceTest {

    @Test
    public void testFiltering() {
        GithubClient client = Mockito.mock(GithubClient.class);
        GithubService service = new GithubService(client);

        var mockRepos = List.of(
                new GitHubRepoResponse("repo1", new Owner("user"), false),
                new GitHubRepoResponse("repo2", new Owner("user"), true)
        );

        Mockito.when(client.fetchRepositories("user")).thenReturn(mockRepos);
        Mockito.when(client.fetchBranches("user", "repo1")).thenReturn(List.of());

        var result = service.getUserRepositories("user");

        assertEquals(1, result.size());
        assertEquals("repo1", result.get(0).name());
    }
}