package com.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

@GetMapping("/login")
public ModelAndView getIndexView() {
    ModelAndView modelV = new ModelAndView("login");
    return modelV;

}
}
