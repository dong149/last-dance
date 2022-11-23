package com.last.dance.api.domain.report

import com.last.dance.api.domain.github.GithubApiPort
import org.springframework.stereotype.Service

@Service
class ReportService(
    private val githubApi: GithubApiPort,
) {
    fun getReportResponse(request: ReportRequest) {
        // get user info
        val user = githubApi.getGithubUserByUserName(userName = request.userName)

        // get repo infos
        val repos = githubApi.getGithubRepoInfosByUserName(userName = request.userName)

        TODO()
    }

    data class ReportRequest(
        val userName: String,
    )

    data class ReportResponse(
        val title: String,
        val description: String,
    )
}
