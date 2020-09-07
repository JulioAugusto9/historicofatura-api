package com.historicofatura.domain.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.historicofatura.domain.model.Lancamento;

@Service
public class LancamentoService {
	
	@Autowired
	private ApiExternaService api;
	
	public List<Lancamento> listar() {
		return api.listarLancamentos();
	}
	
	public Optional<Lancamento> buscar(Long id) {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(id);
		List<Lancamento> lancamentos = api.listarLancamentos();
		int index = Collections.binarySearch(lancamentos, lancamento);
		if (index >= 0) {
			return Optional.of(lancamentos.get(index));
		}
		else {
			return Optional.empty();
		}
	}
	
	public List<Lancamento> listarPorCategoria(Long categoriaId) {
		List<Lancamento> lancamentos = api.listarLancamentos();
		
		return lancamentos.stream()
				.filter(lancamento -> lancamento.getCategoria().equals(categoriaId))
				.collect(Collectors.toList()); 
	}
	
}
