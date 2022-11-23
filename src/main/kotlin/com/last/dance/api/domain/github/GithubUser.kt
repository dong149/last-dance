package com.last.dance.api.domain.github

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GithubUser(
    val id: Long,
    val login: String,
    val avatarUrl: String,
)
