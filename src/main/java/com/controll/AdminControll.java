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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entities.Admin;
import com.entities.Admin;
import com.services.AdminRepository;
import com.services.AdminRepository;

import busLogicImp.adminLogicImp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/admin")
public class AdminControll {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private adminLogicImp adminLogic;

	@PostMapping(path = "/addAdmin") // Map ONLY GET Requests
	public Admin addAdmin(@RequestParam String name,@RequestParam String password,@RequestParam String Cpassword) {

		return adminLogic.addAdmin(name, password, Cpassword);

	}

	@GetMapping(path = "/allAdmins")
	public List<Admin> getAllAdmins() {
		// This returns a JSON or XML with the users
		return adminLogic.getAllAdmin();

	}

	@GetMapping(path = "/findAdmin/{id}")
	public Optional<Admin> findAdmin(@PathVariable(value = "id") Long id) {
		// This returns a JSON or XML with the users
		return adminRepository.findById(id);

	}

	@GetMapping(path = "/findAdminByName/{name}")
	public Admin findAdminByName(@PathVariable(value = "name") String name) {

		return adminLogic.findAdmin(name);
	}

	@PutMapping(path = "/updateAdmin")
	public void updateAdmin(@RequestParam String name, @RequestParam String newName, @RequestParam String password) {
		 adminLogic.UpdateAdmin(name,newName,password);
		 
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) {
		Optional<Admin> user = adminRepository.findById(id);
		adminRepository.deleteById(id);
		return user + " is deleted";
	}

	@DeleteMapping("/delete/{name}")
	public String delete(@PathVariable(value = "name") String name) {
		adminLogic.deleteAdmin(name);
		return "deleted";
	}

}
