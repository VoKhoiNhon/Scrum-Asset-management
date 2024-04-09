package DACNPM.asset_management.controller;

import DACNPM.asset_management.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String showRegistrationForm(@SessionAttribute(name = "loggedInAccount", required = false) Account loggedInAccount, Model model) {
        if (loggedInAccount == null) {
            return "redirect:/login";
        }        model.addAttribute("account", new Account());
        return "authentication-register";
    }

}