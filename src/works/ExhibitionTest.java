package works;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import users.*;

class ExhibitionTest {
	Exhibition exhi;
	Client cli;
	
	@BeforeEach
    void setUp() {
        exhi = new Exhibition("Title", "Author", LocalDateTime.now(), LocalDateTime.of(2025, 12, 12, 20, 0));
        cli = new Client("John", "Doe", "55450352C", Gender.MALE, LocalDate.now(), "password");
        exhi.setCapacity(2);
    }
	
	@Test
	void testExhibition() {
		String t = "Title", a = "Author";
		LocalDateTime s = LocalDateTime.now(), e = LocalDateTime.of(2025, 12, 12, 20, 0);
		
		Exhibition ex = new Exhibition(t, a, s, e);
		
		assertEquals(t, ex.getTitle());
		assertEquals(a, ex.getAuthor());
		assertEquals(s, ex.getStartDate());
		assertEquals(e, ex.getEndDate());
	}

	@Test
	void testAddDiscount() {
		exhi.addDiscount(50);
		assertEquals(50, exhi.getDiscount().getDiscount());
	}

	@Test
	void testIsHourValid() {
		exhi.getTickets().put(LocalDateTime.of(2025, 12, 12, 12, 0), Set.of(new Ticket(LocalDateTime.of(2025, 7, 12, 12, 0), cli)));
		assertTrue(exhi.isHourValid(LocalDateTime.of(2025, 12, 12, 12, 0)));
	}

	@Test
	void testBuyTicket() {
		assertNull(exhi.buyTicket(cli, LocalDateTime.now()));
		exhi.publishExposition();
		assertNotNull(exhi.buyTicket(cli, exhi.getStartDate()));
		exhi.cancelExibition();
		assertNull(exhi.buyTicket(cli, LocalDateTime.now()));
	}

	@Test
	void testPublishExposition() {
		exhi.publishExposition();
		assertEquals(ExhibitionStatus.PUBLISHED, exhi.getStatus());
	}

	@Test
	void testCancelExibition() {
		exhi.publishExposition();
		exhi.cancelExibition();
		assertEquals(ExhibitionStatus.ENDING, exhi.getStatus());
	}

	@Test
	void testExtendExibition() {
		LocalDateTime time = exhi.getEndDate();
		exhi.extendExibition(exhi.getEndDate().minusDays(1));
		assertEquals(time, exhi.getEndDate());
		exhi.extendExibition(exhi.getEndDate().plusDays(1));
		assertNotEquals(time, exhi.getEndDate());
	}

	@Test
	void testShortenExhibition() {
		assertTrue(exhi.shortenExhibition(LocalDateTime.of(2025, 9, 12, 20, 0)));
		LocalDateTime time = exhi.getEndDate();
		exhi.buyTicket(cli, LocalDateTime.of(2025, 10, 12, 20, 0));
		assertFalse(exhi.shortenExhibition(LocalDateTime.of(2025, 9, 12, 20, 0)));
		//assertNotEquals(time, exhi.getEndDate());
	}

	@Test
	void testAddParticipant() {
		assertTrue(exhi.addParticipant(cli, LocalDateTime.of(2025, 9, 12, 20, 0)));
		
	}

	@Test
	void testExitRaffle() {
		exhi.createRaffle("Title", "Description", 2, LocalDateTime.now(), LocalDateTime.of(2025, 1, 12, 20, 0));
		exhi.addParticipant(cli, LocalDateTime.of(2025, 9, 12, 20, 0));
		assertTrue(exhi.getRaffle().getParticipants().containsKey(cli));
		exhi.exitRaffle(cli);
		assertFalse(exhi.getRaffle().getParticipants().containsKey(cli));
	}

	@Test
	void testCreateRaffle() {
		exhi.createRaffle("Title", "Description", 2, LocalDateTime.now(), LocalDateTime.of(2025, 1, 12, 20, 0));
		assertNotNull(exhi.getRaffle());
	}

	@Test
	void testDeleteRaffle() {
		exhi.createRaffle("Title", "Description", 2, LocalDateTime.now(), LocalDateTime.of(2025, 1, 12, 20, 0));
		exhi.deleteRaffle();
		assertNull(exhi.getRaffle());
	}

}
