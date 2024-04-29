/**
 * The AudioVisual class represents an audiovisual work.
 * It extends the Work class and implements Serializable.
 * 
 * <p>An audiovisual work has properties related to color, format, and resolution.</p>
 * 
 * @author Javier Luis Gael
 */
package works;

import java.io.Serializable;

public abstract class AudioVisual extends Work implements Serializable{
    private static final long serialVersionUID = 1L;
    private Boolean color; 
    private String format; 
    private int resolution; 

    /**
     * Constructs an AudioVisual object with the specified parameters.
     * 
     * @param title the title of the audiovisual work
     * @param author the author of the audiovisual work
     * @param elctricity indicates if the audiovisual work requires electricity
     * @param temperature the temperature conditions suitable for the audiovisual work
     * @param width the width of the audiovisual work
     * @param length the length of the audiovisual work
     * @param height the height of the audiovisual work
     * @param humidity the humidity conditions suitable for the audiovisual work
     * @param color indicates if the audiovisual work is in color
     * @param format the format of the audiovisual work
     * @param resolution the resolution of the audiovisual work
     */
    public AudioVisual(String title, String author, Boolean elctricity, double temperature, double width, double length, double height, double humidity, Boolean color, String format, int resolution) {
        super(title, author, elctricity, temperature, width, length, height, humidity);
        this.color = color;
        this.format = format;
        this.resolution = resolution;
        this.setStatus(Status.INVENTORY);
    }
}
