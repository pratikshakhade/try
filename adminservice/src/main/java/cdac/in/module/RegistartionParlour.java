package cdac.in.module;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistartionParlour {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     int id;
	String firstName;
	String lastName;
	String shopname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_key",referencedColumnName = "id")
       List<Meanu> menu;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_key",referencedColumnName = "id")
	Address address;
	

}
