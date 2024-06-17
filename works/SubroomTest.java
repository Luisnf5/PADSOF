package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubroomTest {

    @Test
    public void testSubroomCreation() {
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;
        int capacity = 5;

        SubRoom sr = new SubRoom(electricity, temperature, width, length, height, humidity, capacity);
        assertNotNull(sr);
        assertTrue(sr.isElectricity());
        assertEquals(temperature, sr.getTemperature(), 0.01);
        assertEquals(width, sr.getWidth(), 0.01);
        assertEquals(length, sr.getLength(), 0.01);
        assertEquals(height, sr.getHeight(), 0.01);
        assertEquals(humidity, sr.getHumidity(), 0.01);
        assertEquals(capacity, sr.getCapacity());
    }
}
