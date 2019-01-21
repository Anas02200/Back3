package com.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Client;
import com.services.ClientRepository;

import busLogicImp.clientLogicImp;

@RestController
@RequestMapping(path = "/client")
public class ClientControll {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private clientLogicImp clientLogic;

	@PostMapping(path = "/addClient") // Map ONLY GET Requests
	public Client addClient(@RequestParam String name,@RequestParam String password,@RequestParam String Cpassword,@RequestParam String email,@RequestParam String phone ) {

		return clientLogic.addClient(name, password, Cpassword,email, phone);

	}

	@GetMapping(path = "/allClients")
	public List<Client> getAllClients() {
		// This returns a JSON or XML with the users
		return clientLogic.getAllClient();

	}

	@GetMapping(path = "/findClient/{id}")
	public Optional<Client> findClient(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
		return clientRepository.findById(id);

	}

	@GetMapping(path = "/findClientByName/{name}")
	public Client findClientByName(@PathVariable(value = "name") String name) {

		return clientLogic.findClient(name);
	}

	@PutMapping(path = "/updateClient")
	public void updateClient(@RequestParam String name, @RequestParam String newName, @RequestParam String email, @RequestParam String phone, @RequestParam String password) {
		 clientLogic.UpdateClient(name,newName, email, phone,password);
		 
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Client> user = clientRepository.findById(id);
		clientRepository.deleteById(id);
		return user + " is deleted";
	}

	@DeleteMapping("/delete/{name}")
	public String delete(@PathVariable(value = "name") String name) {
		clientLogic.deleteClient(name);
		return "deleted";
	}

}
