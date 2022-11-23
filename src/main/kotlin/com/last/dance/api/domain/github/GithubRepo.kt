package com.last.dance.api.domain.github

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GithubRepo(
    val id: Long,
    val name: String,
    val description: String,
    val htmlUrl: String,
    val stargazersCount: Long,
    val watchersCount: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val topics: List<String>,
    val defaultBranch: String,
    val language: String,
    val forksCount: Long,
)
