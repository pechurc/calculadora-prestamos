package com.eiv.controllers.provincias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eiv.dtos.ModuloNavItem;
import com.eiv.dtos.ModuloNavLink;
import com.eiv.enums.RegionEnum;
import com.eiv.interfaces.IModuloNavItem;
import com.eiv.interfaces.IModuloNavLink;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("Provincias")
@RequestMapping(value = "/provincias")
public class IndexCtrl {
    
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
	
	@ModelAttribute("navItemActive")
	public String setNavItemActive() {
		return "provincias";
	}
	
	@ModelAttribute("regionEnum")
	private String getRegion() throws JsonProcessingException {
//		return List.of(RegionEnum.values());
		return mapper.writeValueAsString(RegionEnum.values());
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
