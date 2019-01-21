package busLogic;

import java.util.List;

import com.entities.Admin;

public interface adminLogic {

	public Admin addAdmin(String Name,String password,
			String Cpassword);
	
	public List<Admin> getAllAdmin();
	
	public 	Admin findAdmin(String Name);
	
	public boolean deleteAdmin(String Name);
	
	
	
	
	
}
