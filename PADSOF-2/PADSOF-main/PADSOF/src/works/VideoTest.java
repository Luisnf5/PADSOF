package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class VideoTest {

    @Test
    public void testVideoCreation() {
        String title = "The Matrix";
        String author = "The Wachowskis";
        boolean electricity = true;
        boolean temperature = false;
        double width = 1920.0;
        double length = 1080.0;
        double height = 0.0;
        double humidity = 0.0;
        boolean color = true;
        String format = "MP4";
        int resolution = 1080;

        Video video = new Video(title, author, electricity, temperature, width, length, height, humidity, color, format, resolution);

        assertNotNull(video);
        assertEquals(title, video.getTitle());
        assertEquals(author, video.getAuthor());
        assertTrue(video.getElectricity());
        assertFalse(video.getTemperature());
        assertEquals(width, video.getWidth(), 0.01);
        assertEquals(length, video.getLenght(), 0.01);
        assertEquals(height, video.getHeight(), 0.01);
        assertEquals(humidity, video.getHumidity(), 0.01);
        assertTrue(video.getColor());
        assertEquals(format, video.getFormat());
        assertEquals(resolution, video.getResolution());
        assertEquals(WorkStatus.INVENTORY, video.getSta());
    }
}

