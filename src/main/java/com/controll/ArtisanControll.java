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
import com.services.ArtisanRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/artisan")
public class ArtisanControll {

	@Autowired
	private ArtisanRepository artisanRepository;
/*
	@PostMapping(path = "/addArtisan") // Map ONLY GET Requests
	public @ResponseBody ResponseEntity<Object> addNewArtisan(@RequestParam String name,
			@RequestParam String password, @RequestParam String Email, @RequestParam String phone,
			@RequestParam String adresse) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Artisan artisan = new Artisan();
		artisan.setname(name);
	
		artisan.setPassword(password);
		artisan.setEmail(Email);
		artisan.setPhone(phone);
		artisan.setAdresse(adresse);

		Artisan savedArtisan=	artisanRepository.save(artisan);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedArtisan.getArtisanId()).toUri();
		return ResponseEntity.created(location).build();
	}

	/*
	 * @GetMapping(path = "/allAdmins") public @ResponseBody Iterable<UserTest>
	 * getAllUsers() { // This returns a JSON or XML with the users return
	 * userRepository.findAll();
	 * 
	 * }
	 */
	@GetMapping(path = "/allartisans")
	public List<Artisan> getAllArtisans() {
		// This returns a JSON or XML with the users
		return artisanRepository.findAll();

	}

	@GetMapping(path = "/findArtisan/{id}")
	public Optional<Artisan> findArtisan(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
		return artisanRepository.findById(id);

	}

	@GetMapping(path = "/findArtisanByname/{name}")
	public Artisan findArtisanByname(@PathVariable(value = "name") String name) {
		// This returns a JSON or XML with the users
		return artisanRepository.findByName(name);

	}

	@GetMapping(path = "/findArtisanByAdresse/{adresse}")
	public List<Artisan> findArtisanByAdresse(@PathVariable(value = "adresse") String adresse) {
		// This returns a JSON or XML with the users
		return artisanRepository.findByAdresse(adresse);

	}
/*
	@PutMapping(path = "/updateArtisanEmail/{id}")
	public ResponseEntity<Artisan> updateUserEmail(@RequestParam String email, @PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
	Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();
		OptionalArtisan.setEmail(email);

		
		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/updateArtisanname/{id}/{name}")
	public ResponseEntity<Artisan> updateUsername(@RequestBody Artisan artisan, @PathVariable(value = "id") Long id,
			@PathVariable(value = "name") String name) {
		// This returns a JSON or XML with the users
		Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();

		artisan.setname(name);

		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/updateArtisanPassword/{id}/{password}")
	public ResponseEntity<Artisan> updateUserPassword(@RequestBody Artisan artisan, @PathVariable(value = "id") Long id,
			@PathVariable(value = "password") String password) {
		// This returns a JSON or XML with the users
		Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();

		artisan.setPassword(password);

		
		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/updateArtisanPhone/{id}/{phone}")
	public ResponseEntity<Artisan> updateUserPhone(@RequestBody Artisan artisan, @PathVariable(value = "id") Long id,
			@PathVariable(value = "phone") String phone) {
		// This returns a JSON or XML with the users
		Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();

		artisan.setPhone(phone);

	
		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/updateArtisanPseudo/{id}/{pseudo}")
	public ResponseEntity<Artisan> updateUserPseudo(@RequestBody Artisan artisan, @PathVariable(value = "id") Long id,
			@PathVariable(value = "pseudo") String pseudo) {
		// This returns a JSON or XML with the users
		Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();

		artisan.setPseudo(pseudo);

		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}

	/*@PutMapping(path = "/updateArtisanPseudo/{id}/{Adress}")
	public ResponseEntity<Artisan> updateUserAdress(@RequestBody Artisan artisan, @PathVariable(value = "id") Long id,
			@PathVariable(value = "adresse") String adresse) {
		// This returns a JSON or XML with the users
		Optional<Artisan> OptionalArtisan = artisanRepository.findById(id);
		if (!OptionalArtisan.isPresent())
			return ResponseEntity.notFound().build();

		artisan.setPseudo(adresse);

		artisanRepository.save(artisan);

		return ResponseEntity.noContent().build();
	}
	@PutMapping(path = "/updateArtisanAdress/{id}/{Adress}")
	public Artisan updateUserAdress(@PathVariable(value = "id") Long id,
			@PathVariable(value = "adresse") String adresse,@Valid @RequestBody Artisan artisan) {
		// This returns a JSON or XML with the users
			Artisan artisan1= artisanRepository.findById(id);

		artisan1.setAdresse(artisan.getAdresse());

		artisanRepository.save(artisan1);
		return  artisan1;

		
	}
*/
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Artisan> user = artisanRepository.findById(id);
		String Warning="User not found";
		if(user==null)
			return Warning;
			
		artisanRepository.deleteById(id);
		
		return user + " is deleted";
	}

}
