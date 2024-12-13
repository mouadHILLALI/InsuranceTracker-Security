package insurancetracker.insurancetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("users/")
public class UserController {

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
