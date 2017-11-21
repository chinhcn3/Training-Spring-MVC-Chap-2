package demo.web.controller;

import demo.web.model.User;
import demo.web.service.UserService;
import demo.web.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Enumeration;

/**
 * Created by ChinhVD on 11/21/17.
 */
@Controller
public class LoginController {
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/login")
    public String loginSubmit(Model model, @ModelAttribute("name") String name, @ModelAttribute("pass") String pass, RedirectAttributes redirect) {
        User mUser = userServiceImp.getUserByLogin(name, pass);
        if (mUser == null || mUser.getId() <= 0) {
            redirect.addFlashAttribute("success", "Login fail!");
            return "redirect:/login";
        }
        redirect.addFlashAttribute("success", "Login success!");
        return "redirect:/logged";
    }

    @GetMapping("/logged")
    public String logged() {
        return "logged";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
