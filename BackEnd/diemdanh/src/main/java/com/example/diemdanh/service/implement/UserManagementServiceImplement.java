package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.diemdanh.config.JWTUtils;
import com.example.diemdanh.dto.TokenResponse;
import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.entity.RefreshToken;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.entity.Teacher;
import com.example.diemdanh.entity.User;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.global.constant.GlobalConstant;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.repository.TeacherRepository;
import com.example.diemdanh.repository.UserRepository;
import com.example.diemdanh.service.RefreshTokenService;
import com.example.diemdanh.service.UserManagementService;

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
    @Autowired
    private RefreshTokenService refreshTokenService;

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

		if (studentResult == null || studentResult.getId() == null) {
			throw new IllegalStateException("Failed to save student");
		}

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

		if (teacherResult == null || teacherResult.getId() == null) {
			throw new IllegalStateException("Failed to save student");
		}

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
	public TokenResponse login(UserDTO loginRequest) {
		UserDTO userDTORes = new UserDTO();

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getStrUsername(),
					loginRequest.getStrPassword()));
		var user = userRepository.findByUsername(loginRequest.getStrUsername())
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		String jwt = jwtUtils.generateToken(user);
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);
		userDTORes.setIntStatusCode(200);
		userDTORes.setStrToken(jwt);
		userDTORes.setStrExpirationTime("24Hrs");
		userDTORes.setStrRole(user.getRole());
		userDTORes.setStrMsg("Successfully Logged In");

		return new TokenResponse(jwt, refreshToken.getToken());
	}
	
    @Override
    public TokenResponse refreshToken(String refreshTokenStr) {
        RefreshToken refreshToken = refreshTokenService.findByToken(refreshTokenStr)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (refreshTokenService.isTokenExpired(refreshToken)) {
            refreshTokenService.deleteByUser(refreshToken.getUser());
            throw new RuntimeException("Refresh token expired");
        }

        String newAccessToken = jwtUtils.generateToken(refreshToken.getUser());

        return new TokenResponse(newAccessToken, refreshToken.getToken());
    }

	// * Get all users
	// Input:
	// Output: UserDTO lstUsers
	// Giang Ngo Truong 20/02/2025
	@Transactional(readOnly = true)
	@Override
	public UserDTO getAllUsers() {
		List<User> lstUser = userRepository.findAll();

		return Optional.ofNullable(lstUser).filter(list -> !list.isEmpty()).map(list -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setLstUser(lstUser);
			userDTO.setIntStatusCode(200);
			userDTO.setStrMsg("Success");
			userDTO.setIsFound(true);
			return userDTO;
		}).orElseGet(() -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setIntStatusCode(404);
			userDTO.setStrMsg("No users found");
			userDTO.setIsFound(false);
			return userDTO;
		});
	}

	// * Get user by ID
	// Input: Long id
	// Output: UserDTO userDTO
	// Giang Ngo Truong 01/04/2025
	@Transactional(readOnly = true)
	@Override
	public UserDTO getUserById(Long id) {
		return userRepository.findById(id).map(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setUser(user);
			userDTO.setStrMsg("User found");
			userDTO.setIntStatusCode(200);
			userDTO.setIsFound(true);
			return userDTO;
		}).orElseGet(() -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setIntStatusCode(404);
			userDTO.setStrMsg("User cannot be found");
			userDTO.setIsFound(false);
			return userDTO;
		});
	}

	// * deleteUser
	// Input: Long id
	// Output: UserDTO userDeleted
	// Giang Ngo Truong 02/04/2025
	@Override
	public UserDTO deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " not found"));
        
        userRepository.delete(user);
        
		UserDTO userDTO = new UserDTO();
		userDTO.setUser(user);
		userDTO.setIntStatusCode(200);
		userDTO.setStrMsg("User delete successfully");
		return userDTO;
	}

	// * updateUser
	// Input: Long id, UserDTO userReq
	// Output: UserDTO userUpdated
	// Giang Ngo Truong 02/04/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public UserDTO updateUser(Long id, UserDTO userReq) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
		
		user.setUsername(userReq.getStrUsername());
		// Check if password is present in the request
		if (userReq.getStrPassword() != null && !userReq.getStrPassword().isEmpty()) {
			// Encode the password and update it
			user.setPassword(passwordEncoder.encode(userReq.getStrPassword()));
		}
		user.setCity(userReq.getStrCity());
		user.setContactAddress(userReq.getStrContactAddress());
		user.setDateOfBirth(userReq.getDateOfBirth());
		user.setEthnic(userReq.getStrEthnic());
		user.setFullName(userReq.getStrFullName());
		user.setGender(userReq.getStrGender());
		user.setIdentityNumber(userReq.getStrIdentityNumber());
		user.setNationality(userReq.getStrNationality());
		user.setPermanentAddress(userReq.getStrPernamentAddress());
		user.setPhoneNumber(userReq.getStrPhoneNumber());
		user.setReligion(userReq.getStrReligion());
		user.setRole(userReq.getStrRole());
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUser(user);
		userDTO.setIntStatusCode(200);
		userDTO.setStrMsg("User updated successfully");
		return userDTO;
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