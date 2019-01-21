package com.controll;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Artisan;
import com.entities.Artisan;
import com.services.ArtisanRepository;
import com.services.ArtisanRepository;

import busLogicImp.artisanLogicImp;

@RestController
@RequestMapping(path = "/artisan")
public class ArtisanControll {
	@Autowired
	private ArtisanRepository artisanRepository;
	@Autowired
	private artisanLogicImp artisanLogic;

	@PostMapping(path = "/addArtisan") // Map ONLY GET Requests
	public Artisan addArtisan(@RequestParam String name,@RequestParam String password,@RequestParam String Cpassword,@RequestParam String email,@RequestParam String phone,@RequestParam String adresse,@RequestParam String serviceName ) {
		
		return artisanLogic.addArtisan(name, password, Cpassword,email, phone,adresse,serviceName);

	}

	@GetMapping(path = "/allArtisans")
	public List<Artisan> getAllArtisans() {
		// This returns a JSON or XML with the users
		return artisanLogic.getAllArtisan();

	}

	@GetMapping(path = "/findArtisan/{id}")
	public Optional<Artisan> findArtisan(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
		return artisanRepository.findById(id);

	}

	@GetMapping(path = "/findArtisanByName/{name}")
	public Artisan findArtisanByName(@PathVariable(value = "name") String name) {

		return artisanLogic.findArtisan(name);
	}
	@GetMapping(path = "/findArtisanByService/{name}")
	public List<Artisan> findArtisanByService(@PathVariable(value = "name") String name) {

		return artisanLogic.findArtisanByService(name);
	}
	

	@PutMapping(path = "/updateArtisan")
	public void updateArtisan(@RequestParam String name, @RequestParam String newName, @RequestParam String email, @RequestParam String phone, @RequestParam String password,@RequestParam String adresse) {
		 artisanLogic.UpdateArtisan(name,newName, email, phone,password,adresse);
		 
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Artisan> user = artisanRepository.findById(id);
		artisanRepository.deleteById(id);
		return user + " is deleted";
	}

	@DeleteMapping("/delete/{name}")
	public String delete(@PathVariable(value = "name") String name) {
		artisanLogic.deleteArtisan(name);
		return "deleted";
	}

}
