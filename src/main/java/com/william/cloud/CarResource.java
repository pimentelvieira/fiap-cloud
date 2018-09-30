package com.william.cloud;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.william.cloud.model.Car;
import com.william.cloud.repository.CarRepository;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CarResource {

	@Autowired
	private CarRepository repo;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Car car) {
		car = repo.insert(car);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(car.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Car>> findAll() {
		return ResponseEntity.ok().body(repo.findAll());
	}
}
