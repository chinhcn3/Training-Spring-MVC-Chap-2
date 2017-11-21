package demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChinhVD on 11/1/17.
 */
@Controller
public class LoginController {

    @RequestMapping("/home")
    public String welcome() {
        return "login";
    }
}
