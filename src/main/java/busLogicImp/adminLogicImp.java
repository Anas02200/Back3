package busLogicImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entities.Artisan;
import com.entities.Client;
import com.entities.Admin;
import com.services.AdminRepository;

import busLogic.adminLogic;
import org.springframework.stereotype.Service;




@org.springframework.stereotype.Service
@Transactional
public class adminLogicImp implements adminLogic {
	
	private AdminRepository adminRepository;
	
	private BCryptPasswordEncoder bCrypt;
	
	

	public adminLogicImp(AdminRepository adminRepository, BCryptPasswordEncoder bCrypt) {
		super();
		this.adminRepository = adminRepository;
		this.bCrypt = bCrypt;
	}

	@Override
	public Admin addAdmin(String Name, String password, String Cpassword) {
		// TODO Auto-generated method stub
		Admin adminT=adminRepository.findByName(Name);
		if(adminT!=null) throw new RuntimeException("User exists");
		if(!password.equals(Cpassword)) throw new RuntimeException("Please confirm password");
		
		Admin admin = new Admin();
		admin.setname(Name);
		admin.setPassword(bCrypt.encode(password));
		adminRepository.save(admin);
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin findAdmin(String Name) {
		// TODO Auto-generated method stub
		return adminRepository.findByName(Name);
	}
	public void UpdateAdmin(String Name, String newName, String password) {
		Admin AdminT = adminRepository.findByName(Name);
		if (AdminT == null)
			throw new RuntimeException("User Doesent exists");

		adminRepository.modify(Name, newName,bCrypt.encode(password));
	}

	@Override
	public boolean deleteAdmin(String Name) {
		// TODO Auto-generated method stub
		if(adminRepository.deleteByName(Name) != null) {
			return true;
		};
		
		
		return false;
	}

}
