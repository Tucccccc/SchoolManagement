package com.example.diemdanh.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.diemdanh.repository.UserRepository;

@Service
public class UserDetailsSV implements UserDetailsService{
	@Autowired
	private UserRepository userRepos;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepos.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
}