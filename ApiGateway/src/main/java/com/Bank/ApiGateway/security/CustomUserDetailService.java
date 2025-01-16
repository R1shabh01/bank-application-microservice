package com.Bank.ApiGateway.security;


import com.Bank.ApiGateway.entity.User;
import com.Bank.ApiGateway.entity.UserPrincipal;
import com.Bank.ApiGateway.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService{

	private final UserRepository userRepository;

	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
		return new UserPrincipal(user);
	}

}
