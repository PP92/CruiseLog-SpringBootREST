package com.pp.CruiseLogSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pp.CruiseLogSpring.domain.Cruise;
import com.pp.CruiseLogSpring.services.CruiseService;

@RestController
public class CruiseController {

	private final CruiseService cruiseService;

	public CruiseController(CruiseService cruiseService) {
		this.cruiseService = cruiseService;
	}

	@GetMapping("/init")
	public List<Cruise> init() {
		cruiseService.initCruiseRepo();
		return cruiseService.getAllCruises();
	}

	@GetMapping("/cruises")
	public List<Cruise> listCruises() {
		return cruiseService.getAllCruises();
	}

	@GetMapping("/cruises/{id}")
	public Cruise showCruise(@PathVariable Long id) {
		return cruiseService.getCruise(id);
	}

	@PostMapping("/addCruise")
	public Cruise addCruise(@RequestBody Cruise cruise) {
		return cruiseService.saveCruise(cruise);
	}
	
	@PostMapping("/addRandomCruise")
	public Cruise addCruise() {
		return cruiseService.saveRandomCruise();
	}

	@PutMapping("/cruises/{id}")
	public Cruise updateCruiseById(@RequestBody Cruise cruise, @PathVariable Long id) {
		return cruiseService.updateCruiseById(cruise, id);
	}
	
	@DeleteMapping("/cruises/{id}")
	public void deleteCruiseById(@PathVariable Long id) {
		cruiseService.deleteCruiseById(id);
	}

}
