package fmi.web.backend.controllers;

import fmi.web.backend.entity.User;
import fmi.web.backend.payload.LoginRequest;
import fmi.web.backend.payload.SignupRequest;
import fmi.web.backend.security.MyTokenService;
import fmi.web.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	@Autowired
	private MyTokenService tokenService;
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

		User user = userService.getUserByUsername(loginRequest.getUsername());

		if (Objects.nonNull(user)) {
			if (passEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						user, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String myToken = tokenService.generateToken(loginRequest.getUsername());

				HttpHeaders authorizationHeader = new HttpHeaders();
				authorizationHeader.set("Authorization", myToken);
				return ResponseEntity.status(HttpStatus.OK).headers(authorizationHeader).body(user);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password");
			}
		}
		return new ResponseEntity<>("User doesn't exist!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/logout")
	public void logout() {
		SecurityContextHolder.clearContext();
	}


	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody SignupRequest registerRequest) {
		if (userService.getUserByUsername(registerRequest.getUsername()) != null) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}

		if (userService.getUserByEmail(registerRequest.getEmail()) != null) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}

		// Create new user's account
		User newUser = new User(
				UUID.randomUUID().toString(),
				registerRequest.getUsername(),
				passwordEncoder.encode(registerRequest.getPassword()),
				registerRequest.getEmail(),
				registerRequest.getFirstName(),
				registerRequest.getLastName(),
				null
		);
		userService.createUser(newUser);

		return ResponseEntity.ok("User registered successfully!");
	}

}
