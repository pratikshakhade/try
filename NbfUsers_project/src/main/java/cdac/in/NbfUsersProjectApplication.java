package cdac.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
// added spring validation
//added role base 
//added exception handling
@SpringBootApplication
@EnableWebSecurity
@Validated
@EnableJpaRepositories(basePackages = "cdac.in")
public class NbfUsersProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbfUsersProjectApplication.class, args);
		System.out.println("helloo..................");
	}

}
