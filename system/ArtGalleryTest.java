package system;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;

import users.*;
import works.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtGalleryTest {
	private ArtGallery artGallery;
	private Client c, c2;
	private Staff s, s2;
	
	@BeforeEach
    void setUp() {
        artGallery = ArtGallery.getSystem();
        c = new Client("Gael", "Ankaoua", "55450352C", Gender.MALE, LocalDate.of(2004, 12, 12), "123456789Hola");
        s = new Staff("Luis", "Nunez", "12345678A", Gender.MALE, LocalDate.of(2004, 1, 1));
        c2 = new Client("Javier", "Fuentes", "98765432Z", Gender.MALE, LocalDate.of(2004, 2, 2), "123456789Holaa");
        s2 = new Staff("Jorge", "Garcia", "13467925H", Gender.MALE, LocalDate.of(2004, 3, 3));

	}

	@Test
	void testGetStaffs() {
		Set<Staff> st = new LinkedHashSet<>();
		st.add(s);
		artGallery.newStaff(s);
		assertEquals(artGallery.getStaffs(), st);
		
		st.add(s2);
		assertNotEquals(artGallery.getStaffs(), st);
		artGallery.newStaff(s2);
		
		assertEquals(artGallery.getStaffs(), st);
		
	}

	@Test
	void testGetClients() {
		Set<Client> cl = new LinkedHashSet<>();
		cl.add(c);
		artGallery.newClient("Gael", "Ankaoua", "55450352C", Gender.MALE, LocalDate.of(2004, 12, 12), "123456789Hola");
		assertEquals(artGallery.getClients(), cl);
		
		cl.add(c2);
		assertNotEquals(artGallery.getClients(), cl);
		artGallery.newClient("Javier", "Fuentes", "98765432Z", Gender.MALE, LocalDate.of(2004, 2, 2), "123456789Holaa");
		
		assertEquals(artGallery.getStaffs(), cl);
	}

	@Test
	void testGetSystem() {
		assertNotNull(ArtGallery.getSystem());
	}

	@Test
	void testCreateNotification() {
		assertTrue(artGallery.createNotification("Test Title", "Test Description", c), "Notification not created");
		assertEquals(artGallery.getNotifications().size(), 1);
	}

	@Test
	void testNewClient() {
		assertTrue(artGallery.newClient("Gael", "Ankaoua", "55450352C", Gender.MALE, LocalDate.of(2004, 12, 12), "123456789Hola"));
		assertEquals(artGallery.getClients().size(), 1);
		assertEquals(artGallery.getUsers().size(), 2);
	}

	@Test
	void testNewStaffStringStringStringGenderLocalDate() {
		artGallery.newStaff("Jorge", "Garcia", "13467925H", Gender.MALE, LocalDate.of(2004, 3, 3));
		assertEquals(artGallery.getStaffs().size(), 1);
		assertEquals(artGallery.getUsers().size(), 1);
	}

	@Test
	void testNewStaffStaff() {
		artGallery.newStaff(s);
		assertEquals(artGallery.getStaffs().size(), 1);
		assertEquals(artGallery.getUsers().size(), 1);
	}

	@Test
	void testNewAdmin() {
		artGallery.newAdmin("Gael", "Ankaoua", "55450352C", Gender.MALE, LocalDate.of(2004, 12, 12), "123456789Hola");
		assertEquals(artGallery.getUsers().size(), 1);
	}

	@Test
	void testIsPwdValid() {
		String valid = "Hola1234", noLow = "HOLA1234", noUpp = "hola1234", noNum = "holahola";
		assertTrue(artGallery.isPwdValid(valid));
		assertFalse(artGallery.isPwdValid(noLow));
		assertFalse(artGallery.isPwdValid(noUpp));
		assertFalse(artGallery.isPwdValid(noNum));
	}

	@Test
	void testCreatePainting() {
		artGallery.createPainting("Mona Lisa", "Leonardo da Vinci", false, 20, 77, 0, 53, 50);
        assertEquals(artGallery.getInventory().getWorks().size(), 3, "Painting not created");
	}

	@Test
	void testCreateSculpture() {
        artGallery.createSculpture("The Thinker", "Auguste Rodin", false, 0, 98, 145, 186, 50, "Bronze", "Chisel");
        assertEquals(artGallery.getInventory().getWorks().size(), 4, "Sculpture not created");
    }

	@Test
	void testCreateVideo() {
        artGallery.createVideo("Test Video", "John Doe", true, 0, 1920, 1080, 0, 50, true, "MP4", 1080);
        assertEquals(artGallery.getInventory().getWorks().size(), 2, "Video not created");
	}

	@Test
	void testCreatePhoto() {
        artGallery.createPhoto("Test Photo", "John Doe", true, 0, 4000, 3000, 0, 50, true, "JPEG", 300);
        assertEquals(artGallery.getInventory().getWorks().size(), 1, "Photo not created");
	}

	@Test
	void testCreateExhibitionStringStringLocalDateTimeLocalDateTime() {
        assertTrue(artGallery.createExhibition("Test Exhibitio", "Test Author", LocalDateTime.now(), LocalDateTime.now().plusDays(10)));
        assertEquals(artGallery.getExhibitions().size(), 1);
	}

	@Test
	void testCreateExhibitionExhibition() {
		Exhibition e = new Exhibition("Test Exhibition", "Test Author", LocalDateTime.now(), LocalDateTime.now().plusDays(10));
		assertTrue(artGallery.createExhibition(e));
        assertEquals(artGallery.getExhibitions().size(), 1);
	}

	@Test
	void testSearchExhibition() {
		Exhibition e = new Exhibition("Test Exhibition", "Test Author", LocalDateTime.now(), LocalDateTime.now().plusDays(10));
		artGallery.createExhibition(e);
		assertEquals(artGallery.searchExhibition("Test Exhibition"), e);
	}

	@Test
	void testGetUserFromNif() {
		artGallery.newStaff(s);
		assertEquals(artGallery.getUserFromNif(s.getNif()), s);
	}

	@Test
	void testDeleteUser() {
		artGallery.newStaff(s);
		assertEquals(artGallery.getStaffs().size(), 1);
		assertEquals(artGallery.getUsers().size(), 1);
		artGallery.deleteUser(s);
		assertEquals(artGallery.getStaffs().size(), 0);
		assertEquals(artGallery.getUsers().size(), 0);
	}

	@Test
	void testRemoveExhibition() {
		Exhibition e = new Exhibition("Test Exhibition", "Test Author", LocalDateTime.now(), LocalDateTime.now().plusDays(10));
		artGallery.createExhibition(e);
		assertEquals(artGallery.getExhibitions().size(), 1);
		artGallery.removeExhibition(e);
		assertEquals(artGallery.getExhibitions().size(), 0);
	}

	@Test
	void testCreateSalaFisica() {
		artGallery.createSalaFisica(true, 30, 15, 10, 5, 20, 50);
		assertEquals(artGallery.getExhibitions().size(), 1);
	}

}
