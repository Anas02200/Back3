package Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.entities.Artisan;
import com.entities.Client;
import com.entities.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	//private Authentication authentication;

	public JwtAuthentificationFilter(AuthenticationManager authenticationManager) {

		this.authenticationManager = authenticationManager;

		return;

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		
		//User user=null;
		
		
		try {
			Admin user = new ObjectMapper().readValue(request.getInputStream(), Admin.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getname(),user.getPassword()));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException("error");
		}

		/*try {
			Artisan user = new ObjectMapper().readValue(request.getInputStream(), Artisan.class);
			this.authentication= authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getname(),user.getPassword()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Client user = new ObjectMapper().readValue(request.getInputStream(), Client.class);
			this.authentication= authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		//return this.authentication;
			
		
		
		//return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("user1", "1234"));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		response.addHeader("Access-Control-Allow-Headers","Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,Access-Control-Allow-Credentials,Authorization");
		User user = (User) authResult.getPrincipal();
		List<String> roles = new ArrayList<>();
		authResult.getAuthorities().forEach(a -> {
			roles.add(a.getAuthority());
		});
		String Jwt = JWT.create().withIssuer(request.getRequestURI()).withSubject(user.getUsername())
				.withArrayClaim("roles", roles.toArray(new String[roles.size()]))
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
				.sign(Algorithm.HMAC256(SecurityParams.SECRET));
		response.addHeader(SecurityParams.JWT_HEADER_NAME,SecurityParams.HEADER_PREFIX+Jwt);
		

	}

}
