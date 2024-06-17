package works;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import users.Client;
import users.Gender;

class TicketTest {

	@Test
	void testTicketLocalDateTimeDoubleClientExhibition() {
		LocalDateTime hour = LocalDateTime.now();
		double price = 10;
		Client client = new Client("John", "Doe", "55450352C", Gender.MALE, LocalDate.now(), "password");
		Exhibition exhibition = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 12, 12, 20, 0));
		
		Ticket t = new Ticket(hour, price, client, exhibition);
		
		assertEquals(hour, t.getHour());
		assertEquals(price, t.getPrice());
		assertEquals(client, t.getClient());
		assertEquals(exhibition, t.getExhibition());
	}

	@Test
	void testTicketLocalDateTimeClient() {
		LocalDateTime hour = LocalDateTime.now();
		Client client = new Client("John", "Doe", "55450352C", Gender.MALE, LocalDate.now(), "password");
		
		Ticket t = new Ticket(hour, client);
		
		assertEquals(hour, t.getHour());
		assertEquals(0, t.getPrice());
		assertEquals(client, t.getClient());
	}

}
