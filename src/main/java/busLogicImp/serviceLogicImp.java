package busLogicImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.entities.Admin;
import com.entities.Service;
import com.entities.Service;
import com.services.ServiceRepository;
import com.services.ServiceRepository;

import busLogic.serviceLogic;




@org.springframework.stereotype.Service
@Transactional
public class serviceLogicImp implements serviceLogic {

	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	@Override
	public Service addService(String typeService,
			String ServiceDesc) {
		// TODO Auto-generated method stub
		Service serviceT=serviceRepository.findByName(typeService);
		if(serviceT!=null) throw new RuntimeException("User exists");
		
		
		Service service = new Service();
		service.setTypeService(typeService);
		service.setServiceDescription(ServiceDesc);
		serviceRepository.save(service);
		
		
		return service;
	}

	@Override
	public List<Service> getAllService() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public Service findService(String Name) {
		// TODO Auto-generated method stub
		return serviceRepository.findByName(Name);
	}
	public void UpdateService(String Name, String newName, String desc) {
		Service ServiceT = serviceRepository.findByName(Name);
		if (ServiceT == null)
			throw new RuntimeException("User Doesent exists");

		serviceRepository.modify(Name, newName,desc);
	}
	@Override
	public boolean deleteService(String Name) {
		// TODO Auto-generated method stub
		
		if(serviceRepository.deleteByName(Name) != null) {
			return true;
		};
		
		
		return false;
	}

}
