package com.poly.modelattribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    HttpServletRequest req;

    @GetMapping("user-form")
    public String formUser(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("show-user")
    public String showUser(Model model, @ModelAttribute("user") User user) {
        String yearOfBirth = req.getParameter("yearOfBirth");
        System.out.println(yearOfBirth);
        model.addAttribute("user", user);
        LocalDateTime localDate = LocalDateTime.now();
        int year = localDate.getYear();
        int age = year - user.getYearOfBirth();

        if (!validateUser(user, model, year)) {
            model.addAttribute("age", age);
            return "show-user";
        } else {
            return "user-form";
        }
    }

    public boolean validateUser(User user, Model model, int year) {
        String regexNumber = "\\d+";
        if (user.getUserName().isBlank() || user.getAddress().isBlank()) {
            if (user.getUserName().isBlank()) {
                model.addAttribute("usernameCK", "Không để trống họ tên!");
            }
            if (user.getAddress().isBlank()) {
                model.addAttribute("addressCK", "Không để trống địa chỉ!");
            }
            return true;
        }
        if (user.getYearOfBirth() > year) {
            model.addAttribute("yearCK", "tuổi không không lớn hơn năm hiện tại!");
            return true;
        }
        return false;
    }

    @GetMapping("product-form")
    public String formProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("show-product")
    public String showProduct(Model model, @ModelAttribute("product") Product product) {
        double tatols = product.getQuantity() * product.getPrice();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String date = sdf.format(new Date());


        model.addAttribute("product", product);

        if (!checkProduct(product, model)) {
            model.addAttribute("today", date);
            model.addAttribute("money", tatols);
            return "show-product";
        }
        return "product-form";
    }

    public boolean checkProduct(Product product, Model model) {
        if (product.getNameProduct().isBlank()) {
            model.addAttribute("nameProductCK", "Không để trống tên sản phẩm");
            return true;
        }
        return false;
    }

}