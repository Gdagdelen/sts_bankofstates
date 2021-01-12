package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.model.User;
import com.bank.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Take User Name from Login page and Validate through database
		// if User is valid then return UserDetails object
		// return UserDetails();
		// REPO / DAO	
		
		User user = userRepo.findByUsername(username).orElseThrow(() -> 
					new UsernameNotFoundException("User Not Found with  username  " + username));
	    return user;			
	}
	
	

}
