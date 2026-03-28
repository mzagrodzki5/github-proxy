# GitHub-proxy

App connects to GitHub API and lists repositories for a specific user.

Features:
- App shows only original repos - forks are filtered
- For every repo it shows all branches and their last commit SHA.
- If a user that doesn't exist, you get a 404 error in JSON

Tech stack:
- Java 21
- Spring Boot 3.4
- RestClient for the API connection

How to run:
- Ensure you have Java 21 installed
- Clone repository
- Open the app using Maven

Then go to your browser:
http://localhost:8080/api/repositories/{username}