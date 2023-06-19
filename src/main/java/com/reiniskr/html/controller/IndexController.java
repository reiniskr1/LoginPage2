package com.reiniskr.html.controller;


import com.reiniskr.html.model.User;
import com.reiniskr.html.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userrepo;

    @GetMapping("/")
    public String index(){
       return "index";
    }

    @GetMapping("/Users")
    public List<User> getAllNotes(){
        List<User> debug = userrepo.findAll();
        User testUser = debug.get(0);
        System.out.println("First user: "+debug.get(0));
        return debug;
    }
//    @PostMapping("/Users")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User addUser(
//            @RequestBody User user){
//        return  userrepo.save(user);
//    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model){
        System.out.println(user.toString());
//        model.addAttribute("firstname", user.getFname());
//        model.addAttribute("lastname", user.getLname());

        User user_inserted = userrepo.save(user);
        model.addAttribute("message", user_inserted.getUsername() + " inserted");

//        return "index";
        return "welcome";
    }


}
