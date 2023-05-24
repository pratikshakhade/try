package cdac.in.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import cdac.in.module.Users;

@Configuration
public class RoleBaseConfigration {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails pratiksha = User.builder().username("pratiksha").password("{noop}pr@123").roles("appadmin").build();
		return new InMemoryUserDetailsManager(pratiksha);	
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer->
		configurer.requestMatchers(HttpMethod.POST,"/user").hasRole("appadmin")
		.requestMatchers(HttpMethod.GET,"/").hasRole("appadmin")
				);
		http.httpBasic();
		http.csrf().disable();
		return http.build();
	}
}
