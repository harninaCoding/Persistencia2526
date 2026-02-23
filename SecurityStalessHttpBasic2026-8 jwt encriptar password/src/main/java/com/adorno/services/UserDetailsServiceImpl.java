package com.adorno.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.adorno.repositories.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	// en teoria aqui si se puede poner Autowired porque esta clase service es un componente
	// pero se aconseja que no se haga
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("Dios").password(passwordEncoder.encode("1234")).roles("ADMIN").build();
		manager.createUser(userDetails);
		return manager.loadUserByUsername(username);
	}

}
