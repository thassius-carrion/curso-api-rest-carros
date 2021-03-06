package com.tlove.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.tlove.carros.domain.dto.CarroDTO;

@Service
public class CarroService {

	@Autowired
	private CarroRepository repository;
	
	public List<CarroDTO> getCarros() {
		return repository.findAll().stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
	}
	
	public Optional<CarroDTO> getCarroById(Long id) {
		return repository.findById(id).map(c -> CarroDTO.create(c));
	}
	
	public List<CarroDTO> getCarroByTipo(String tipo) {
		return repository.findByTipo(tipo).stream().map(c -> CarroDTO.create(c)).collect(Collectors.toList());
	}

	public CarroDTO save(Carro carro) {
		return CarroDTO.create(repository.save(carro));		
	}


	public CarroDTO update(Long id, Carro carro) {
		Assert.notNull(id, "id não encontrado");
		
		Optional<Carro> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			Carro car = optional.get();
			car.setNome(carro.getNome());
			car.setTipo(carro.getTipo());
			repository.save(car);
			return CarroDTO.create(car);
		}
		else {
			return null;	
			}
		
	}

	public boolean delete(Long id) {	
		if(getCarroById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		else {
			return false;		
		}	
	}
		
}
