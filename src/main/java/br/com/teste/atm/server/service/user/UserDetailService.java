package br.com.teste.atm.server.service.user;

import br.com.teste.atm.server.model.user.User;
import br.com.teste.atm.server.model.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author murata
 * @project atm.server
 */
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		User user = repository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
