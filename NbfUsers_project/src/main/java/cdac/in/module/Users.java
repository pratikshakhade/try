package cdac.in.module;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Users  {
@Id
String username;
String password;
//@NotNull(message = "Email cant be null")
//String email;

boolean enabled=true;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "users_pkey",referencedColumnName = "username")
Authorities userRole;
	
}
