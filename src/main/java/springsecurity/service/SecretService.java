package springsecurity.service;

import org.springframework.stereotype.Service;
import springsecurity.config.AdminOnly;

@Service
public class SecretService {


    @AdminOnly
public void foo(){
    System.err.printf("dangerous function");
}
}
