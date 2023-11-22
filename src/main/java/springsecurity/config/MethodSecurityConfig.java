package springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
//@EnableMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig {





}
