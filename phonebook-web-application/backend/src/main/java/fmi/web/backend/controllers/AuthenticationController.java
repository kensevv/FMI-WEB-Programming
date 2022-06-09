package fmi.web.backend.controllers;

import fmi.web.backend.payload.LoginRequest;
import fmi.web.backend.security.MyTokenService;
import fmi.web.backend.security.UserDetailsImpl;
import fmi.web.backend.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class AuthenticationController {
	@Autowired
	protected BCryptPasswordEncoder passEncoder;
	@Autowired
	protected MyTokenService tokenService;
	@Autowired
	protected UserDetailsServiceImpl userDetailsService;

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws ParseException {

		String myToken;

		UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		if (null != userDetails) {
			if (passEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				myToken = tokenService.generateToken(loginRequest.getUsername());
				tokenService.persistToken(myToken);

				HttpHeaders authorizationHeader = new HttpHeaders();
				authorizationHeader.set("Authorization", myToken);
				return new ResponseEntity<>(authorizationHeader, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Wrong credentials", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("Account DISABLED", HttpStatus.BAD_REQUEST);
	}

	/*
	 * @PostMapping("/register") public ResponseEntity<?> register(@RequestParam
	 * String email, @RequestParam String username,
	 *
	 * @RequestParam String password) {
	 *
	 * }
	 */

}
