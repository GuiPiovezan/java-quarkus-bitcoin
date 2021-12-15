package br.com.shift.model;

import java.time.LocalDate;

public class Bitcoin {
	
	private long id;
	
	private Double preco;
	
	private String nome;
	
	private LocalDate data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
}
