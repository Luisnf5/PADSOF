/**
 * The Painting class represents a painting work with its properties and status.
 * It extends the Work class and implements Serializable.
 * 
 * <p>Paintings have attributes such as title, author, electricity requirement, temperature conditions, dimensions, humidity, and painting technique.</p>
 * 
 * <p>This class provides a constructor to create a Painting object with specified parameters.</p>
 * 
 * <p>The status of the painting is set to INVENTORY by default upon creation.</p>
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;

public class Painting extends Work implements Serializable{
    private static final long serialVersionUID = 1L;
    String technique;
    
    /**
     * Constructs a Painting object with specified parameters.
     * 
     * @param title the title of the painting
     * @param author the author of the painting
     * @param elctricity indicates if the painting requires electricity
     * @param temperature the temperature conditions suitable for the painting
     * @param width the width of the painting
     * @param lenght the length of the painting
     * @param height the height of the painting
     * @param humidity the humidity conditions suitable for the painting
     * @param technique the technique used for the painting
     */
    public Painting(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
            double height, double humidity, String technique) {
        super(title, author, elctricity, temperature, width, lenght, height, humidity);
        this.technique = technique;
        this.setStatus(Status.INVENTORY);
    }
}
