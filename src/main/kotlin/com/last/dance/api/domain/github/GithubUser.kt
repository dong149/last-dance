package com.last.dance.api.domain.github

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GithubUser(
    val id: Long,
    val login: String,
    val avatarUrl: String,
    val company: String,
    val followers: Long,
    val following: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
