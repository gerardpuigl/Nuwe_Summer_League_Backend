package nuwe.infraestructure.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Override
    public void configure(HttpSecurity http) throws Exception {
            http.cors().and().csrf()
			.disable()
            .authorizeRequests()
            .antMatchers("**")
            .access("hasIpAddress('127.0.0.1') or hasIpAddress('::1') or isAuthenticated()")  // 127.0.0.1 and localhost do not need to authenticate on any url
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll();
    }


	
}
