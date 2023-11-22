package springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebContoller {



    @GetMapping("/")
    public String index(){
        return "redirect:/public";
    }
    @GetMapping("/public")
    public String indexPublic(){
        return "public";
    }
    @GetMapping("/private")
    public String indexPrivate(){
        return "private";
    }
    @GetMapping("/secret")
    public String indexSecret(){
        return "secret";
    }



}
