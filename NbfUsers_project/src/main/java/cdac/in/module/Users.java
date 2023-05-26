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
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
@NotNull(message = "name cant be null")
String name;
String password;
@NotNull(message = "Email cant be null")
String email;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "user_role_id",referencedColumnName = "id")
UsersRole userRole;
	
}
