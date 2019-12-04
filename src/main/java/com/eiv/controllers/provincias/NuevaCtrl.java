package com.eiv.controllers.provincias;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eiv.dtos.IModuloNavItem;
import com.eiv.dtos.IModuloNavLink;
import com.eiv.dtos.ModuloNavItem;
import com.eiv.dtos.ModuloNavLink;
import com.eiv.dtos.ProvinciaDto;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.enums.RegionEnum;
import com.eiv.exceptions.NotFoundServiceException;
import com.eiv.services.ProvinciaService;

@Controller("NuevaProvincias")
@RequestMapping(value = "/provincias")
public class NuevaCtrl {

	@Autowired
	private ProvinciaService provinciaService;

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

	@ModelAttribute("regionEnum")
	private List<RegionEnum> getRegion() {
		return List.of(RegionEnum.values());
	}

	@GetMapping(value = { "/nueva", "/{id}" })
	public ModelAndView showForm(@PathVariable(required = false) Long id, Model model) {

		if (id != null) {
			try {
				ProvinciaEntity provinciaEntity = provinciaService.getById(id);
				ProvinciaDto provinciaDto = new ProvinciaDto(provinciaEntity);
				model.addAttribute("id", provinciaEntity.getId());

				return new ModelAndView("provincias/provincia", "provincia", provinciaDto);
			} catch (NotFoundServiceException e) {
				return new ModelAndView("redirect:/provincias/nueva");
			}
		}

		return new ModelAndView("provincias/provincia", "provincia", new ProvinciaDto());
	}

	@PostMapping(value = { "/nueva" })
	public String guardar(@Valid @ModelAttribute("provincia") ProvinciaDto provincia, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "provincias/provincia";
		}

		try {
			ProvinciaEntity provinciaEntity = provinciaService.save(provincia);
			model.addAttribute("success", provinciaEntity != null);
		} catch (DataIntegrityViolationException e) {
			result.addError(new ObjectError("Nombre duplicado", "Ya existe una provincia el mismo nombre"));
		}

		return "provincias/provincia";
	}

	@PostMapping(value = { "/{id}" })
	public String modificar(@PathVariable(required = false) Long id,
			@Valid @ModelAttribute("provincia") ProvinciaDto provincia, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "provincias/provincia";
		}

		try {
			ProvinciaEntity provinciaEntity = provinciaService.update(id, provincia);
			model.addAttribute("success", provinciaEntity != null);
		} catch (DataIntegrityViolationException e) {
			result.addError(new ObjectError("Nombre duplicado", "Ya existe una provincia el mismo nombre"));
		}

		return "provincias/provincia";
	}
}
