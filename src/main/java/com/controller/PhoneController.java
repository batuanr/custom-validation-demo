package com.controller;

import com.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/login")
    public String showForm(Model model){
        model.addAttribute("phone", new PhoneNumber());
        return "/login";
    }
    @PostMapping("/login")
    public String checkValidation (@Valid @ModelAttribute("phone")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/login";
        }
        else {
            model.addAttribute("phone", phoneNumber);
            return "/home";
        }
    }
}