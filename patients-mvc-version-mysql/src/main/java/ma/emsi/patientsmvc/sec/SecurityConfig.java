package ma.emsi.patientsmvc.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder=passwordEncoder();
        String encodedPWD=passwordEncoder.encode("1234");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication().withUser("user1").password(encodedPWD).roles("user");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("user");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("user","admin");
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
