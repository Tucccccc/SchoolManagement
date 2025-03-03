package com.example.diemdanh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.global.constant.GlobalConstant;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.repository.TeacherRepository;
import com.example.diemdanh.repository.UserRepository;

@Service
public class UserManagementService {
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
	
	// * Register student
	// Input: UserDTO registrationRequest
	// Output: UserDTO userStudent
	// Giang Ngo Truong 20/02/2025
    @Transactional
	public UserDTO registerStudent(UserDTO registrationRequest){
		// Create JSON response
		UserDTO resp = new UserDTO();
		try {
			// Create user
			User user = createUser(registrationRequest);
			
			// Save user
			User userResult = userRepository.save(user);
			
			if(userResult == null || userResult.getId() == null) {
				throw new IllegalStateException("User save fail");
			}
			
	        // Create student
			Student student = createStudent(userResult, registrationRequest);
			
			// Save student
			Student studentResult = studentRepository.save(student);
			
			if(studentResult == null || studentResult.getId() == null) {
				throw new IllegalStateException("Student save fail");
			}
			
			// Set response JSON
			resp.setUser(userResult);
			resp.setStudent(studentResult);
			resp.setStrMsg("Student Saved Successfully");
			resp.setIntStatusCode(200);
		}
		catch(DataIntegrityViolationException e) {
		    throw new DataIntegrityViolationException("Data Integrity Exception", e);
		}
		catch (Exception e) {
		    throw new RuntimeException("An Exception has occurred", e);
		}

		return resp;
	}
	
	// * Register student
	// Input: UserDTO registrationRequest
	// Output: UserDTO userStudent
	// Giang Ngo Truong 20/02/2025
	public UserDTO registerTeacher(UserDTO registrationRequest) {
		UserDTO resp = new UserDTO();

		try {
			User user = new User();

			user.setUsername(registrationRequest.getStrUsername());
			user.setRole(registrationRequest.getStrRole());
			user.setEnabled(true);
			user.setPassword(passwordEncoder.encode(registrationRequest.getStrPassword()));
			user.setCity(registrationRequest.getStrCity());
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
	// Input: ReqResUser loginRequest
	// Output: ReqResUser response
	// Giang Ngo Truong 20/02/2025
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
	public UserDTO refreshToken(UserDTO refreshTokenRequest) {
		UserDTO response = new UserDTO();
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
	public UserDTO getUserById(Long id) {
		UserDTO userDTO = new UserDTO();
		try {
			User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
			userDTO.setUser(user);
			userDTO.setIntStatusCode(200);
			userDTO.setStrMsg("User with ID: " + id.toString() + " found successfully");
			return userDTO;
		} catch(Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("And error occured: " + e.getMessage());
			return userDTO;
		}
	}
	
	// * Delete an user
	public UserDTO deleteUser(Long id) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if(optUser.isPresent()) {
				userRepository.deleteById(id);
				userDTO.setIntStatusCode(200);
				userDTO.setStrMsg("User deleted successfully");
			} else {
				userDTO.setIntStatusCode(404);
				userDTO.setStrMsg("User not found");
			}
			return userDTO;
		} catch(Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("Deleting error occurred: " + e.getMessage());
			return userDTO;
		}
	}
	
	// * Update an user
	public UserDTO updateUser(Long id, User userUpdate) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findById(id);
			if(optUser.isPresent()) {
				User user = optUser.get();
				user.setUsername(userUpdate.getUsername());
				user.setCity(userUpdate.getCity());

				 // Check if password is present in the request
				if(userUpdate.getPassword() != null && !userUpdate.getPassword().isEmpty()) {
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
		} catch(Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("An error occurred: " + e.getMessage());
			return userDTO;
		}
	}
	
	// * Get user's profile
	public UserDTO getUserProfile(String strUsername) {
		UserDTO userDTO = new UserDTO();
		try {
			Optional<User> optUser = userRepository.findByUsername(strUsername);
			if(optUser.isPresent()) {
				userDTO.setUser(optUser.get());
				userDTO.setIntStatusCode(200);
				userDTO.setStrMsg("Get user's profile successfully");
			} else {
				userDTO.setIntStatusCode(404);
				userDTO.setStrError("User not found");
			}
			return userDTO;
		} catch(Exception e) {
			userDTO.setIntStatusCode(500);
			userDTO.setStrError("An error occurred: " + e.getMessage());
			return userDTO;
		}
	}
	
	// * Create new user
	// Input: ReqResUser registrationRequest
	// Output: User user
	// Giang Ngo Truong 03/003/2025
	private User createUser(UserDTO registrationRequest) {
		User user = new User();
		user.setUsername(registrationRequest.getStrUsername());
		user.setIdentityNumber(registrationRequest.getStrIdentityNumber());
		user.setPassword(passwordEncoder.encode(registrationRequest.getStrPassword()));
		user.setGender(registrationRequest.getStrGender());
		user.setPhoneNumber(registrationRequest.getStrPhoneNumber());
		user.setEnabled(true);
		user.setFullName(registrationRequest.getStrFullName());
		user.setCity(registrationRequest.getStrCity());
		user.setFullName(registrationRequest.getStrPernamentAddress());
		user.setContactAddress(registrationRequest.getStrContactAddress());
		user.setEthnic(registrationRequest.getStrEthnic());
		user.setReligion(registrationRequest.getStrReligion());
		user.setNationality(registrationRequest.getStrNationality());
		user.setDateOfBirth(registrationRequest.getDateOfBirth());
		user.setRole(GlobalConstant.STR_STUDENT_ROLE);
		
		return user;
	}
	
	// * Create new student
	// Input: User userResult, UserDTO registrationRequest
	// Output: Student student
	// Giang Ngo Truong 03/03/2025
	private Student createStudent(User userResult, UserDTO registrationRequest) {
		Student student = new Student();
		student.setUser(userResult);
		student.setStudentCode("HS" + registrationRequest.getIntStudentYearOfAdmission() + userResult.getId());
		student.setMothersName(registrationRequest.getStrStudentMothersName());
		student.setMothersDateOfBirth(registrationRequest.getDateStudentFathersDateOfBirth());
		student.setMothersPhoneNumber(registrationRequest.getStrStudentMothersPhoneNumbers());
		student.setMothersProfession(registrationRequest.getStrStudentMothersProfession());
		student.setFathersName(registrationRequest.getStrStudentFathersName());
		student.setFathersDateOfBirth(registrationRequest.getDateStudentFathersDateOfBirth());
		student.setFathersPhoneNumber(registrationRequest.getStrStudentFathersPhoneNumber());
		student.setFathersProfession(registrationRequest.getStrStudentFathersProfession());
		student.setIntYearOfAdmission(registrationRequest.getIntStudentYearOfAdmission() != null ? registrationRequest.getIntStudentYearOfAdmission() : 0);
		
		return student;
	}
}