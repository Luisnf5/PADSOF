package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class PhotoTest {

    @Test
    public void testPhotoCreation() {
        String title = "Sunset";
        String author = "John Doe";
        boolean electricity = true;
        boolean temperature = false;
        double width = 800.0;
        double length = 600.0;
        double height = 0.0;
        double humidity = 0.0;
        boolean color = true;
        String format = "JPEG";
        int resolution = 300;

        Photo photo = new Photo(title, author, electricity, temperature, width, length, height, humidity, color, format, resolution);

        assertNotNull(photo);
        assertEquals(title, photo.getTitle());
        assertEquals(author, photo.getAuthor());
        assertTrue(photo.getElectricity());
        assertFalse(photo.getTemperature());
        assertEquals(width, photo.getWidth(), 0.01);
        assertEquals(length, photo.getLenght(), 0.01);
        assertEquals(height, photo.getHeight(), 0.01);
        assertEquals(humidity, photo.getHumidity(), 0.01);
        assertTrue(photo.getColor());
        assertEquals(format, photo.getFormat());
        assertEquals(resolution, photo.getResolution());
        assertEquals(WorkStatus.INVENTORY, photo.getSta());
    }

    @Test
    public void testPhotoStatusChange() {
        String title = "Sunset";
        String author = "John Doe";
        boolean electricity = true;
        boolean temperature = false;
        double width = 800.0;
        double length = 600.0;
        double height = 0.0;
        double humidity = 0.0;
        boolean color = true;
        String format = "JPEG";
        int resolution = 300;

        Photo photo = new Photo(title, author, electricity, temperature, width, length, height, humidity, color, format, resolution);

        assertEquals(WorkStatus.INVENTORY, photo.getSta());

        photo.repairWork();

        assertEquals(WorkStatus.RESTORATION, photo.getSta());
    }
}

