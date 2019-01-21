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

import com.entities.Client;
import com.entities.Admin;
import com.services.AdminRepository;

@RestController
@RequestMapping(path = "/admin")
public class UserControl {

	@Autowired
	private AdminRepository adminRepository;
/*
	@PostMapping(path = "/addAdmin") // Map ONLY GET Requests
	public @ResponseBody ResponseEntity<Object> addNewAdmin(@RequestParam String name,@RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Admin user = new Admin();
		user.setName(name);
		
		user.setPassword(password);
		Admin savedUser=adminRepository.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}

	/*@GetMapping(path = "/allAdmins")
	public @ResponseBody Iterable<UserTest> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
		
	}*/
	@GetMapping(path = "/allAdmins")
	public List<Admin> getAllUsers() {
		// This returns a JSON or XML with the users
		return adminRepository.findAll();
		
	}
	@GetMapping(path = "/findAdmin/{id}")
	public Optional<Admin> findUser(@PathVariable(value="id") Long id) {
		// This returns a JSON or XML with the users
		return adminRepository.findById(id);
		
	}
	@GetMapping(path = "/findAdmin/{name}")
	public Admin findClient(@PathVariable(value = "name") String name) {
		// This returns a JSON or XML with the users
		return adminRepository.findByName(name);

	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		 Optional<Admin> user=adminRepository.findById(id);
		adminRepository.deleteById(id);
		return user+" is deleted";
	}
	
	

}
