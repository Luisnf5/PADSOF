/**
 * The Photo class represents a photo work with its properties and status.
 * It extends the AudioVisual class and implements Serializable.
 * 
 * <p>Photos have attributes such as title, author, electricity requirement, temperature conditions, dimensions, color, format, and resolution.</p>
 * 
 * <p>This class provides a constructor to create a Photo object with specified parameters.</p>
 * 
 * <p>The status of the photo is set to INVENTORY by default upon creation.</p>
 * 
 * @author Javier Luis Gael
 */
package works;

import java.io.Serializable;

public class Photo extends AudioVisual implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a Photo object with specified parameters.
     * 
     * @param title the title of the photo
     * @param author the author of the photo
     * @param elctricity indicates if the photo requires electricity
     * @param temperature the temperature conditions suitable for the photo
     * @param width the width of the photo
     * @param lenght the length of the photo
     * @param height the height of the photo
     * @param humidity the humidity conditions suitable for the photo
     * @param color indicates if the photo is in color
     * @param format the format of the photo
     * @param resolution the resolution of the photo
     */
    public Photo(String title, String author, Boolean elctricity, double temperature, double width, double lenght, double height, double humidity, Boolean color, String format, int resolution) {
        super(title, author, elctricity, temperature, width, lenght, height, humidity, color, format, resolution);
        this.setStatus(Status.INVENTORY);
    }
    
}
