package com.tlove.carros.domain.dto;

import com.tlove.carros.domain.Carro;

import lombok.Data;

@Data
public class CarroDTO {
	
	private Long id;
	private String nome;
	private String tipo;
	
	public CarroDTO(Carro carro) {
		this.id = carro.getId();
		this.nome = carro.getNome();
		this.tipo = carro.getTipo();
	}
}
