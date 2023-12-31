package springsecurity.web;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springsecurity.config.AdminOnly;
import springsecurity.service.SecretService;

@Controller
public class WebContoller {

private final SecretService secretService;

    public WebContoller(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/public";
    }
    @GetMapping("/public")
    public String indexPublic(){
        return "public";
    }
    @GetMapping("/private")
    public String indexPrivate(OAuth2AuthenticationToken oauth, Model model ){
       // System.out.println(oauth); //print login details
        OAuth2User user = oauth.getPrincipal();
        String loginName = user.getAttribute("login");
        model.addAttribute("name",loginName);
        return "private";
    }

    // @Secured("ROLE_USER") one way of securing the method
    @AdminOnly
    @GetMapping("/secret")
    public String indexSecret(){
        secretService.foo();
        return "secret";
    }



}
