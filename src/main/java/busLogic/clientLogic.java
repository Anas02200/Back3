package busLogic;

import java.util.List;

import com.entities.Client;

public interface clientLogic {

	public Client addClient(String Name,String password,
			String Cpassword,String Email, String phone);
	
	public List<Client> getAllClient();
	
	public 	Client findClient(String Name);
	
	public boolean deleteClient(String Name);
	
	
	
}
