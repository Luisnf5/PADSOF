package users;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import works.*;

class StaffTest {

	@Test
	void testChangePwd() {
		String name = "John";
		String surname = "Doe";
		String nif = "55450352C";
		Gender gender = Gender.MALE;
		LocalDate date = LocalDate.now();
		
		Staff staff = new Staff(name, surname, nif, gender, date);
		if(staff.changePwd("H0la1234")) {
			assertEquals("H0la1234", staff.getPassword());
		}else {
			assertFalse(staff.isPwdValid("H0la1234"));
		}
		if(staff.changePwd("Hola")) {
			assertEquals("Hola", staff.getPassword());
		}else {
			assertFalse(staff.isPwdValid("Hola"));
		}
		
	}

	@Test
	void testStaff() {
		String name = "John";
		String surname = "Doe";
		String nif = "55450352C";
		Gender gender = Gender.MALE;
		LocalDate date = LocalDate.now();
		
		Staff staff = new Staff(name, surname, nif, gender, date);
		
		assertEquals(staff.getBirthDate(), date);
		assertEquals(staff.getSurname(), surname);
		assertEquals(staff.getNif(), nif);
		assertEquals(staff.getName(), name);
		assertEquals(staff.getGender(), gender);
	}

}
