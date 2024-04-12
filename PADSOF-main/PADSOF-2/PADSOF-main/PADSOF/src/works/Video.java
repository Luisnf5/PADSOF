/**
 * The Video class represents a video work with its properties and status.
 * It extends the AudioVisual class and implements Serializable.
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;

public class Video extends AudioVisual implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a Video object with specified parameters.
     * 
     * @param title the title of the video
     * @param author the author of the video
     * @param elctricity indicates if the video requires electricity
     * @param temperature the temperature conditions suitable for the video
     * @param width the width of the video
     * @param lenght the length of the video
     * @param height the height of the video
     * @param humidity the humidity conditions suitable for the video
     * @param color indicates if the video is in color
     * @param format the format of the video
     * @param resolution the resolution of the video
     */
    public Video(String title, String author, Boolean elctricity, double temperature, double width, double lenght, double height, double humidity, Boolean color, String format, int resolution) {
        super(title, author, elctricity, temperature, width, lenght, height, humidity, color, format, resolution);
        this.setStatus(Status.INVENTORY);
    }  
}
