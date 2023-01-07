package com.last.dance.api.infrastructure.config.auth

import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class JwtProvider(
    private val userDetailsService: UserDetailsService,
    @Value("\${auth.secretKey}")
    private val secretKey: String,
    @Value("\${auth.token.validTime}")
    private val tokenValidTime: Long,
) {
    fun resolveToken(request: HttpServletRequest): String? {
        return request.getHeader("Authorization")
    }

    fun validateToken(token : String) : Boolean {
        return try {
            val claims = Jwt
        } catch (e: Exception) {
            false
        }
    }
}
