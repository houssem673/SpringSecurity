package springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {


@Bean
public SecurityFilterChain config(HttpSecurity chainBuilder) throws Exception {
    chainBuilder.authorizeHttpRequests(
            configurer -> configurer
                    .requestMatchers("/secret").hasRole("ADMIN")
                    .requestMatchers("/", "/public", "/css/*").permitAll()
                    .anyRequest().authenticated()
    )
            .formLogin(Customizer.withDefaults())
            .oauth2Login(config ->
                    config.userInfoEndpoint(
                    info -> info.userService(new AppUserService())));
    return chainBuilder.build();
}
@Bean
    public UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(new User("Houssem","{noop}password", List.of()));
    return manager;
}

}
