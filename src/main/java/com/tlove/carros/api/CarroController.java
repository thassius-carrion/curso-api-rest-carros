package com.tlove.carros.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlove.carros.domain.Carro;
import com.tlove.carros.domain.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public Iterable<Carro> getCarros() {
		return carroService.getCarros();
	}
	
	@GetMapping("/{id}")
	public Optional<Carro> getCarroById(@PathVariable("id") Long id) {
		return carroService.getCarroById(id);
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> getCarrosByTipo(@PathVariable("tipo") String tipo) {
		return carroService.getCarroByTipo(tipo);
	}
	
	@PostMapping
	public String post(@RequestBody Carro carro) {
		carroService.save(carro);
		return "Carro salvo com sucesso: " + carro.getId();
	}
	
	
}
