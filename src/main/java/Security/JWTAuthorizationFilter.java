package Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");

		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin,Access-Control-Allow-Credentials,Authorization,Access-Control-Allow-Headers");
		//response.addHeader("Access-Control-Allow-Methods", "GET,POST,PATCH,PUT,DELETE");
		if (request.getMethod().equals("OPTION")) {

			response.setStatus(HttpServletResponse.SC_OK);
		} else if (request.getRequestURI().equals("/login")) {
			filterChain.doFilter(request, response);
			return;
		}

		else {

			String jwt = request.getHeader(SecurityParams.JWT_HEADER_NAME);
			// System.out.println("jwt=" + jwt);
			if (jwt == null || !jwt.startsWith(SecurityParams.HEADER_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityParams.SECRET)).build();
			DecodedJWT decodedJWT = verifier.verify(jwt.substring(SecurityParams.HEADER_PREFIX.length()));
			String username = decodedJWT.getSubject();
			List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
			// System.out.println("name=" + username);
			// System.out.println("roles=" + roles);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(rn -> {
				authorities.add(new SimpleGrantedAuthority(rn));

			});
			UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(user);
			filterChain.doFilter(request, response);

		}
	}
}
