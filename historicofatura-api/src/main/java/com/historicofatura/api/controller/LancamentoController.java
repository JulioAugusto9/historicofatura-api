package com.historicofatura.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.historicofatura.domain.model.Lancamento;
import com.historicofatura.domain.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping
	public List<Lancamento> listar(@RequestParam Optional<Long> categoria) {
		if (categoria.isEmpty()) {
			return lancamentoService.listar();
		}
		else {
			return lancamentoService.listarPorCategoria(categoria.get());
		}
	}
	
	@GetMapping("/{lancamentoId}")
	public ResponseEntity<Lancamento> buscar(@PathVariable Long lancamentoId) {
		Optional<Lancamento> lancamento = lancamentoService.buscar(lancamentoId);
		
		if (lancamento.isPresent()) {
			return ResponseEntity.ok(lancamento.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
