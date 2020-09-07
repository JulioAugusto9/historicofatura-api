package com.historicofatura.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.historicofatura.domain.model.Categoria;
import com.historicofatura.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}
	
	@GetMapping("/{categoriaId}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaId) {
		Optional<Categoria> categoria = categoriaService.buscar(categoriaId);
		
		if (categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
