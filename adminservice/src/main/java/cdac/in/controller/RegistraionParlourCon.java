package cdac.in.controller;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cdac.in.module.RegistartionParlour;
import cdac.in.service.RregistraionParlour;

@RestController
public class RegistraionParlourCon {

	@Autowired
	RregistraionParlour ser;
	
	@PostMapping("/stored")
	public RegistartionParlour save(@RequestBody RegistartionParlour registartion) {
		
		return ser.save(registartion);
		
	}

}
