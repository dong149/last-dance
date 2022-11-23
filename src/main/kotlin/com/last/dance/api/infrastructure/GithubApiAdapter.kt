package com.last.dance.api.infrastructure

import com.last.dance.api.domain.github.GithubApiPort
import com.last.dance.api.domain.github.GithubRepo
import com.last.dance.api.domain.github.GithubUser
import java.rmi.UnexpectedException
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class GithubApiAdapter(
    private val restTemplate: RestTemplate,
    @Value("\${github.token}")
    private val token: String,
) : GithubApiPort {
    override fun getGithubUserByName(userName: String): GithubUser {
        val headers = HttpHeaders()
        headers.set("Authorization", token)
        val request = HttpEntity<Map<String, String>>(headers)

        val response = restTemplate.exchange(
            UriComponentsBuilder
                .fromHttpUrl(GITHUB_API_HOST)
                .path("/users/${userName}")
                .build()
                .toUri(),
            HttpMethod.GET,
            request,
            GithubUser::class.java
        )

        return response.body ?: throw UnexpectedException("github return is empty")
    }

    override fun getGithubRepoInfosByUserName(userName: String): List<GithubRepo> {
        val headers = HttpHeaders()
        headers.set("Authorization", "Bearer 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")
        val request = HttpEntity<Map<String, String>>(headers)

        val response = restTemplate.exchange(
            UriComponentsBuilder
                .fromHttpUrl(GITHUB_API_HOST)
                .path("/users/${userName}/repos")
                .build()
                .toUri(),
            HttpMethod.GET,
            request,
            object : ParameterizedTypeReference<List<GithubRepo>>() {},
        )

        return response.body ?: throw UnexpectedException("github return is empty")
    }

    override fun getRepoInfo(repoName: String): GithubRepo {
        TODO("Not yet implemented")
    }

    override fun getReadMeMd(userName: String, repoName: String, defaultBranchName: String): String {
        return try {
            val response = restTemplate.getForEntity(
                UriComponentsBuilder
                    .fromHttpUrl(GITHUB_GET_RAW_CONTENT_HOST)
                    .path("/${userName}/${repoName}/${defaultBranchName}/README.md")
                    .build()
                    .toUri(), String::class.java
            )

            return response.body ?: EMPTY_STRING
        } catch (ex : Exception) {
            return EMPTY_STRING
        }
    }

    companion object {
        const val GITHUB_API_HOST = "https://api.github.com"
        const val GITHUB_GET_RAW_CONTENT_HOST = "https://raw.githubusercontent.com"
        const val EMPTY_STRING = ""
    }
}
