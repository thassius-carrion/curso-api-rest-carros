package com.tlove.carros.domain;

import java.util.ArrayList;
import java.util.List;

public class CarroService {

	public List<Carro> getCarros() {
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro(1L, "Fusca"));
		carros.add(new Carro(2L, "Brasilia"));
		return carros;
	}
	
}
