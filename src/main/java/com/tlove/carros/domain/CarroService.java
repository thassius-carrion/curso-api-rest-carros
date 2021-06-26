package com.tlove.carros.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public Iterable<Carro> getCarros() {
		return repository.findAll();
	}
	
	public Optional<Carro> getCarroById(Long id) {
		return repository.findById(id);
	}
	
	public Iterable<Carro> getCarroByTipo(String tipo) {
		return repository.findByTipo(tipo);
	}

	public void save(Carro carro) {
		repository.save(carro);		
	}


	public Carro update(Long id, Carro carro) {
		Assert.notNull(id, "id não encontrado");
		
		Optional<Carro> optional = getCarroById(id);
		
		if(optional.isPresent()) {
			Carro car = optional.get();
			car.setNome(carro.getNome());
			car.setTipo(carro.getTipo());
			repository.save(car);
			return car;
		}
		else {
			throw new RuntimeException("Não foi possivel atualizar");		
			}
		
	}

	public void delete(Long id) {	
		Optional<Carro> optional = getCarroById(id);
		if(optional.isPresent()) {
			repository.deleteById(id);
		}
		else {
			throw new RuntimeException("Não foi possivel deletar.");		
		}	
	}
		
}
