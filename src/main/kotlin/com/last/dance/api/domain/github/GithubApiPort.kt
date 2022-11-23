package com.last.dance.api.domain.github

interface GithubApiPort {
    fun getGithubUserByUserName(userName: String): GithubUser
    fun getGithubRepoInfosByUserName(userName: String): List<GithubRepo>
    fun getRepoInfo(repoName: String): GithubRepo
    fun getReadMeMd(userName: String, repoName: String, defaultBranchName: String): String
}
