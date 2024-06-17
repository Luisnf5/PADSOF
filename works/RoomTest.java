package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoom() {
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;
        int capacity = 5;

        Room room = new RoomComposite(electricity, temperature, width, length, height, humidity, capacity);

        assertNotNull(room);
        assertTrue(room.isElectricity());
        assertEquals(temperature, room.getTemperature(), 0.01);
        assertEquals(width, room.getWidth(), 0.01);
        assertEquals(length, room.getLength(), 0.01);
        assertEquals(height, room.getHeight(), 0.01);
        assertEquals(humidity, room.getHumidity(), 0.01);
        assertEquals(capacity, room.getCapacity());
    }
    
    
}

