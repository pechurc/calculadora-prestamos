package com.eiv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexCtrl {
    
    @GetMapping(value = { "/", "/index" })
    public String index() {
       
        return "index";
    }
}
