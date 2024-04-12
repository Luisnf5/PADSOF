package system;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import users.*;
import works.*;

class ArtGalleryTest {
	private ArtGallery artGallery;
	
	@BeforeEach
    void setUp() {
        artGallery = ArtGallery.getSystem();
    }

	@Test
	void testGetOpenTime() {
		assertEquals(LocalTime.of(10, 0), artGallery.getOpenTime(), "Opening time should be 10:00");
	}

	@Test
	void testGetCloseTime() {
		assertEquals(LocalTime.of(20, 0), artGallery.getCloseTime(), "Closing time should be 20:00");
	}

	@Test
	void testGetSystem() {
		assertFalse(ArtGallery.getSystem() == null, "System should not be null");
	}

	@Test
	void testGetLoggedUser() {
		Client client = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		artGallery.setLoggedUser(client);
		assertSame(artGallery.getLoggedUser(), client, "Logged user is not correct");
	}

	@Test
	void testCreateNotification() {
		Client client = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
        assertTrue(artGallery.createNotification("Test Title", "Test Description", client), "Notification not created");
	}

	@Test
	void testDeleteNotification() {
		Client client = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		Notification n = new Notification("Test Title", "Test Description");
		artGallery.createNotification("Test Title", "Test Description", client);
		artGallery.deleteNotification(n);
		assertFalse(artGallery.getNotifications().contains(n), "Notification not deleted");
	}

	@Test
	void testNewClient() {
		artGallery.newClient("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		assertEquals(artGallery.getUsers().size(), 1, "Client not created");
	}

	@Test
	void testNewStaff() {
		artGallery.newStaff("John", "Doe", "123456", Gender.MALE, LocalDate.now());
		assertEquals(artGallery.getUsers().size(), 1, "Staff not created");
	}

	@Test
	void testNewAdmin() {
		artGallery.newAdmin("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		assertEquals(artGallery.getUsers().size(), 1, "Admin not created");
	}

	@Test
	void testCreatePainting() {
        artGallery.createPainting("Mona Lisa", "Leonardo da Vinci", false, true, 77, 0, 53, 50, "Oil");
        assertEquals(artGallery.getInventory().getWorks().size(), 1, "Painting not created");
	}

	@Test
	void testCreateSculpture() {
        artGallery.createSculpture("The Thinker", "Auguste Rodin", false, false, 98, 145, 186, 50, "Bronze", "Chisel");
        assertEquals(artGallery.getInventory().getWorks().size(), 1, "Sculpture not created");
    }

	@Test
	void testCreateVideo() {
        artGallery.createVideo("Test Video", "John Doe", true, false, 1920, 1080, 0, 50, true, "MP4", 1080);
        assertEquals(artGallery.getInventory().getWorks().size(), 1, "Video not created");
	}

	@Test
	void testCreatePhoto() {
        artGallery.createPhoto("Test Photo", "John Doe", true, false, 4000, 3000, 0, 50, true, "JPEG", 300);
        assertEquals(artGallery.getInventory().getWorks().size(), 1, "Photo not created");
	}

	@Test
	void testCreateExhibition() {
        assertTrue(artGallery.createExhibition("Test Exhibition", "Test Author", LocalDateTime.now(), LocalDateTime.now().plusDays(10)));
	}

}
