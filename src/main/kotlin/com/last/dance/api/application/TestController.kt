package com.last.dance.api.application

import com.last.dance.api.domain.TestService
import com.last.dance.api.domain.github.GithubRepo
import com.last.dance.api.domain.github.GithubUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1")
class TestController(
    private val testService: TestService,
) {
    @GetMapping("/users/{userName}")
    fun getUserByName(
        @PathVariable userName: String,
    ): GithubUser {
        return testService.getUser(userName)
    }

    @GetMapping("/repos/{userName}")
    fun getReposByName(
        @PathVariable userName: String,
    ): List<GithubRepo> {
        return testService.getRepos(userName)
    }

    @GetMapping("/repos/{userName}/{repoName}/{defaultBranchName}")
    fun getReadMeMd(
        @PathVariable userName: String,
        @PathVariable repoName: String,
        @PathVariable defaultBranchName: String,
    ): String {
        return testService.getReadMeMd(userName, repoName, defaultBranchName)
    }
}
