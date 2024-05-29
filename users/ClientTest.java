package users;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import works.*;

class ClientTest {
	Client client;
	Exhibition exh;
	@BeforeEach
    void setUp() {
        client = new Client("John", "Doe", "123456", Gender.MALE, LocalDate.now(), "password");
        exh = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 12, 12, 20, 0));
    }

	@Test
	void testClient() {
		String name = "John";
		String surname = "Doe";
		String nif = "123456";
		Gender gender = Gender.MALE;
		LocalDate bDay = LocalDate.now();
		String pwd = "password";
		
		Client c = new Client(name, surname, nif, gender, bDay, pwd);
		
		assertEquals(c.getName(), name, "Name not equals");
		assertEquals(c.getSurname(), surname, "Surname not equals");
		assertEquals(c.getNif(), nif, "Nif not equals");
		assertEquals(c.getGender(), gender, "Gender not equals");
		assertEquals(c.getBirthDate(), bDay, "BirthDate not equals");
		assertEquals(c.getPassword(), pwd, "Password not equals");
	}

	@Test
	void testEnableNotifications() {
		client.enableNotifications();
		assertEquals(client.getNotificationEnable(), true);
	}

	@Test
	void testDisableNotifications() {
		client.disableNotifications();
		assertEquals(client.getNotificationEnable(), false);
	}

	@Test
	void testAddTickets() {
		Ticket ticket1 = new Ticket(LocalDateTime.now(), 12.5, client, exh);
		Ticket ticket2 = new Ticket(LocalDateTime.now(), 20, client, exh);
		client.addTickets(ticket1, ticket2);
		assertEquals(client.getNumTickets(), 2, "Tickets not added");
	}

	/*@Test
    void testBuyTickets() {
        int initialNumTickets = client.getNumTickets();
        LocalDateTime date = LocalDateTime.now();
        Exhibition exhibition = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 10, 13, 10, 0));

        client.buyTickets(exhibition, date);

        assertEquals(initialNumTickets + 1, client.getNumTickets(), "Number of tickets should increase by 1");
        assertTrue(client.getTickets().stream().anyMatch(ticket -> ticket.getExhibition().equals(exhibition) && ticket.getHour().equals(date)), "Ticket for the correct exhibition and date should be added");
    }*/

	@Test
	void testParticipateRaffle() {
        Exhibition exhibition = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 10, 13, 10, 0));
        assertTrue(client.participateRaffle(exhibition, LocalDateTime.now()));
	}

	@Test
	void testExitRaffle() {
        Exhibition exhibition = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 10, 13, 10, 0));
        client.participateRaffle(exhibition, LocalDateTime.now());
        int size = exhibition.getRaffle().getParticipants().size();
        client.exitRaffle(exhibition);
        assertEquals(size - 1, exhibition.getRaffle().getParticipants().size(), "Participant should be eliminated from the raffle");
	}

	@Test
	void testAddNotification() {
		Notification noti = new Notification("Title", "Description");
		if(client.addNotification(noti)) {
			assertTrue(client.getNotifications().contains(noti), "Notification not added");
		}else {
			assertTrue(client.getNotificationEnable() == false, "Notification shoul be added");
		}
	}

}
