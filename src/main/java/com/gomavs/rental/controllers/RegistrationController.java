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

import com.gomavs.rental.models.Users;
import com.gomavs.rental.repositories.UsersRepo;



@Controller
public class RegistrationController implements WebMvcConfigurer {
	@Autowired
	private UsersRepo usersRepo;
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @GetMapping("/registration")
    public String showForm(@ModelAttribute("registrationForm") Users registrationForm, Model model) {
    	model.addAttribute("alreadyExist", false);
    	model.addAttribute("error", false);
    	model.addAttribute("success", false);
        return "registration";
    }

    @PostMapping("/registration")
    public String checkPersonInfo(@Valid @ModelAttribute("registrationForm") Users registrationForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
        	model.addAttribute("alreadyExist", false);
        	model.addAttribute("error", false);
        	model.addAttribute("success", false);
            return "registration";
        }
        
        Optional<Users> userD = usersRepo.findById(registrationForm.getUsername());
        
        if (userD.isPresent()) {
        	model.addAttribute("alreadyExist", true);
        	model.addAttribute("error", false);
        	model.addAttribute("success", false);
            return "registration";
        }else{
        	try{
        		usersRepo.save(registrationForm);
        		model.addAttribute("alreadyExist", false);
        		model.addAttribute("error", false);
            	model.addAttribute("success", true);
            	return "/registration";
        	}catch(Exception ex){
        		model.addAttribute("alreadyExist", false);
        		model.addAttribute("error", false);
            	model.addAttribute("success", true);
            	return "/registration";
        	}
        }
    }
}