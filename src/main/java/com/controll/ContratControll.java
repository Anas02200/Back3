/*
package com.controll;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Artisan;
import com.entities.Client;
import com.entities.Contrat;
import com.entities.Service;
import com.services.ContratRepository;


@RestController
@RequestMapping(path = "/Contrat")
public class ContratControll {
	@Autowired
	private ContratRepository contratRepository;

	@PostMapping(path = "/addContrat") // Map ONLY GET Requests
	public @ResponseBody ResponseEntity<Object> addNewContrat(@RequestParam Date date, @RequestParam Artisan artisan,
			@RequestParam Client client, @RequestParam Service service) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Contrat contrat = new Contrat();
		contrat.setDate(date);
		contrat.setArtisan(artisan);
		contrat.setClient(client);
		contrat.setService(service);
		Contrat savedContrat = contratRepository.save(contrat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Contrat}")
				.buildAndExpand(savedContrat.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	/*
	 * @GetMapping(path = "/allContrats") public @ResponseBody Iterable<UserTest>
	 * getAllUsers() { // This returns a JSON or XML with the contrats return
	 * contratRepository.findAll();
	 * 
	 * }
	 
	@GetMapping(path = "/allContrats")
	public List<Contrat> getAllUsers() {
		// This returns a JSON or XML with the contrats
		return contratRepository.findAll();

	}

	@GetMapping(path = "/findContrat/{id}")
	public Optional<Contrat> findUser(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the contrats
		return contratRepository.findById(id);

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Contrat> contrat = contratRepository.findById(id);
		contratRepository.deleteById(id);
		return contrat + " is deleted";
	}

	@GetMapping(path = "/findByArtisanID/{id}")
	public List<Contrat> findByArtisanId(@PathVariable(value = "id") long id) {
		// This returns a JSON or XML with the users
		return contratRepository.findByArtisanId(id);
	}

	@GetMapping(path = "/findByClientID/{id}")
	public List<Contrat> findByClientID(@PathVariable(value = "id") long id) {
		// This returns a JSON or XML with the users
		return contratRepository.findByClientID(id);
	}

	@GetMapping(path = "/findByServiceID/{id}")
	public List<Contrat> findByServiceID(@PathVariable(value = "id") long id) {
		// This returns a JSON or XML with the users
		return contratRepository.findByServiceID(id);
	}

}
*/