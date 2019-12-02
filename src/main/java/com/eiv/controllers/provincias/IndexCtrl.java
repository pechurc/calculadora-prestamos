package com.eiv.controllers.provincias;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("Provincias")
@RequestMapping(value = "/provincias")
public class IndexCtrl {
    
    @GetMapping(value = { "/", "" })
    public String index() {
       
        return "provincias/index";
    }
}
