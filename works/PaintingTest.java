package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class PaintingTest {

    @Test
    public void testPaintingCreation() {
        String title = "La Mona Lisa";
        String author = "Leonardo da Vinci";
        boolean electricity = false;
        double temperature = 30.0;
        double width = 77.0;
        double length = 53.0;
        double height = 2.0;
        double humidity = 40.0;

        Painting painting = new Painting(title, author, electricity, temperature, width, length, height, humidity);

        assertNotNull(painting);
        assertEquals(title, painting.getTitle());
        assertEquals(author, painting.getAuthor());
        assertFalse(painting.getElctricity());
        assertEquals(temperature, painting.getTemperature());
        assertEquals(temperature, painting.getTemperature());
        assertEquals(width, painting.getWidth(), 0.01);
        assertEquals(length, painting.getLenght(), 0.01);
        assertEquals(height, painting.getHeight(), 0.01);
        assertEquals(humidity, painting.getHumidity(), 0.01);
        assertEquals(Status.INVENTORY, painting.getSta());
    }

    @Test
    public void testPaintingStatusChange() {
        String title = "La Mona Lisa";
        String author = "Leonardo da Vinci";
        boolean electricity = false;
        double temperature = 20;
        double width = 77.0;
        double length = 53.0;
        double height = 2.0;
        double humidity = 40.0;

        Painting painting = new Painting(title, author, electricity, temperature, width, length, height, humidity);

        assertEquals(Status.INVENTORY, painting.getSta());

        painting.repairWork();

        assertEquals(Status.RESTORATION, painting.getSta());
    }
}

