package com.eiv.controllers.provincias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiv.entities.ProvinciaEntity;
import com.eiv.services.ProvinciaService;

@Controller("ProvinciasAPI")
@RequestMapping(value = "/api/provincias")
public class ApiCtrl {

	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping
	public @ResponseBody List<ProvinciaEntity> getProvincias() {

		return provinciaService.getAll();
	}
}
