package cdac.in.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String city;
	String district;
	String state;
	String contry;
	int pincode;
}
