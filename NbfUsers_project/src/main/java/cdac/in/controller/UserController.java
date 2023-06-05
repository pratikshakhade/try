package cdac.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{name}")
	public ResponseEntity<Users> getM(@PathVariable String name) {
		
		Users u =ser.getuser(name);
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> saveuser(@Valid @RequestBody Users user) {
	System.out.println("controller start");
       String u=	ser.saveuser(user);
       System.out.println("controller end");
		return new ResponseEntity<Object>(u, HttpStatus.OK);
		
	}

}
