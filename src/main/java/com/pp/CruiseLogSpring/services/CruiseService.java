package com.pp.CruiseLogSpring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.pp.CruiseLogSpring.domain.Cruise;
import com.pp.CruiseLogSpring.repositories.CruiseRepository;

@Service
public class CruiseService {

	private final CruiseRepository cruiseRepository;

	public List<Cruise> listAllCruises() {
		return cruiseRepository.findAll();

	}

	private final Logger logger = LoggerFactory.getLogger(CruiseService.class);

	public CruiseService(CruiseRepository cruiseRepository) {
		this.cruiseRepository = cruiseRepository;
	}

	public Cruise getRandomCruise() {
		Faker faker = new Faker();
		Random random = new Random();

		Cruise randomCruise = new Cruise();
		String captainName = faker.name().fullName();
		String yacht = "S/Y " + faker.name().firstName();
		int distance = random.nextInt(100) + 100;

		List<String> locations = new ArrayList<>();
		locations.add("Morze Północne");
		locations.add("Atlantyk");
		locations.add("Morze Śródziemne");
		locations.add("Bałtyk");
		locations.add("Morze Egejskie");
		locations.add("Adriatyk");

		String location = locations.get(random.nextInt(locations.size()));

		randomCruise.setCaptainName(captainName);
		randomCruise.setYacht(yacht);
		randomCruise.setLocation(location);
		randomCruise.setDistance(distance);
		logger.info("Wylosowano rejs - kapitan: " + randomCruise.getCaptainName());
		return randomCruise;
	}

	public void initCruiseRepo() {
		for (int i = 0; i < 5; i++) {
			Cruise cruise = getRandomCruise();
			cruiseRepository.save(cruise);
		}
	}
	
	public Cruise saveRandomCruise() {
		return cruiseRepository.save(getRandomCruise());
	}

	public List<Cruise> getAllCruises() {
		return cruiseRepository.findAll();
	}

	public Cruise getCruise(Long id) {
		return cruiseRepository.findById(id).get();
	}

	public Cruise saveCruise(Cruise cruise) {
		return cruiseRepository.save(cruise);
	}

	public Cruise updateCruiseById(Cruise newCruise, Long id) {
		newCruise.setId(id);
		return cruiseRepository.save(newCruise);
	}

	public void deleteCruiseById(Long id) {
		cruiseRepository.deleteById(id);
	}

}
