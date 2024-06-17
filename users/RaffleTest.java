package users;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import users.*;
import works.*;

class RaffleTest {
	Raffle raffle;
	
	@BeforeEach
    void setUp() {
		Exhibition ex = new Exhibition("Title", "Description", LocalDateTime.now(), LocalDateTime.of(2025, 2, 5, 20, 0));
        raffle = new Raffle("Title", "Description", 1, LocalDateTime.now(), LocalDateTime.of(2025, 2, 5, 20, 0), ex);
    }
	
	@Test
	void testRaffle() {
		Exhibition ex = new Exhibition("Title", "Description", LocalDateTime.now(), LocalDateTime.of(2025, 2, 5, 20, 0));
		String t = "Title";
		String d = "Description";
		LocalDateTime s = LocalDateTime.now();
		LocalDateTime e = LocalDateTime.of(2025, 2, 5, 20, 0);
		int max = 1;
		Raffle raff = new Raffle(t, d, max, s, e, ex);
		
		assertEquals(raff.getTitle(), t);
		assertEquals(raff.getDescription(), d);
		assertEquals(raff.getNumWinners(), max);
		assertEquals(raff.getStartDate(), s);
		assertEquals(raff.getEndDate(), e);
		assertEquals(raff.getExhibition(), ex);
	}

	@Test
	void testGetWinners() {
		Client cl = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		Client cl2 = new Client("Johnb", "Doeb", "234567", Gender.FEMALE, LocalDate.now(), "password2");
		raffle.addParticipant(cl, LocalDateTime.now());
		raffle.addParticipant(cl2, LocalDateTime.now());
		assertTrue(raffle.getWinners().size() == 1, "Wrong winners number");
	}

	@Test
	void testGetTicketsToWinners() {
		Client cl = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		Client cl2 = new Client("Johnb", "Doeb", "234567", Gender.FEMALE, LocalDate.now(), "password2");
		ArrayList<Client> arr = new ArrayList<>();
		arr.add(cl2);
		raffle.getTicketsToWinners(arr);
		assertTrue(cl2.getNumTickets() != 0 && cl.getNumTickets() == 0, "Tickets wrongly sent");
	}

	@Test
	void testAddParticipant() {
		Client cl = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		Client cl2 = new Client("Johnb", "Doeb", "234567", Gender.FEMALE, LocalDate.now(), "password2");
		raffle.addParticipant(cl, LocalDateTime.now());
		assertTrue(raffle.getParticipants().size() == 1, "First participant not aded");
		raffle.addParticipant(cl2, LocalDateTime.now());
		assertTrue(raffle.getParticipants().size() == 2, "Second participant not aded");
	}

	@Test
	void testEliminateParticipant() {
		Client cl = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
		Client cl2 = new Client("Johnb", "Doeb", "234567", Gender.FEMALE, LocalDate.now(), "password2");
		raffle.addParticipant(cl, LocalDateTime.now());
		raffle.addParticipant(cl2, LocalDateTime.now());
		raffle.eliminateParticipant(cl2);
		assertTrue(raffle.getParticipants().size() == 1, "First participant not eliminated");
		raffle.eliminateParticipant(cl);
		assertTrue(raffle.getParticipants().size() == 0, "Second participant not eliminated");
		
	}

}
