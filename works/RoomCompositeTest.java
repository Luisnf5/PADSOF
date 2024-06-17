package works;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomCompositeTest {
	
	//electricity, temperature, width, length, height, humidity, capacity
	@Test
	void testRoomComposite() {
		boolean electricity = true;
		double temperature = 20;
		double width = 12;
		double length = 11;
		double height = 10;
		double humidity = 25;
		int capacity = 5;
		
		RoomComposite rc = new RoomComposite(electricity, temperature, width, length, height, humidity, capacity);
		
		assertTrue(rc.isElectricity());
		assertEquals(temperature, rc.getTemperature());
		assertEquals(width, rc.getWidth());
		assertEquals(length, rc.getLength());
		assertEquals(height, rc.getHeight());
		assertEquals(humidity, rc.getHumidity());
		assertEquals(capacity, rc.getCapacity());
	}

	@Test
	void testDivide() {
		SubRoom sr = new SubRoom(true, 20, 12, 10, 10, 25, 5);
		RoomComposite rc = new RoomComposite(true, 20, 12, 10, 10, 25, 5);
		rc.add(sr);
		assertTrue(rc.getChild(0) instanceof SubRoom);
		rc.divide(2, sr);
		assertTrue(rc.getChild(0) instanceof RoomComposite);
		RoomComposite rc2 = (RoomComposite)rc.getChild(0);
		assertEquals(rc2.getDaughters().size(), 2);	
	}

	@Test
	void testCollapse() {
		SubRoom sr = new SubRoom(true, 20, 12, 10, 10, 25, 5);
		RoomComposite rc = new RoomComposite(true, 20, 12, 10, 10, 25, 5);
		rc.add(sr);
		rc.divide(2, sr);
		assertTrue(rc.getChild(0) instanceof RoomComposite);
		RoomComposite rc2 = (RoomComposite)rc.getChild(0);
		rc.collapse(rc2);
		assertTrue(rc.getChild(0) instanceof SubRoom);
		assertEquals(rc.getDaughters().size(), 1);	
	}

}
