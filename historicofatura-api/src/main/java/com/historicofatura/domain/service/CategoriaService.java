package com.historicofatura.domain.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.historicofatura.domain.model.Categoria;

@Service
public class CategoriaService {
	
	@Autowired
	private ApiExternaService api;
	
	public List<Categoria> listar() {
		return api.listarCategorias();
	}
	
	public Optional<Categoria> buscar(Long id) {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		List<Categoria> categorias = api.listarCategorias();
		int index = Collections.binarySearch(categorias, categoria);
		if (index >= 0) {
			return Optional.of(categorias.get(index));
		}
		else {
			return Optional.empty();
		}
	}
}
