package com.eiv.controllers.provincias;

import java.net.BindException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiv.dtos.ProvinciaDto;
import com.eiv.entities.ProvinciaEntity;
import com.eiv.exceptions.NotFoundServiceException;
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
	
	@PostMapping
	public @ResponseBody ProvinciaEntity create(@Valid @RequestBody ProvinciaDto provincia, BindingResult result) 
			throws BindException {
		
		if (result.hasErrors()) {
			throw new BindException();
		}
		
		ProvinciaEntity provinciaEntity = provinciaService.save(provincia);
		return provinciaEntity;		
	}
	

	@PatchMapping(path = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ProvinciaDto provincia, BindingResult result,
			@PathVariable(name = "id", required = true) Long id) 
			throws BindException {
		
		if (result.hasErrors()) {
			throw new BindException();
		}

		try {
			provinciaService.update(id, provincia);
		} catch (NotFoundServiceException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id", required = true) Long id) {
		
		try {
			provinciaService.delete(id);
		} catch (NotFoundServiceException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}
