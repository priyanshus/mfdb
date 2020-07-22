package com.tw.mfdb.security;

import com.tw.mfdb.common.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
class JWTRequestFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(JWTRequestFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/api/v1/authenticate/") || request.getRequestURI().contains("h2-console")
                || request.getRequestURI().endsWith("signup")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");

        if (jwtToken.isEmpty()) {
            logger.info("Empty JWT");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (JwtUtil.verify(jwtToken)) {
            logger.info("Successful JWT verification");
            filterChain.doFilter(request, response);
            return;
        } else {
            logger.info("Signature mismatch in JWT verification");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }
}
