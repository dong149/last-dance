package com.last.dance.api.domain.report

import org.springframework.stereotype.Service

@Service
class ScoreService {
    fun getScoreResponse(request: ScoreRequest): Int {
        // cache 확인

        // github 에서 데이터 가져옴.

        // cache 에 값 저장하기.

        // calculate 로직 통해서, 점수 가져옴.

        // 점수 cache 에 저장하기.

        // 점수 리턴

        TODO()
    }

    private fun calculateScore(): Int {
        TODO()
    }

    data class ScoreRequest(
        val readMeCount: Long,
        val followerCount: Long,
        val followingCount: Long,
        val profileExist: Boolean,
        val companyExist: Boolean,
        val commitsInYear: List<Long>,
    )

    data class ScoreResponse(
        val scoreValue: Int,
    )
}
