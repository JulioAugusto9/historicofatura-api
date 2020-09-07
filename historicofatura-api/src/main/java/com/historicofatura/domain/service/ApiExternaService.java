package com.historicofatura.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.historicofatura.domain.model.Categoria;
import com.historicofatura.domain.model.Lancamento;

@Service
public class ApiExternaService {
	
	@Value("${apiexterna}")
	private String apiURL;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Categoria> listarCategorias() {
		ResponseEntity<Categoria[]> response = restTemplate.getForEntity(apiURL + "/categorias", Categoria[].class);
		List<Categoria> categorias = Arrays.asList(response.getBody());
//		List<Categoria> categorias = new ArrayList<Categoria>();		
//		ResponseEntity<String> response = restTemplate.exchange(apiURL, HttpMethod.GET, null,  String.class);
//		System.out.println(response);
				
		return categorias;
	}
	
	public List<Lancamento> listarLancamentos() {
		ResponseEntity<Lancamento[]> response = restTemplate.getForEntity(apiURL + "/lancamentos", Lancamento[].class);
		List<Lancamento> lancamentos = Arrays.asList(response.getBody());
		
		return lancamentos;
	}
	
}
