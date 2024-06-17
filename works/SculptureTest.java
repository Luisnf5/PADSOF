package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SculptureTest {

    @Test
    public void testSculptureCreation() {
        String title = "David";
        String author = "Michelangelo";
        boolean electricity = false;
        double temperature = 20;
        double width = 100.0;
        double length = 150.0;
        double height = 200.0;
        double humidity = 30.0;
        String material = "Mármol";
        String tool = "Cincel";

        Sculpture sculpture = new Sculpture(title, author, electricity, temperature, width, length, height, humidity, material, tool);

        assertNotNull(sculpture);
        assertEquals(title, sculpture.getTitle());
        assertEquals(author, sculpture.getAuthor());
        assertFalse(sculpture.getElctricity());
        assertEquals(temperature, sculpture.getTemperature(), 0.01);
        assertEquals(width, sculpture.getWidth(), 0.01);
        assertEquals(length, sculpture.getLenght(), 0.01);
        assertEquals(height, sculpture.getHeight(), 0.01);
        assertEquals(humidity, sculpture.getHumidity(), 0.01);
        assertEquals(material, sculpture.getMaterial());
        assertEquals(tool, sculpture.getTool());
        assertEquals(Status.INVENTORY, sculpture.getSta());
    }
}
