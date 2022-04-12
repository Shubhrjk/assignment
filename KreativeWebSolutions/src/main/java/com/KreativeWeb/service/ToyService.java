package com.KreativeWeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KreativeWeb.entity.Toy;
import com.KreativeWeb.repository.ToyRepostiroy;

@Service
public class ToyService {

	@Autowired
	private ToyRepostiroy toyRepostiroy;
	
	
	public Toy saveToy(Toy toy) {
		return toyRepostiroy.save(toy);
	}
	
	public List<Toy> saveToys(List<Toy> toys) {
		return toyRepostiroy.saveAll(toys);
	}
	
	public List<Toy> getToys(){
		return toyRepostiroy.findAll();
	}
	
	public Toy getToyById(int id) {
		return toyRepostiroy.findById(id).orElse(null);
	}
	
	public String deleteToy(int id) {
		return "Toy deleted!"+id;
	}
	
	public Toy updateToy(Toy toy) {
		Toy existingToy = toyRepostiroy.findById(toy.getId()).orElse(null);
		existingToy.setName(toy.getName());
		existingToy.setPrice(toy.getPrice());
		existingToy.setQuantity(toy.getQuantity());
		return toyRepostiroy.save(existingToy);
	}
}
