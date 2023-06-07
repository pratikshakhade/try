package cdac.in.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cdac.in.module.Meanu;
import cdac.in.module.RegistartionParlour;
import cdac.in.repositry.RegistrationParlourRep;

@Service
public class RregistraionParlour {

	@Autowired
	RegistrationParlourRep rep;
	
	public RegistartionParlour save(RegistartionParlour registartion) {	
		System.out.println(registartion.getMenu());
	//	ArrayList<Meanu>
		RegistartionParlour reg=new RegistartionParlour();
	registartion.setMenu(registartion.getMenu());
	reg.setAddress(registartion.getAddress());
		return rep.save(registartion);
		
	}
}
