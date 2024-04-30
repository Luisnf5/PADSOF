package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SculptureTest {

    @Test
    public void testSculptureCreation() {
        String title = "David";
        String author = "Michelangelo";
        boolean electricity = false;
        boolean temperature = false;
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
        assertFalse(sculpture.getElectricity());
        assertFalse(sculpture.getTemperature());
        assertEquals(width, sculpture.getWidth(), 0.01);
        assertEquals(length, sculpture.getLenght(), 0.01);
        assertEquals(height, sculpture.getHeight(), 0.01);
        assertEquals(humidity, sculpture.getHumidity(), 0.01);
        assertEquals(material, sculpture.getMaterial());
        assertEquals(tool, sculpture.getTool());
        assertEquals(WorkStatus.INVENTORY, sculpture.getSta());
    }

    @Test
    public void testSculptureMaterialChange() {
        String title = "David";
        String author = "Michelangelo";
        boolean electricity = false;
        boolean temperature = false;
        double width = 100.0;
        double length = 150.0;
        double height = 200.0;
        double humidity = 30.0;
        String material = "Mármol";
        String tool = "Cincel";

        Sculpture sculpture = new Sculpture(title, author, electricity, temperature, width, length, height, humidity, material, tool);

        assertEquals(material, sculpture.getMaterial());

        String newMaterial = "Bronce";
        sculpture.setMaterial(newMaterial);

        assertEquals(newMaterial, sculpture.getMaterial());
    }

    @Test
    public void testSculptureToolChange() {
        String title = "David";
        String author = "Michelangelo";
        boolean electricity = false;
        boolean temperature = false;
        double width = 100.0;
        double length = 150.0;
        double height = 200.0;
        double humidity = 30.0;
        String material = "Mármol";
        String tool = "Cincel";

        Sculpture sculpture = new Sculpture(title, author, electricity, temperature, width, length, height, humidity, material, tool);

        assertEquals(tool, sculpture.getTool());

        String newTool = "Martillo";
        sculpture.setTool(newTool);

        assertEquals(newTool, sculpture.getTool());
    }
}
