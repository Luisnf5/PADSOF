package users;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import system.ArtGallery;

class AdminTest {

	@Test
	void testAdmin() {
		String name = "John", surname = "Doe", nif = "55450352C", pwd = "password";
		Gender gender = Gender.MALE;
		LocalDate date = LocalDate.now();
		Admin admin = new Admin(name, surname, nif, gender, date, pwd);
		
		assertEquals(name, admin.getName());
		assertEquals(surname, admin.getSurname());
		assertEquals(nif, admin.getNif());
		assertEquals(gender, admin.getGender());
		assertEquals(date, admin.getBirthDate());
		assertEquals(pwd, admin.getPassword());
	}

}
