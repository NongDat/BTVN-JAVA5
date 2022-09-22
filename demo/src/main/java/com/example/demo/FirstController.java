package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("index")
    public String index(@RequestParam(name = "username", defaultValue = "No Name") String username,
                        @RequestParam(name = "num") Integer num,
                        Model model )
    {
                model.addAttribute("info", username);
        System.out.println(username);

        return "index";
    }
}
