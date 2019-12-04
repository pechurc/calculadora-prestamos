package com.eiv.controllers.provincias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eiv.dtos.IModuloNavItem;
import com.eiv.dtos.IModuloNavLink;
import com.eiv.dtos.ModuloNavItem;
import com.eiv.dtos.ModuloNavLink;

@Controller("Provincias")
@RequestMapping(value = "/provincias")
public class IndexCtrl {
    

	@ModelAttribute("navItemActive")
	public String setNavItemActive() {
		return "provincias";
	}

	@ModelAttribute("menu")
	private List<IModuloNavItem> getMenu() {
		IModuloNavItem entesPublicos = new ModuloNavItem("Provincias", "provincias");

		List<IModuloNavLink> entesLinks = new ArrayList<>();

		IModuloNavLink entesLista = new ModuloNavLink("Lista", "/provincias");
		entesLinks.add(entesLista);
		IModuloNavLink entesNuevo = new ModuloNavLink("Nuevo", "/provincias/nueva");
		entesLinks.add(entesNuevo);

		entesPublicos.setNavLinks(entesLinks); 

		List<IModuloNavItem> menu = new ArrayList<>();
		menu.add(entesPublicos);

		return menu;
	}
	
    @GetMapping(value = { "/", "" })
    public String index() {
       
        return "provincias/index";
    }
}
