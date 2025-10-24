package com.spc.pro_v9.controller;

import com.spc.pro_v9.entity.User;
import com.spc.pro_v9.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("user", new User());
        System.out.println("Loaded index.html page--------------");
        return "index";
    }

//    @PostMapping("/addUser")
//    public String addUser(@ModelAttribute User user){
//        userService.addUser(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/users")
//    public String viewUsers(Model model){
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }

//    @GetMapping("/")
//    public String showLoginPage() {
//        return "index"; // index.html
//    }

    // Handle form submission
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        System.out.println("Handle the submit values through POST------------");
        boolean isValid = userService.validateUser(username, password);

        if (isValid) {
            System.out.println("Values Passed -----------");
            return "users";
        } else {

            System.out.println("Values not Passed --- Errorrrrrrr-----------");
            return "index";
        }

    }

}
