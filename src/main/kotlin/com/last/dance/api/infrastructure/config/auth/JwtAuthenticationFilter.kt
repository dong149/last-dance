package com.last.dance.api.infrastructure.config.auth

import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import org.springframework.web.filter.GenericFilterBean

class JwtAuthenticationFilter(
    private val jwtProvider: JwtProvider,
) : GenericFilterBean() {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val token = jwtProvider.resolveToken(request as HttpServletRequest)

        if (token != null && )
    }
}
