package Security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entities.Artisan;
import com.entities.Client;
import com.entities.Admin;

import busLogic.adminLogic;
import busLogic.artisanLogic;
import busLogic.clientLogic;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private adminLogic adminlogic;
	@Autowired
	private artisanLogic artisanlogic;
	@Autowired
	private clientLogic clientlogic;
	
	private User user ;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		Admin client = clientlogic.findClient(name);
		Admin artisan = artisanlogic.findArtisan(name);
		Admin admin = adminlogic.findAdmin(name);
		

		if ((client == null) && (artisan == null) && (admin == null))
			throw new UsernameNotFoundException("invalid user");

		if (client != null) {
			Collection<GrantedAuthority> authority = new ArrayList<>();
			authority.add(new SimpleGrantedAuthority(client.getRole()));
			this.user = new User(client.getname(), client.getPassword(), authority);

		}
		if (artisan != null) {
			Collection<GrantedAuthority> authority = new ArrayList<>();
			authority.add(new SimpleGrantedAuthority(artisan.getRole()));
			this.user = new User(artisan.getname(), artisan.getPassword(), authority);

		}
		if (admin != null) {
			Collection<GrantedAuthority> authority = new ArrayList<>();
			authority.add(new SimpleGrantedAuthority(admin.getRole()));
			this.user = new User(admin.getname(), admin.getPassword(), authority);

		}

		return this.user;

	}

}
