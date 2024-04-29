package users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NotificationTest {

	@Test
	void testNotification() {
		String t = "Title";
		String d = "Description";
		
		Notification noti = new Notification(t, d);
		
		assertEquals(t, noti.getTitle(), "Title is incorrect");
		assertEquals(d, noti.getDescription(), "Description is incorrect");
	}
}
