package cdac.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cdac.in.module.Users;
import cdac.in.service.UserSer;

@RestController
public class UserController {
	
	@Autowired
	UserSer ser;
	
	@GetMapping("/")
	public String getM() {
		return "done ..................";
		
	}
	
	@PostMapping("/user")
	public Users saveuser(@RequestBody Users user) {
		return ser.saveuser(user);
		
	}

}
