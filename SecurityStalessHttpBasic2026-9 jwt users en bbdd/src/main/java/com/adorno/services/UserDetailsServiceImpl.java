package com.adorno.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adorno.model.UserEntity;
import com.adorno.repositories.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	// en teoria aqui si se puede poner Autowired porque esta clase service es un componente
	// pero se aconseja que no se haga
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("usuario inexistente"));
		Set<SimpleGrantedAuthority> set=user.getRoles().stream()
				.map((rol)->new SimpleGrantedAuthority("ROLE_"+rol.getName().name()))
				.collect(Collectors.toSet());
		User user2 = new User(user.getUsername(), user.getPassword(), true, true, true, true, set);
		return user2;
	}

}
