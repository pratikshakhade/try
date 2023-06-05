package cdac.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;


import cdac.in.module.Users;
import cdac.in.repo.LoginUsers;
import cdac.in.repo.UsersRep;

@Service
public class UserSer {
	
	@Autowired
	UsersRep rep;
	

	
	@Autowired
	UserDetailsManager manager;
	
	public String saveuser(Users user) {		
//		Users u=new Users();
//		System.out.println("service method is call");
//		u.setUserRole(user.getUserRole());
//return rep.save(user);
		Users u=new Users();
//		System.out.println("service method is call");
		u.setUserRole(user.getUserRole());
		LoginUsers login=new LoginUsers(user);
		
		 manager.createUser(login);
		 return "stored";
	}
	
	
	public Users getuser(String name) {		
		return rep.findById(name).orElseThrow(()-> new cdac.in.exception.ExceptionClass("you have to firs register"));
	}
	

}
