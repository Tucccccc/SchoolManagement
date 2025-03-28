package com.example.diemdanh.service.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.entity.Teacher;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.global.constant.GlobalConstant;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.repository.TeacherRepository;
import com.example.diemdanh.repository.UserRepository;
import com.example.diemdanh.service.JWTUtils;
import com.example.diemdanh.service.UserManagementService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserManagementServiceImplement implements UserManagementService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private JWTUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private CommonMethods common = new CommonMethods();

	// * Register student
	// Input: UserDTO registrationRequest
	// Output: UserDTO userStudent
	// Giang Ngo Truong 20/02/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public UserDTO registerStudent(UserDTO registrationRequest) {
		// Create JSON response
		UserDTO resp = new UserDTO();
		// Create user
		User user = common.createUser(registrationRequest, GlobalConstant.STR_STUDENT_ROLE,
				passwordEncoder.encode(registrationRequest.getStrPassword()));

		// Save user
		User userResult = userRepository.save(user);

		// Create student
		Student student = common.createStudent(userResult, registrationRequest);

		// Save student
		Student studentResult = studentRepository.save(student);

		// Set response JSON
		resp.setUser(userResult);
		resp.setStudent(studentResult);
		resp.setStrMsg("Student Saved Successfully");
		resp.setIntStatusCode(200);

		return resp;
	}

	// * Register student
	// Input: UserDTO registrationRequest
	// Output: UserDTO userStudent
	// Giang Ngo Truong 20/02/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public UserDTO registerTeacher(UserDTO registrationRequest) {
		UserDTO resp = new UserDTO();

		// Create user
		User user = common.createUser(registrationRequest, GlobalConstant.STR_TEACHER_ROLE,
				passwordEncoder.encode(registrationRequest.getStrPassword()));

		// Save user
		User userResult = userRepository.save(user);

		// Create teacher
		Teacher teacher = common.createTeacher(userResult, registrationRequest);

		// Save teacher
		Teacher teacherResult = teacherRepository.save(teacher);

		resp.setUser(userResult);
		resp.setTeacher(teacherResult);
		resp.setStrMsg("Teacher Saved Successfully");
		resp.setIntStatusCode(200);

		return resp;
	}

	// * Login
	// Input: ReqResUser loginRequest
	// Output: ReqResUser response
	// Giang Ngo Truong 20/02/2025
	@Override
	public UserDTO login(UserDTO loginRequest) {
		UserDTO response = new UserDTO();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getStrUsername(),
					loginRequest.getStrPassword()));
			var user = userRepository.findByUsername(loginRequest.getStrUsername()).orElseThrow();
			var jwt = jwtUtils.generateToken(user);
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
			response.setIntStatusCode(200);
			response.setStrToken(jwt);
			response.setStrRefreshToken(refreshToken);
			response.setStrExpirationTime("24Hrs");
			response.setStrRole(user.getRole());
			response.setStrMsg("Successfully Logged In");

		} catch (Exception e) {
			response.setIntStatusCode(500);
			response.setStrError("An error occurred: " + e.getMessage());
		}
		return response;
	}

	// * Refresh token
	@Override
	public UserDTO refreshToken(UserDTO refreshTokenRequest) {
		UserDTO response = new UserDTO();
		try {
			String strUsername = jwtUtils.extractUsername(refreshTokenRequest.getStrToken());
			User user = userRepository.findByUsername(strUsername).orElseThrow();
			if (jwtUtils.isTokenValid(refreshTokenRequest.getStrToken(), user)) {
				String jwt = jwtUtils.generateToken(user);
				response.setIntStatusCode(200);
				response.setStrToken(jwt);
				response.setStrRefreshToken(refreshTokenRequest.getStrToken());
				response.setStrExpirationTime("24Hr");
				response.setStrMsg("Successfully Refreshed Token");
			}
			response.setIntStatusCode(200);
			return response;
		} catch (Exception e) {
			response.setIntStatusCode(500);
			response.setStrError("An error occurred: " + e.getMessage());
			return response;
		}
	}

	// * Get all users
	@Override
	public UserDTO getAllUsers() {
		UserDTO userDTO = new UserDTO();

		try {
			List<User> result = userRepository.findAll();
			if (!result.isEmpty()) {
				userDTO.setLstUser(result);
				userDTO.setIntStatusCode(200);
				userDTO.setStrMsg("Success");
			} else {
				userDTO.setIntStatusCode(404);
				userDTO.setStrMsg("No users found");
			}
			return userDTO;
		} catch (Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("An error occurred: " + e.getMessage());
			return userDTO;
		}
	}

	// * Find an user by ID
	@Override
	public UserDTO getUserById(Long id) {
		UserDTO userDTO = new UserDTO();
		try {
			User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
			userDTO.setUser(user);
			userDTO.setIntStatusCode(200);
			userDTO.setStrMsg("User with ID: " + id.toString() + " found successfully");
			return userDTO;
		} catch (Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("And error occured: " + e.getMessage());
			return userDTO;
		}
	}

	// * Delete an user
	@Override
	public UserDTO deleteUser(Long id) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if (optUser.isPresent()) {
				userRepository.deleteById(id);
				userDTO.setIntStatusCode(200);
				userDTO.setStrMsg("User deleted successfully");
			} else {
				userDTO.setIntStatusCode(404);
				userDTO.setStrMsg("User not found");
			}
			return userDTO;
		} catch (Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("Deleting error occurred: " + e.getMessage());
			return userDTO;
		}
	}

	// * Update an user
	@Override
	public UserDTO updateUser(Long id, User userUpdate) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if (optUser.isPresent()) {
				User user = optUser.get();
				user.setUsername(userUpdate.getUsername());
				user.setCity(userUpdate.getCity());

				// Check if password is present in the request
				if (userUpdate.getPassword() != null && !userUpdate.getPassword().isEmpty()) {
					// Encode the password and update it
					user.setPassword(passwordEncoder.encode(userUpdate.getPassword()));
				}

				User userSave = userRepository.save(user);
				userDTO.setIntStatusCode(200);
				userDTO.setUser(userSave);
				userDTO.setStrMsg("User updated successfully");

			} else {
				userDTO.setIntStatusCode(400);
				userDTO.setStrError("User not found");
			}
			return userDTO;
		} catch (Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("An error occurred: " + e.getMessage());
			return userDTO;
		}
	}

	// * Get user's profile
	@Override
	public UserDTO getUserProfile(String strUsername) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findByUsername(strUsername);
			if (optUser.isPresent()) {
				userDTO.setUser(optUser.get());
				userDTO.setIntStatusCode(200);
				userDTO.setStrMsg("Get user's profile successfully");
			} else {
				userDTO.setIntStatusCode(404);
				userDTO.setStrError("User not found");
			}
			return userDTO;
		} catch (Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("An error occurred: " + e.getMessage());
			return userDTO;
		}
	}
}