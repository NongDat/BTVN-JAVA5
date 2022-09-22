package com.poly.lesson2_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class homeController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("/login")
    public String showLogin(Model model)
    {
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("home")
    public  String submit(Model model, @ModelAttribute("user") User user)
    {
        String username = user.getUsername();
        String pass = user.getPass();
        model.addAttribute("username",username);
        if(!checked(username, pass, model)) {
                model.addAttribute("mes", "swal(\"Good Chóp!\", \"Login success!\", \"success\")");
            model.addAttribute("message", "Đăng Nhập Thành Công!");
                return "home";
        }
        return "login";
    }
    public boolean checked(String username, String pass, Model model) {
        if(username.isBlank() || pass.isBlank()) {
            if(pass.isBlank()) {
                model.addAttribute("usernameCK", "Không để trống username");
            }

            if(pass.isBlank()) {
                model.addAttribute("passCK", "Không để trống pass");
            }
            return true;
        }
        if(!username.equals("admin") || !pass.equals("123")){
            model.addAttribute("err", "Sai Pass hoặc username!");
            return true;
        }
        return  false;
    }

}
