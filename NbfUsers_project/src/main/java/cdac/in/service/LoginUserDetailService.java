package cdac.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cdac.in.module.Users;
import cdac.in.repo.LoginUsers;
import cdac.in.repo.UsersRep;

public class LoginUserDetailService implements UserDetailsService {
	
	@Autowired
	UsersRep res;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<Users> user=	res.findById(username);
	 Users u=user.orElseThrow(()->new UsernameNotFoundException("user not found"));
		// TODO Auto-generated method stub
		return new LoginUsers(u);
	}

}
