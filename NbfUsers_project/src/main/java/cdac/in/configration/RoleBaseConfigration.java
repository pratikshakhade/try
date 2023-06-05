package cdac.in.configration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import cdac.in.module.Users;
import cdac.in.repo.UsersRep;
import cdac.in.service.LoginUserDetailService;
import cdac.in.service.UserSer;

@Configuration
@EnableWebSecurity
public class RoleBaseConfigration  {
	

	@Bean
	public UserDetailsManager userdetailService() {
		System.out.println("Added file ");
	//	return new LoginUserDetailService();
		return new JdbcUserDetailsManager(dataSource());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	
//
//	 @Bean
//	    public UserDetailsManager userDetailsManager() {
//		  System.out.println("Running &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//	        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource());
//	        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password , enabled from Users where username = 'pratiksha'");
//	        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select Users.username ,users.password, authorities.authority  from authorities inner join Users on Users.username = Authorities.username where Users.username ='pratiksha'");
//	        System.out.println(jdbcUserDetailsManager.toString());
//	        return jdbcUserDetailsManager;
//	    }
//	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails pratiksha = User.builder().username("pratiksha").password("{noop}pr@123").roles("appadmin").build();
//		return new InMemoryUserDetailsManager(pratiksha);	
//	}
	
//	  @Bean
//	    public UserDetailsService userDetailsManager(DataSource dataSource) {
//		  System.out.println("Running &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//	        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//	        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password , enabled from Users where username = 'pratiksha'");
//	        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select Users.username ,users.password, authorities.authority  from authorities inner join Users on Users.username = Authorities.username where Users.username ='pratiksha'");
//	        System.out.println(jdbcUserDetailsManager.toString());
//	        return jdbcUserDetailsManager;
//	    }
	
	
//	@Bean
//	UserDetailsManager users(DataSource dataSource) {
//		
//	System.out.println("added "+dataSource);
//		UserDetails user = User.builder()
//			.username("pk")
//			.password("{noop}pr@123")
//			.roles("appadmin")
//			.build();
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(user);
//		
//		System.out.println(user);
//		return users;
//	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "pratiksha");
		return dataSource;
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		configurer.requestMatchers(HttpMethod.POST,"/user").hasRole("appadmin")
		.requestMatchers(HttpMethod.GET,"/{name}").hasRole("user")
				);
		http.httpBasic();
		http.csrf().disable();
		return http.build();
	}
}
