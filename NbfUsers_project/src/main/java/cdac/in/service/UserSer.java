package cdac.in.service;

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
//		u.setName(user.getName());
//		u.setEmail(user.getEmail());
//		u.setPassword(user.getPassword());
		
		System.out.println("service method is call");
		u.setUserRole(user.getUserRole());
		
	
		return rep.save(user);
	}
	

}
