package com.bank.controller;

// Annotations @ changes java class into Spring/Maven/Hibernate class
/* GET POST PUT DELETE (CRUD)

Get is read, fetch smthg

Post is create 

Put is update, maintenance 

Delete is delete

*/

/* MVC
  M - Model //mySQL
  V - View(front-end) React
  C - Mediator between M and V 
 */

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Role;
import com.bank.model.User;
import com.bank.model.UserRole;
//import com.bank.repository.RoleRepo;
import com.bank.repository.UserRepo;
//import com.bank.request.LoginForm;
import com.bank.request.SignUpForm;
//import com.bank.response.JwtResponse;
import com.bank.response.Response;
import com.bank.util.JwtUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepo userRepo;

//	@Autowired
//	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private JwtUtil jwtUtil;

//	@PostMapping("/login")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
//
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String jwt = jwtUtil.generateToken(authentication);
//		return ResponseEntity.ok(new JwtResponse(jwt));
//	}

//	@PostMapping("/register")
//	public ResponseEntity<Response> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
//		Response response = new Response();
//		if (userRepo.existsByUsername(signUpRequest.getUsername())) {
//			response.setMessage("Username is already taken!");
//			response.setSuccess(false);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		}
//
//		if (userRepo.existsByEmail(signUpRequest.getEmail())) {
//			response.setMessage("Email is already in use");
//			response.setSuccess(false);
//			return new ResponseEntity<>(response, HttpStatus.OK);
//		}
//
//		// Creating user's account
//		User user = new User(signUpRequest.getFirsName(), signUpRequest.getLastName(), signUpRequest.getUsername(),
//				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
//
//		Set<UserRole> userRoles = new HashSet<>();
//		Set<String> strRoles = signUpRequest.getRole();
//		strRoles.forEach(roleName -> {
//			Role role = roleRepo.findByName(roleName).orElseThrow(() -> new RuntimeException("User Role not found."));
//			userRoles.add(new UserRole(user, role));
//		});
//		user.setUserRoles(userRoles);
//		userRepo.save(user);
//		response.setMessage("User Registered Successfully!");
//		response.setSuccess(true);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
}