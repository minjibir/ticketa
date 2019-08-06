package ng.ticketa.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		String query = "select phone_number as principal, password as credentials, true from customer where phone_number = ?";
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(query)
				//				.authoritiesByUsernameQuery(query)
				.passwordEncoder(passwordEncoder());
	}

	private PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.antMatchers("/", "/about", "/contact", "/login", "/register", "/schedule", "/css/**", "/js/**", "/img/**", "/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/dashboard")
				.and()
				.logout()
				.logoutSuccessUrl("/login");

	}

}
