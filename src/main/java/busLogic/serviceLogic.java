package busLogic;

import java.util.List;

import com.entities.Service;

public interface serviceLogic {
	
	
	public Service addService(String typeService,
			String ServiceDesc);
	
	public List<Service> getAllService();
	
	public 	Service findService(String Name);
	
	public boolean deleteService(String Name);
	
	
	

}
