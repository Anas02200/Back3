package busLogicImp;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entities.Client;
import com.services.ClientRepository;

import busLogic.clientLogic;

@Service
@Transactional
public class clientLogicImp implements clientLogic {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Override
	public Client addClient(String Name, String password, String Cpassword, String Email, String phone) {
		// TODO Auto-generated method stub
		Client clientT = clientRepository.findByName(Name);
		if (clientT != null)
			throw new RuntimeException("User exists");
		if (!password.equals(Cpassword))
			throw new RuntimeException("Please confirm password");

		Client client = new Client();
		client.setname(Name);
		client.setPassword(bCrypt.encode(password));
		client.setEmail(Email);
		client.setPhone(phone);
		clientRepository.save(client);

		return client;
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client findClient(String Name) {
		// TODO Auto-generated method stub
		return clientRepository.findByName(Name);
	}

	public void UpdateClient(String Name, String newName, String Email, String phone,String password) {
		Client clientT = clientRepository.findByName(Name);
		if (clientT == null)
			throw new RuntimeException("User Doesent exists");

		clientRepository.modify(Name, newName, Email, phone,bCrypt.encode(password));
	}

	@Override
	public boolean deleteClient(String Name) {
		// TODO Auto-generated method stub

		if (clientRepository.deleteByName(Name) != null) {
			return true;
		}
		;

		return false;
	}

}
