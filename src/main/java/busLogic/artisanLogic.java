package busLogic;

import java.util.List;

import com.entities.Artisan;
import com.entities.Service;

public interface artisanLogic {
	
	public Artisan addArtisan(String Name,String password,
			String Cpassword,String Email, String phone,String Addresse,String serviceName);
	
	public List<Artisan> getAllArtisan();
	
	public 	Artisan findArtisan(String Name);
	
	public boolean deleteArtisan(String Name);
		
	

}
