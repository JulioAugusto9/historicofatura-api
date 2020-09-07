package com.historicofatura.domain.model;

import java.math.BigDecimal;

public class Lancamento implements Comparable<Lancamento>{
	private Long id;
	private BigDecimal valor;
	private String origem;
	private Long categoria;
	private int mes_lancamento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public int getMes_lancamento() {
		return mes_lancamento;
	}
	public void setMes_lancamento(int mes_lancamento) {
		this.mes_lancamento = mes_lancamento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Lancamento l) {
		return this.id.compareTo(l.getId());
	}
	
}
