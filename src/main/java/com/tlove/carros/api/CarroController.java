package com.tlove.carros.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlove.carros.domain.Carro;
import com.tlove.carros.domain.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

	CarroService carroService = new CarroService();
	
	@GetMapping
	public List<Carro> getCarros() {
		
		return carroService.getCarros();
		
	}
	
}
