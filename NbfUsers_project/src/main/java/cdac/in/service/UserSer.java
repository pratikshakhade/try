package cdac.in.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cdac.in.module.Users;
import cdac.in.repo.UsersRep;

@Service
public class UserSer {
	
	@Autowired
	UsersRep rep;
	
	public Users saveuser(Users user) {		
		Users u=new Users();
		System.out.println("service method is call");
		u.setUserRole(user.getUserRole());
		return rep.save(user);
	}
	
	
	public Users getuser(int id) {		
		return rep.findById(id).orElseThrow(()-> new cdac.in.exception.ExceptionClass("you have to firs register"));
	}
	

}
