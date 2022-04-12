package com.KreativeWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KreativeWeb.entity.Toy;
import com.KreativeWeb.service.ToyService;

@RestController
public class ToyController {

	@Autowired
	private ToyService toyService;
	
	@PostMapping("/addToy")
	public Toy addToy(@RequestBody Toy toy) {
		return toyService.saveToy(toy);
		
	}
	
	@PostMapping("/addToys")
	public List<Toy> addToys(@RequestBody List<Toy> toys){
		return toyService.saveToys(toys);
	}
	
	@GetMapping("/toys")
	public List<Toy> findAllToys(){
		return toyService.getToys();
	}
	
	@GetMapping("/toy/{id}")
	public Toy findToyById(@PathVariable int id) {
		return toyService.getToyById(id);
	}
	
    @PutMapping("/update")
	public Toy updateToy(@RequestBody Toy toy) {
		return toyService.updateToy(toy);
	}
	
    @DeleteMapping("/delete/{id}")
	public String deleteToy(@PathVariable int id) {
    	return toyService.deleteToy(id);
    }
}
