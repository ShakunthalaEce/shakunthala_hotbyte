package com.hexaware.hotbyte.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hexaware.hotbyte.service.UserDetailsServiceImpl;
import com.hexaware.hotbyte.util.JwtUtil;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			email = jwtUtil.extractUsername(token);
		}

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			if (jwtUtil.validateToken(token, userDetails)) {
				Claims claims = jwtUtil.extractAllClaims(token);
				Object rolesObject = claims.get("role");
				if (rolesObject instanceof java.util.List) {
					@SuppressWarnings("unchecked")
					java.util.List<String> roles = (java.util.List<String>) rolesObject;

					java.util.List<SimpleGrantedAuthority> authorities = roles.stream()
							.map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
							.collect(java.util.stream.Collectors.toList());

					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
							null, authorities);

					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}