package busLogicImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entities.Artisan;
import com.entities.Artisan;
import com.services.ArtisanRepository;
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
	public Artisan addArtisan(String Name, String password, String Cpassword, String Email, String phone,String address) {
		// TODO Auto-generated method stub
		Artisan artisanT=artisanRepository.findByName(Name);
		if(artisanT!=null) throw new RuntimeException("User exists");
		if(!password.equals(Cpassword)) throw new RuntimeException("Please confirm password");
		
		Artisan artisan = new Artisan();
		artisan.setname(Name);
		artisan.setPassword(bCrypt.encode(password));
		artisan.setEmail(Email);
		artisan.setPhone(phone);
		artisan.setAdresse(address);
		artisanRepository.save(artisan);
		
		
		return artisan;
	}

	@Override
	public List<Artisan> getAllArtisan() {
		// TODO Auto-generated method stub
		return artisanRepository.findAll();
	}

	@Override
	public Artisan findArtisan(String Name) {
		// TODO Auto-generated method stub
		return artisanRepository.findByName(Name);
	}

	@Override
	public boolean deleteArtisan(String Name) {
		// TODO Auto-generated method stub
		
		if(artisanRepository.deleteByName(Name) != null) {
			return true;
		};
		
		
		return false;
	}

}
