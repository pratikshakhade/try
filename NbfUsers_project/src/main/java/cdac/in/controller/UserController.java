package cdac.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cdac.in.module.Users;
import cdac.in.service.UserSer;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserSer ser;
	
	@GetMapping("/")
	public ResponseEntity<Users> getM(@RequestParam(value = "id") int id) {
		
		Users u =ser.getuser(id);
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Users> saveuser(@Valid @RequestBody Users user) {
	System.out.println("controller start");
       Users u=	ser.saveuser(user);
       System.out.println("controller end");
		return new ResponseEntity<Users>(u, HttpStatus.OK);
		
	}

}
