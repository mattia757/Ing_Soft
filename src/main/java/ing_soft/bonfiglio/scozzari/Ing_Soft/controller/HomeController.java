package ing_soft.bonfiglio.scozzari.Ing_Soft.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "Home page with not authentication";
    }

    /*
    @GetMapping("/auth")
    public String auth(Authentication authentication){
        return "Hello page with authentication";
    }
    */

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Dashboard page";
    }


}