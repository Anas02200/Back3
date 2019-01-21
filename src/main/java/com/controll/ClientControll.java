package com.controll;

import java.net.URI;
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
import com.services.ClientRepository;

@RestController
@RequestMapping(path = "/client")
public class ClientControll {
	@Autowired
	private ClientRepository clientRepository;
/*
	@PostMapping(path = "/addClient") // Map ONLY GET Requests
	public @ResponseBody ResponseEntity<Object> addNewClient(@RequestParam String name, @RequestParam String password,
			@RequestParam String Email, @RequestParam String phone) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Client client = new Client();
		client.setName(name);
		client.setPassword(password);
		client.setEmail(Email);
		client.setPhone(phone);
		Client savedClient = clientRepository.save(client);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedClient.getClientId()).toUri();
		return ResponseEntity.created(location).build();

	}

	/*
	 * @GetMapping(path = "/allAdmins") public @ResponseBody Iterable<UserTest>
	 * getAllUsers() { // This returns a JSON or XML with the users return
	 * userRepository.findAll();
	 * 
	 * }
	 */
	@GetMapping(path = "/allclients")
	public List<Client> getAllClients() {
		// This returns a JSON or XML with the users
		return clientRepository.findAll();

	}

	@GetMapping(path = "/findClient/{id}")
	public Optional<Client> findClient(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
		return clientRepository.findById(id);

	}
	@GetMapping(path = "/findClientByName/{name}")
	public Client findClientByName(@PathVariable(value = "name") String name) {
		// This returns a JSON or XML with the users
		return clientRepository.findByName(name);
	}

	/*
	 * @PutMapping(path = "/updateClientEmail/{id}/{email}") public
	 * ResponseEntity<Client> updateUserEmail(@RequestBody Client
	 * client, @PathVariable(value = "id") Long id,
	 * 
	 * @PathVariable(value = "email") String email) { // This returns a JSON or XML
	 * with the users Optional<Client> OptionalClient =
	 * clientRepository.findById(id); if (!OptionalClient.isPresent()) return
	 * ResponseEntity.notFound().build(); client.setEmail(email);
	 * 
	 * 
	 * clientRepository.save(client);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PutMapping(path = "/updateClientName/{id}/{name}") public
	 * ResponseEntity<Client> updateUserName(@RequestBody Client
	 * client, @PathVariable(value = "id") Long id,
	 * 
	 * @PathVariable(value = "name") String name) { // This returns a JSON or XML
	 * with the users Optional<Client> OptionalClient =
	 * clientRepository.findById(id); if (!OptionalClient.isPresent()) return
	 * ResponseEntity.notFound().build();
	 * 
	 * client.setName(name);
	 * 
	 * 
	 * clientRepository.save(client);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PutMapping(path = "/updateClientPassword/{id}/{password}") public
	 * ResponseEntity<Client> updateUserPassword(@RequestBody Client
	 * client, @PathVariable(value = "id") Long id,
	 * 
	 * @PathVariable(value = "password") String password) { // This returns a JSON
	 * or XML with the users Optional<Client> OptionalClient =
	 * clientRepository.findById(id); if (!OptionalClient.isPresent()) return
	 * ResponseEntity.notFound().build();
	 * 
	 * client.setPassword(password);
	 * 
	 * 
	 * clientRepository.save(client);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PutMapping(path = "/updateClientPhone/{id}/{phone}") public
	 * ResponseEntity<Client> updateUserPhone(@RequestBody Client
	 * client, @PathVariable(value = "id") Long id,
	 * 
	 * @PathVariable(value = "phone") String phone) { // This returns a JSON or XML
	 * with the users Optional<Client> OptionalClient =
	 * clientRepository.findById(id); if (!OptionalClient.isPresent()) return
	 * ResponseEntity.notFound().build();
	 * 
	 * client.setPhone(phone);
	 * 
	 * 
	 * 
	 * clientRepository.save(client);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PutMapping(path = "/updateClientPseudo/{id}/{pseudo}") public
	 * ResponseEntity<Client> updateUserPseudo(@RequestBody Client
	 * client, @PathVariable(value = "id") Long id,
	 * 
	 * @PathVariable(value = "pseudo") String pseudo) { // This returns a JSON or
	 * XML with the users Optional<Client> OptionalClient =
	 * clientRepository.findById(id); if (!OptionalClient.isPresent()) return
	 * ResponseEntity.notFound().build();
	 * 
	 * 
	 * client.setPseudo(pseudo);
	 * 
	 * 
	 * clientRepository.save(client);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 */
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Client> user = clientRepository.findById(id);
		clientRepository.deleteById(id);
		return user + " is deleted";
	}

}
