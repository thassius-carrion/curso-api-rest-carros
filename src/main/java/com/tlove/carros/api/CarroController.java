package com.tlove.carros.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlove.carros.domain.Carro;
import com.tlove.carros.domain.CarroService;
import com.tlove.carros.domain.dto.CarroDTO;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity getCarros() {
		return ResponseEntity.ok(carroService.getCarros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getCarroById(@PathVariable("id") Long id) {
		Optional<CarroDTO> carro = carroService.getCarroById(id);
		
		return carro
				.map(c -> ResponseEntity.ok(c))
				.orElse(ResponseEntity.notFound().build());
		
		/*return carro.isPresent() ?
				ResponseEntity.ok(carro) :
				ResponseEntity.notFound().build();
		*/
		
		
		/*if(carro.isPresent()) {
			return ResponseEntity.ok(carro);
		}
		else {
			return ResponseEntity.notFound().build();
		}*/
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
			List<CarroDTO> carros = carroService.getCarroByTipo(tipo);
			
			return carros.isEmpty() ?
					ResponseEntity.noContent().build() :
					ResponseEntity.ok(carros);
					
	}
	
	@PostMapping
	public String post(@RequestBody Carro carro) {
		carroService.save(carro);
		return "Carro salvo com sucesso: " + carro.getId();
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody CarroDTO carro) {
		carroService.update(id, carro); 
		return "Carro de Id " + id + " atualizado com sucesso!";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		carroService.delete(id);
		return "Carro deletado com sucesso. ";
	}
	
}
