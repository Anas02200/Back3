package busLogicImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entities.Artisan;
import com.services.ArtisanRepository;

import busLogic.artisanLogic;

@Service
@Transactional
public class artisanLogicImp implements artisanLogic {

	@Autowired
	private ArtisanRepository artisanRepository;
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Override
	public Artisan  addArtisan(String Name,String password,
			String Cpassword,String Email, String phone,String Addresse,String serviceName){
		// TODO Auto-generated method stub
		Artisan artisanT = artisanRepository.findByName(Name);
		if (artisanT != null)
			throw new RuntimeException("User exists");
		if (!password.equals(Cpassword))
			throw new RuntimeException("Please confirm password");

		Artisan artisan = new Artisan();
		artisan.setname(Name);
		artisan.setPassword(bCrypt.encode(password));
		artisan.setEmail(Email);
		artisan.setPhone(phone);
		artisan.setAdresse(Addresse);
		artisanRepository.save(artisan);
		artisanRepository.AddServiceToArtisan(Name, serviceName);
		artisanRepository.AddArtisanToservice(Name, serviceName);

		return artisan;
	}

	@Override
	public List<Artisan> getAllArtisan() {
		// TODO Auto-generated method stub
		return artisanRepository.findAll();
	}

	public List<Artisan> findArtisanByService(String name) {
		// TODO Auto-generated method stub
		return artisanRepository.findByServiceName(name);
	}

	@Override
	public Artisan findArtisan(String Name) {
		// TODO Auto-generated method stub
		return artisanRepository.findByName(Name);
	}

	public void UpdateArtisan(String name,String newName,String email,String phone,String password,String adresse) {
		Artisan artisanT = artisanRepository.findByName(name);
		if (artisanT == null)
			throw new RuntimeException("User Doesent exists");

		artisanRepository.modify(name, newName, email, phone, bCrypt.encode(password),adresse);
	}

	@Override
	public boolean deleteArtisan(String Name) {
		// TODO Auto-generated method stub

		if (artisanRepository.deleteByName(Name) != null) {
			return true;
		}
		;

		return false;
	}

}
