package com.gomavs.rental.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gomavs.rental.models.LoginForm;
import com.gomavs.rental.models.Users;
import com.gomavs.rental.repositories.UsersRepo;



@Controller
public class Login implements WebMvcConfigurer {
	@Autowired
	private UsersRepo usersRepo;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/userhome").setViewName("userHome");
        registry.addViewController("/adminhome").setViewName("adminHome");
        registry.addViewController("/rentalmanagerhome").setViewName("rentalManagerHome");
    }

    @GetMapping("/")
    public String showForm(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
    	model.addAttribute("valid", false);
        return "index";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
        	model.addAttribute("valid", false);
            return "index";
        }
        
        Optional<Users> userD = usersRepo.findById(loginForm.getUsername());
        
        if (userD.isPresent()) {
        	if (userD.get().getPassword().equals(loginForm.getPassword())) {
        		if(userD.get().getRole().equals("Admin")){
        			return "redirect:/adminhome";
        		}
        		if(userD.get().getRole().equals("Rental Manager")){
        			return "redirect:/rentalmanagerhome";
        		}
        		return "redirect:/userhome";
        	}
        }
        model.addAttribute("valid", true);
        System.out.println("Username or Password incorrect.");
        return "index";
    }
}