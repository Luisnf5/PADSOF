 package activities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import users.Client;
import users.Gender;
import works.Exhibition;
import works.SubRoom;

class ActivityTest {
	Activity act;
	@BeforeEach
    void setUp() {
		String name = "Futbol";
		ActivityType type = ActivityType.CONFERENCIA;
		String description = "Partido de futbol";
		int maxParticipants = 2;
		LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0));
		SubRoom room = new SubRoom(true, 20, 15, 25, 30, 13, 15);
		
		act = new Activity(name, type, description, maxParticipants, date, room);
    }

	@Test
	void testActivity() {
		String name = "Futbol";
		ActivityType type = ActivityType.CONFERENCIA;
		String description = "Partido de futbol";
		int maxParticipants = 10;
		LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 0));
		SubRoom room = new SubRoom(true, 20, 15, 25, 30, 13, 15);
		
		
		Activity a = new Activity(name, type, description, maxParticipants, date, room);
		
		assertEquals(a.getName(), name, "Name");
		assertEquals(a.getType(), type, "Type");
		assertEquals(a.getDescription(), description, "Description");
		assertEquals(a.getMaxParticipants(), maxParticipants, "MaxParticipants");
		assertEquals(a.getDate(), date, "Date");
		assertEquals(a.getRoom(), room, "Room");
		
		maxParticipants = room.getCapacity() + 5;
		
		a = new Activity(name, type, description, maxParticipants, date, room);
		
		assertNotEquals(a.getMaxParticipants(), maxParticipants);
		assertEquals(a.getMaxParticipants(), room.getCapacity());
	}

	@Test
	void testEnroll() {
		assertTrue(act.enroll("55450352C"));
		assertFalse(act.enroll("55450352C"));
		assertTrue(act.enroll("44349241B"));
		assertFalse(act.enroll("33238130A"));
	}

}
