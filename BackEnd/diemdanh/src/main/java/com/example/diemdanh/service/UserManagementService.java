package com.example.diemdanh.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.diemdanh.dto.ReqResUser;
import com.example.diemdanh.entity.Role;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.repository.RoleRepository;
import com.example.diemdanh.repository.UserRepository;

@Service
public class UserManagementService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private JWTUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// * Register user
	public ReqResUser register(ReqResUser registrationRequest) {
		ReqResUser resp = new ReqResUser();

		try {
			User user = new User();
			// Get role with ID 1
			Optional<Role> opRoles = roleRepository.findById(1L);
			Set<Role> resultSet = opRoles.map(Stream::of).orElseGet(Stream::empty).collect(Collectors.toSet());
			user.setUsername(registrationRequest.getStrUsername());
//			user.setRole("ADMIN");
			user.setRoles(resultSet);
			user.setEnabled(true);
			user.setPassword(passwordEncoder.encode(registrationRequest.getStrPassword()));
			User userResult = userRepository.save(user);
			if (userResult.getId() > 0) {
				resp.setUser(userResult);
				resp.setStrMsg("User Saved Successfully");
				resp.setIntStatusCode(200);
			}
		} catch (Exception e) {
			resp.setIntStatusCode(500);
			resp.setStrError("An error occurred: " + e.getMessage());
		}

		return resp;
	}

	// * Login
	public ReqResUser login(ReqResUser loginRequest) {
		ReqResUser response = new ReqResUser();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getStrUsername(),
					loginRequest.getStrPassword()));
			Set<String> setRoles = new HashSet<>();
			var user = userRepository.findByUsername(loginRequest.getStrUsername()).orElseThrow();
			var jwt = jwtUtils.generateToken(user);
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
			if(user.getRoles().size() > 0) {
				user.getRoles().forEach(roleElement -> {
					setRoles.add(roleElement.getName().toString());
				});
			}
			response.setIntStatusCode(200);
			response.setStrToken(jwt);
			response.setStrRefreshToken(refreshToken);
			response.setStrExpirationTime("24Hrs");
			response.setStrRoles(setRoles);
			response.setStrMsg("Successfully Logged In");

		} catch (Exception e) {
			response.setIntStatusCode(500);
			response.setStrError("An error occurred: " + e.getMessage());
		}
		return response;
	}
	
	// * Refresh token
	public ReqResUser refreshToken(ReqResUser refreshTokenRequest) {
		ReqResUser response = new ReqResUser();
		try {
			String strUsername = jwtUtils.extractUsername(refreshTokenRequest.getStrToken());
			User user = userRepository.findByUsername(strUsername).orElseThrow();
			if(jwtUtils.isTokenValid(refreshTokenRequest.getStrToken(), user)) {
				String jwt = jwtUtils.generateToken(user);
				response.setIntStatusCode(200);
				response.setStrToken(jwt);
				response.setStrRefreshToken(refreshTokenRequest.getStrToken());
				response.setStrExpirationTime("24Hr");
				response.setStrMsg("Successfully Refreshed Token");
			}
			response.setIntStatusCode(200);
			return response;
		} catch(Exception e) {
			response.setIntStatusCode(500);
			response.setStrError("An error occurred: " + e.getMessage());
			return response;
		}
	}

	// * Get all users
	public ReqResUser getAllUsers() {
		ReqResUser reqResUser = new ReqResUser();

		try {
			List<User> result = userRepository.findAll();
			if (!result.isEmpty()) {
				reqResUser.setLstUser(result);
				reqResUser.setIntStatusCode(200);
				reqResUser.setStrMsg("Success");
			} else {
				reqResUser.setIntStatusCode(404);
				reqResUser.setStrMsg("No users found");
			}
			return reqResUser;
		} catch (Exception e) {
			reqResUser.setIntStatusCode(500);
			reqResUser.setStrError("An error occurred: " + e.getMessage());
			return reqResUser;
		}
	}
	
	// * Find an user by ID
	public ReqResUser getUserById(Long id) {
		ReqResUser reqResUser = new ReqResUser();
		try {
			User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
			reqResUser.setUser(user);
			reqResUser.setIntStatusCode(200);
			reqResUser.setStrMsg("User with ID: " + id.toString() + " found successfully");
			return reqResUser;
		} catch(Exception e) {
			reqResUser.setIntStatusCode(500);
			reqResUser.setStrError("And error occured: " + e.getMessage());
			return reqResUser;
		}
	}
	
	// * Delete an user
	public ReqResUser deleteUser(Long id) {
		ReqResUser reqResUser = new ReqResUser();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if(optUser.isPresent()) {
				userRepository.deleteById(id);
				reqResUser.setIntStatusCode(200);
				reqResUser.setStrMsg("User deleted successfully");
			} else {
				reqResUser.setIntStatusCode(404);
				reqResUser.setStrMsg("User not found");
			}
			return reqResUser;
		} catch(Exception e) {
			reqResUser.setIntStatusCode(500);
			reqResUser.setStrError("Deleting error occurred: " + e.getMessage());
			return reqResUser;
		}
	}
	
	// * Update an user
	public ReqResUser updateUser(Long id, User userUpdate) {
		ReqResUser reqResUser = new ReqResUser();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if(optUser.isPresent()) {
				User user = optUser.get();

				//  Update password
				if(userUpdate.getPassword() != null && !userUpdate.getPassword().isEmpty()) {
					user.setPassword(userUpdate.getPassword());
				}
				
				User userSave = userRepository.save(user);
				reqResUser.setIntStatusCode(200);
				reqResUser.setUser(userSave);
				reqResUser.setStrMsg("User updated successfully");
		
			} else {
				reqResUser.setIntStatusCode(400);
				reqResUser.setStrError("User not found");
			}
			return reqResUser;
		} catch(Exception e) {
			reqResUser.setIntStatusCode(500);
			reqResUser.setStrError("An error occurred: " + e.getMessage());
			return reqResUser;
		}
	}
	
	// * Get user's profile
	public ReqResUser getUserProfile(String strUsername) {
		ReqResUser reqResUser = new ReqResUser();
		try {
			Optional<User> optUser = userRepository.findByUsername(strUsername);
			if(optUser.isPresent()) {
				reqResUser.setUser(optUser.get());
				reqResUser.setIntStatusCode(200);
				reqResUser.setStrMsg("Get user's profile successfully");
			} else {
				reqResUser.setIntStatusCode(404);
				reqResUser.setStrError("User not found");
			}
			return reqResUser;
		} catch(Exception e) {
			reqResUser.setIntStatusCode(500);
			reqResUser.setStrError("An error occurred: " + e.getMessage());
			return reqResUser;
		}
	}
}