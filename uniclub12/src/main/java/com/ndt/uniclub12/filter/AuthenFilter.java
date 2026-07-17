package com.ndt.uniclub12.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;


import org.jspecify.annotations.NonNull;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.ndt.uniclub12.utils.JwtUtils;


@Service
@RequiredArgsConstructor
public class AuthenFilter extends OncePerRequestFilter {
    private final JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String token;
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);

            String data = jwtUtils.decodeJWTToken(token);

            if (data != null) {
                List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(data);

                SecurityContextHolder.getContext().setAuthentication(

                    // chỉ cấp thẻ thông hành, không cần ghi login info lên thẻ vì thông tin đã được lưu trong JWT token
                    // temporarily contain emptied permission
                    new UsernamePasswordAuthenticationToken(null, null, authorities)
                );
            }
        }

        filterChain.doFilter(request, response);
    }
}
