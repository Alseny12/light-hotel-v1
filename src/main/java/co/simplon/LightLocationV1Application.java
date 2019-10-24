package co.simplon;

import co.simplon.dao.VilleRepository;
import co.simplon.dao.HotelRepository;
import co.simplon.dao.UserRepository;
import co.simplon.entities.Ville;
import co.simplon.entities.Hotel;
import co.simplon.entities.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;


@SpringBootApplication
public class LightLocationV1Application implements CommandLineRunner  {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VilleRepository villeRepository;
	public static void main(String[] args) {
		SpringApplication.run(LightLocationV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Hotel.class,Ville.class,User.class);
		villeRepository.save( new Ville(null,"Guinée",null,null,null ));
		villeRepository.save( new Ville(null,"Paris",null,null,null ));
		villeRepository.save(new Ville(null,"Londre",null,null,null ));
		Random rnd= new Random();
		villeRepository.findAll().forEach(v-> {
			for(int i=0;i<10;i++) {
				Hotel h = new Hotel();
				h.setName(RandomString.make(18));
				h.setPrice(100 + rnd.nextInt(10000));
				h.setAvailable(rnd.nextBoolean());
				h.setNumberChambre(rnd.nextInt(100 - 0+1)+0);
				h.setPhone("06"+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0))+Integer.toString(rnd.nextInt(9-0)));
				h.setAdresse(RandomString.make(18));
				h.setNumberPersonne(1+rnd.nextInt(10));
				h.setNumberEtoile(1+rnd.nextInt(5));
				h.setSelected(rnd.nextBoolean());
				h.setVille(v);
				h.setPhotoName("wordpress-categories-640x400 (1).png");
				hotelRepository.save(h);

			}
		});
		userRepository.save(new User(null,"Alseny","keita","hotelier"));
		userRepository.save(new User(null,"toto","choco","user"));
		userRepository.save(new User(null,"franck","123123","user"));
		userRepository.save((new User(null,"baba","bobo12","user")));

	}
}
