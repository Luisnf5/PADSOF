package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomCompositeTest {

    @Test
    public void testRoomCompositeCreation() {
        int roomID = 987;
        boolean electricity = true;
        double temperature = 22.0;
        double width = 12.0;
        double length = 15.0;
        double height = 8.0;
        double humidity = 60.0;

        CompositeRoom roomComposite = new CompositeRoom(roomID, electricity, temperature, width, length, height, humidity);

        assertNotNull(roomComposite);
        assertEquals(roomID, roomComposite.getRoomID());
        assertTrue(roomComposite.isElectricity());
        assertEquals(temperature, roomComposite.isTemperature(), 0.01);
        assertEquals(width, roomComposite.getWidth(), 0.01);
        assertEquals(length, roomComposite.getLength(), 0.01);
        assertEquals(height, roomComposite.getHeihgt(), 0.01);
        assertEquals(humidity, roomComposite.getHumidity(), 0.01);
    }

    @Test
    public void testRoomCompositeTemperatureChange() {
        int roomID = 987;
        boolean electricity = true;
        double temperature = 22.0;
        double width = 12.0;
        double length = 15.0;
        double height = 8.0;
        double humidity = 60.0;

        CompositeRoom roomComposite = new CompositeRoom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(temperature, roomComposite.isTemperature(), 0.01);

        double newTemperature = 20.0;
        roomComposite.setTemperature(newTemperature);

        assertEquals(newTemperature, roomComposite.isTemperature(), 0.01);
    }

    @Test
    public void testRoomCompositeWidthChange() {
        int roomID = 987;
        boolean electricity = true;
        double temperature = 22.0;
        double width = 12.0;
        double length = 15.0;
        double height = 8.0;
        double humidity = 60.0;

        CompositeRoom roomComposite = new CompositeRoom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(width, roomComposite.getWidth(), 0.01);

        double newWidth = 10.0;
        roomComposite.setWidth(newWidth);

        assertEquals(newWidth, roomComposite.getWidth(), 0.01);
    }

    @Test
    public void testRoomCompositeLengthChange() {
        int roomID = 987;
        boolean electricity = true;
        double temperature = 22.0;
        double width = 12.0;
        double length = 15.0;
        double height = 8.0;
        double humidity = 60.0;

        CompositeRoom roomComposite = new CompositeRoom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(length, roomComposite.getLength(), 0.01);

        double newLength = 18.0;
        roomComposite.setLength(newLength);

        assertEquals(newLength, roomComposite.getLength(), 0.01);
    }

    @Test
    public void testRoomCompositeHeightChange() {
        int roomID = 987;
        boolean electricity = true;
        double temperature = 22.0;
        double width = 12.0;
        double length = 15.0;
        double height = 8.0;
        double humidity = 60.0;

        CompositeRoom roomComposite = new CompositeRoom(roomID, electricity, temperature, width, length, height, humidity);

        assertEquals(height, roomComposite.getHeihgt(), 0.01);

        double newHeight = 10.0;
        roomComposite.setHeihgt(newHeight);

        assertEquals(newHeight, roomComposite.getHeihgt(), 0.01);
    }
}
