package users;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import system.ArtGallery;
import works.Exhibition;

class UserTest {
	User client, staff, admin;
	
	@BeforeEach
    void setUp() {
		client = new Client("John", "Doe", "55450352C", Gender.MALE, LocalDate.now(), "password");
		staff = new Staff("John", "Doe", "55450352C", Gender.MALE, LocalDate.now());
		admin = new Admin("John", "Doe", "55450352C", Gender.MALE, LocalDate.now(), "password");
    }

	@Test
	void testValidate_credentials() {
		assertTrue(client.validate_credentials("55450352C", "password"));
		assertFalse(client.validate_credentials("55450352", "passwoRd"));
		assertTrue(admin.validate_credentials("55450352C", "password"));
		assertFalse(admin.validate_credentials("55450352", "passwoRd"));
	}

	@Test
	void testChangePwd() {
		//Admin
		ArtGallery artGallery = ArtGallery.getSystem();
		artGallery.setLoggedUser(admin);
		assertFalse(admin.changePwd("password"));
		assertTrue(admin.changePwd("P4ssword"));
		
		//Client
		artGallery.setLoggedUser(admin);
		assertFalse(admin.changePwd("password"));
		assertTrue(admin.changePwd("P4ssword"));
	}

	@Test
	void testIsPwdValid() {
		//No number
		assertFalse(client.isPwdValid("Password"));
		//No Caps
		assertFalse(client.isPwdValid("p4ssword"));
		//No Lowercase
		assertFalse(client.isPwdValid("P4SSWORD"));
		
		//Everything fine
		assertTrue(client.isPwdValid("P4ssword"));
	}

	@Test
	void testChangeName() {
		//Admin
		ArtGallery artGallery = ArtGallery.getSystem();
		artGallery.setLoggedUser(admin);
		admin.changeName("Jack");
		assertEquals("Jack", admin.getName());
		
		//Staff
		artGallery.setLoggedUser(staff);
		staff.changeName("Jack");
		assertEquals("Jack", staff.getName());
		
		//Client
		artGallery.setLoggedUser(client);
		client.changeName("Jack");
		assertEquals("Jack", client.getName());
	}

	@Test
	void testChangeSurname() {
		//Admin
		ArtGallery artGallery = ArtGallery.getSystem();
		artGallery.setLoggedUser(admin);
		admin.changeSurname("Jack");
		assertEquals("Jack", admin.getSurname());
		
		//Staff
		artGallery.setLoggedUser(staff);
		staff.changeSurname("Jack");
		assertEquals("Jack", staff.getSurname());
		
		//Client
		artGallery.setLoggedUser(client);
		client.changeSurname("Jack");
		assertEquals("Jack", client.getSurname());
	}

	@Test
	void testChangeBirthDate() {
		//Admin
		ArtGallery artGallery = ArtGallery.getSystem();
		artGallery.setLoggedUser(admin);
		admin.changeBirthDate(LocalDate.of(2025, 12, 12));
		assertEquals(LocalDate.of(2025, 12, 12), admin.getBirthDate());
		
		//Staff
		artGallery.setLoggedUser(staff);
		staff.changeBirthDate(LocalDate.of(2025, 12, 12));
		assertEquals(LocalDate.of(2025, 12, 12), staff.getBirthDate());
		
		//Client
		artGallery.setLoggedUser(client);
		client.changeBirthDate(LocalDate.of(2025, 12, 12));
		assertEquals(LocalDate.of(2025, 12, 12), client.getBirthDate());
	}

	@Test
	void testHasPrivilege() {
		//Admin
		admin.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(admin.hasPrivilege(Privileges.GESTION_SALAS));
		//Staff
		staff.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(staff.hasPrivilege(Privileges.GESTION_SALAS));
		//Client
		client.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(client.hasPrivilege(Privileges.GESTION_SALAS));
	}

	@Test
	void testAddPrivilege() {
		//Admin
		admin.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(admin.privileges.contains(Privileges.GESTION_SALAS));
		//Staff
		staff.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(staff.privileges.contains(Privileges.GESTION_SALAS));
		//Client
		client.addPrivilege(Privileges.GESTION_SALAS);
		assertTrue(client.privileges.contains(Privileges.GESTION_SALAS));
	}

}
