package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoomCreation() {
        int roomID = 123;
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;

        Room room = new RoomComposite(roomID, electricity, temperature, width, length, height, humidity);

        assertNotNull(room);
        assertEquals(roomID, room.getRoomID());
        assertTrue(room.isElectricity());
        assertEquals(temperature, room.isTemperature(), 0.01);
        assertEquals(width, room.getWidth(), 0.01);
        assertEquals(length, room.getLength(), 0.01);
        assertEquals(height, room.getHeihgt(), 0.01);
        assertEquals(humidity, room.getHumidity(), 0.01);
    }

    @Test
    public void testRoomTemperatureChange() {
        int roomID = 123;
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;

        Room room = new RoomComposite(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(temperature, room.isTemperature(), 0.01);

        double newTemperature = 20.0;
        room.setTemperature(newTemperature);

        assertEquals(newTemperature, room.isTemperature(), 0.01);
    }

    @Test
    public void testRoomWidthChange() {
        int roomID = 123;
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;

        Room room = new RoomComposite(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(width, room.getWidth(), 0.01);

        double newWidth = 15.0;
        room.setWidth(newWidth);

        assertEquals(newWidth, room.getWidth(), 0.01);
    }

    @Test
    public void testRoomLengthChange() {
        int roomID = 123;
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;

        Room room = new RoomComposite(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(length, room.getLength(), 0.01);

        double newLength = 14.0;
        room.setLength(newLength);

        assertEquals(newLength, room.getLength(), 0.01);
    }

    @Test
    public void testRoomHeightChange() {
        int roomID = 123;
        boolean electricity = true;
        double temperature = 25.0;
        double width = 10.0;
        double length = 12.0;
        double height = 8.0;
        double humidity = 40.0;

        Room room = new RoomComposite(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(height, room.getHeihgt(), 0.01);

        double newHeight = 6.0;
        room.setHeihgt(newHeight);

        assertEquals(newHeight, room.getHeihgt(), 0.01);
    }
}

