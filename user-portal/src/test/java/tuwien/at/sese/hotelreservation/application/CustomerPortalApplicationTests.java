package tuwien.at.sese.hotelreservation.application;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import tuwien.at.sese.hotelreservation.application.utils.ITUtil;
import tuwien.at.sese.hotelreservation.message.request.SignUpForm;
import tuwien.at.sese.hotelreservation.model.Contact;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.model.Event;
import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.model.Role;
import tuwien.at.sese.hotelreservation.model.RoleName;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.model.User;
import tuwien.at.sese.hotelreservation.repository.ContactRepository;
import tuwien.at.sese.hotelreservation.repository.CustomerRepository;
import tuwien.at.sese.hotelreservation.repository.EventRepository;
import tuwien.at.sese.hotelreservation.repository.ReservationRepository;
import tuwien.at.sese.hotelreservation.repository.RoleRepository;
import tuwien.at.sese.hotelreservation.repository.RoomRepository;
import tuwien.at.sese.hotelreservation.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"app.jwtSecret=secret", "app.jwtExpiration=2344342"})
@EnableJpaRepositories(basePackages = "tuwien.at.sese.hotelreservation.reprository")
public class CustomerPortalApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private EventRepository eventRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void contextLoads() {
	}

	Room room = null;
	@Before
	public void setup(){
		 room = ITUtil.createDummyRoom();
		// create
		roomRepository.save(room);
	}

	@Rollback(false)
	@Test
	public void whenFindByName_thenReturnCustomer() {
		// given
		Customer alex = ITUtil.createDummyCustomer();
		Reservation reservation = new Reservation();
		reservation.setFromDate(LocalDate.now());
		reservation.setToDate(LocalDate.now().plusDays(10));

		alex.getReservations().add(reservation);

		customerRepository.save(alex);

		// when
		List<Customer> founds = customerRepository.findAll();

		// then
		Assert.assertTrue("not empty", !founds.isEmpty());
	}
	public void createNewUserReturnCustomer() {
		// given
		Customer hans = ITUtil.createDummyCustomer();
		hans.setFirmenname("HansFIrma");
		hans.setFirstName("Hans");
		hans.setLastName("Hanso");
		hans.setEmail("hans@email.com");
		Reservation reservation = new Reservation();
		reservation.setFromDate(LocalDate.now());
		reservation.setToDate(LocalDate.now().plusDays(10));

		hans.getReservations().add(reservation);

		customerRepository.save(hans);

		// when
		List<Customer> founds = customerRepository.findAll();

		// then
		Assert.assertTrue("not empty", !founds.isEmpty());
	}

	@Test
	public void createReservation() {
		Reservation reservation = ITUtil.createDummyReservation(roomRepository.findAll().get(0));
		// create
		reservationRepository.save(reservation);

		// when
		List<Reservation> founds = reservationRepository.findAll();
		// then
		Assert.assertTrue("not empty", !founds.isEmpty());

	}

	@Test
	public void createRoom() {
		Room room = ITUtil.createDummyRoom();
		// create
		roomRepository.save(room);

		// when
		List<Room> founds = roomRepository.findAll();
		// then
		Assert.assertTrue("not empty", !founds.isEmpty());

	}

	@Test
	public void createEvent() {
		User user = createSampleUser("holidayUser");
		
		Event event = ITUtil.createDummyEvent(user);
		event = eventRepository.save(event);
		Assert.assertNotNull(event.getId());
	}
	
    @Test
    public void createContact() {
        Contact contact = ITUtil.createDummyContact();
        // create
        contactRepository.save(contact);

        // when
        List<Contact> founds = contactRepository.findAll();
        // then
        Assert.assertTrue("not empty", !founds.isEmpty());

    }

	@Test
	public void createUser() {
		final SignUpForm admin = new SignUpForm();
		admin.setName("Admin");
		admin.setUsername("admin");
		admin.setEmail("admin@mail.com");
		admin.setPassword("password");
		admin.setRole(new HashSet<String>(){{add("admin");}});
		createUser(admin);

		createSampleUser("user");
	}

	private User createSampleUser(String username) {
		final @Valid SignUpForm user = new SignUpForm();
		user.setName("User");
		user.setUsername(username);
		user.setEmail(username+"@mail.com");
		user.setPassword("password");
		user.setRole(new HashSet<String>(){{add("user");}});
		return createUser(user);
	}
	User createUser(SignUpForm signUpRequest){
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
			encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role)
			{
				case "admin":
					Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(adminRole);

					break;
				case "pm":
					Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(pmRole);

					break;
				default:
					Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
					roles.add(userRole);
			}
		});

		user.setRoles(roles);
		return userRepository.save(user);
	}


	@Test
	public void createRooms() {
		List<Room> rooms = ITUtil.createDummyRooms();
		// create
		rooms.forEach(room -> roomRepository.save(room));

		// when
		List<Room> founds = roomRepository.findAll();
		// then
		Assert.assertTrue("not empty", !founds.isEmpty());

	}

}
