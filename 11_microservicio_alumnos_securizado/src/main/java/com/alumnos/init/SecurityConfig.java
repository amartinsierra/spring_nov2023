package com.alumnos.init;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	//método de configuración que establece fuente de usuarios
	@Bean
	public InMemoryUserDetailsManager usersdetais() throws Exception{
		List<UserDetails> users=List.of(
				User
				.withUsername("user1")
				//.password("$2a$12$YUq1fO2Vbz.ONbIo./xmBeGCYFr5m4OLNC8H9HFafn4fpcOnUbqda")
				.password("{noop}user1")
				.roles("USERS")
				.build(),
				User
				.withUsername("user2")
				.password("{noop}user2")
				.roles("OPERATOR")
				.build(),
				User
				.withUsername("admin")
				.password("{noop}admin")
				.roles("USERS","ADMIN")
				.build());		
		return new InMemoryUserDetailsManager(users);
	}
	/*@Bean //solo si se va a utilizar encriptación
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}*/
	/*@Bean //en caso de usuarios definidos en una base de datos
	public JdbcUserDetailsManager usersDetailsJdbc() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3307/springsecurity?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("root");
		JdbcUserDetailsManager jdbcDetails=new JdbcUserDetailsManager(ds);
		
		jdbcDetails.setUsersByUsernameQuery("select user, pwd, enabled"
           	+ " from users where user=?");
		jdbcDetails.setAuthoritiesByUsernameQuery("select user, rol "
           	+ "from roles where user=?");
		return jdbcDetails;
	}*/
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers("/h2-console/**").permitAll()
			.requestMatchers(HttpMethod.POST,"/alta").hasRole("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/eliminar").hasAnyRole("ADMIN","OPERATOR")
			.requestMatchers("/alumnos").authenticated()
			.requestMatchers("/cursos").authenticated()
			
			.anyRequest().permitAll()
			)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}*/
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector handlerMappingIntrospector) throws Exception {
        MvcRequestMatcher postMatcher = new MvcRequestMatcher(handlerMappingIntrospector, "/alta");
        MvcRequestMatcher deleteMatcher = new MvcRequestMatcher(handlerMappingIntrospector, "/eliminar");
        MvcRequestMatcher alumnosMatcher = new MvcRequestMatcher(handlerMappingIntrospector, "/alumnos");
        MvcRequestMatcher cursosMatcher = new MvcRequestMatcher(handlerMappingIntrospector, "/cursos");
        http.csrf(cus -> cus.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(postMatcher).hasRole("ADMIN")
            .requestMatchers(deleteMatcher).hasAnyRole("ADMIN", "OPERATOR")
            .requestMatchers(alumnosMatcher).authenticated()
            .requestMatchers(cursosMatcher).authenticated()
            .anyRequest().permitAll()
        )
        .httpBasic(Customizer.withDefaults());
    return http.build();

        
	}
	
	
}
