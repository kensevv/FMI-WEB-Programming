package fmi.web.backend.security;

import fmi.web.backend.entity.User;
import fmi.web.backend.services.UserService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Filter(name = "TokenFilter")
public class MyTokenFilter extends OncePerRequestFilter {
	@Autowired
	private MyTokenService tokenService;
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String myToken = "";
			if (request.getCookies() != null) {
				myToken = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("authorization")).findFirst().orElse(new Cookie("authorization", "")).getValue();
			}

			if (tokenService.validateToken(myToken)) {
				String username = tokenService.extractUsernameFromToken(myToken);

				User user = userService.getUserByUsername(username);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						user, null, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}
		filterChain.doFilter(request, response);
	}
}