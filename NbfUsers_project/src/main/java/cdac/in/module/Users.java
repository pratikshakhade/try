package cdac.in.module;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String name;
String password;
String email;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_role_id",referencedColumnName = "id")
UsersRole userRole;
	
}
