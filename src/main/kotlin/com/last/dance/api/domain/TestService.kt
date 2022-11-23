package com.last.dance.api.domain

import com.last.dance.api.domain.github.GithubRepo
import com.last.dance.api.domain.github.GithubUser
import com.last.dance.api.infrastructure.GithubApiAdapter
import org.springframework.stereotype.Service

@Service
class TestService(
    private val githubApiAdapter: GithubApiAdapter
) {
    fun calcScore() {

    }

    fun getUser(userName: String): GithubUser {
         return githubApiAdapter.getGithubUserByName(userName)
    }

    fun getRepos(userName: String): List<GithubRepo> {
        return githubApiAdapter.getGithubRepoInfosByUserName(userName)
    }

    fun getReadMeMd(userName: String, repoName: String, defaultBranchName: String): String {
        return githubApiAdapter.getReadMeMd(userName,repoName,defaultBranchName)
    }
}
