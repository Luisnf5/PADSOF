package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubroomTest {

    @Test
    public void testSubroomCreation() {
        int roomID = 456;
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;

        Subroom subroom = new Subroom(roomID, electricity, temperature, width, length, height, humidity);

        assertNotNull(subroom);
        assertEquals(roomID, subroom.getRoomID());
        assertTrue(subroom.isElectricity());
        assertEquals(temperature, subroom.isTemperature(), 0.01);
        assertEquals(width, subroom.getWidth(), 0.01);
        assertEquals(length, subroom.getLength(), 0.01);
        assertEquals(height, subroom.getHeihgt(), 0.01);
        assertEquals(humidity, subroom.getHumidity(), 0.01);
    }

    @Test
    public void testSubroomTemperatureChange() {
        int roomID = 456;
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;

        Subroom subroom = new Subroom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(temperature, subroom.isTemperature(), 0.01);

        double newTemperature = 25.0;
        subroom.setTemperature(newTemperature);

        assertEquals(newTemperature, subroom.isTemperature(), 0.01);
    }

    @Test
    public void testSubroomWidthChange() {
        int roomID = 456;
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;

        Subroom subroom = new Subroom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(width, subroom.getWidth(), 0.01);

        double newWidth = 10.0;
        subroom.setWidth(newWidth);

        assertEquals(newWidth, subroom.getWidth(), 0.01);
    }

    @Test
    public void testSubroomLengthChange() {
        int roomID = 456;
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;

        Subroom subroom = new Subroom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(length, subroom.getLength(), 0.01);

        double newLength = 8.0;
        subroom.setLength(newLength);

        assertEquals(newLength, subroom.getLength(), 0.01);
    }

    @Test
    public void testSubroomHeightChange() {
        int roomID = 456;
        boolean electricity = true;
        double temperature = 20.0;
        double width = 5.0;
        double length = 6.0;
        double height = 3.0;
        double humidity = 50.0;

        Subroom subroom = new Subroom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(height, subroom.getHeihgt(), 0.01);

        double newHeight = 4.0;
        subroom.setHeihgt(newHeight);

        assertEquals(newHeight, subroom.getHeihgt(), 0.01);
    }
}
