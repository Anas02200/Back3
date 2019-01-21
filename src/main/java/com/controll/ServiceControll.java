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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Service;
import com.services.ServiceRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/service")
public class ServiceControll {

	@Autowired
	private ServiceRepository serviceRepository;
	
	@PostMapping(path = "/addservice") // Map ONLY GET Requests
	public @ResponseBody ResponseEntity<Object> addNewService(@RequestParam String serviceDescription , @RequestParam String typeService) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Service service = new Service();
		service.setServiceDescription(serviceDescription);
		service.setTypeService(typeService);
		
		Service savedService=serviceRepository.save(service);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedService.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}

	
	@GetMapping(path = "/allService")
	public List<Service> getAllUsers() {
		// This returns a JSON or XML with the services
		return serviceRepository.findAll();
		
	}
	@GetMapping(path = "/findService/{id}")
	public Optional<Service> findUser(@PathVariable(value="id") Long id) {
		// This returns a JSON or XML with the services
		return serviceRepository.findById(id);
		
	}
	@GetMapping(path = "/findServiceByName/{name}")
	public Service findServiceByName(@PathVariable(value = "name") String name) {
		// This returns a JSON or XML with the users
		return serviceRepository.findBytypeService(name);

	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Long id) {
		 Optional<Service> service=serviceRepository.findById(id);
		serviceRepository.deleteById(id);
		return service+" is deleted";
	}
	
	
	
	
	
	
	
	
}
