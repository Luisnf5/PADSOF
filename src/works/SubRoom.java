/**
 * The SubRoom class represents a subroom within a larger room.
 * It extends the Room class and implements Serializable.
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;

public class SubRoom extends Room implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a SubRoom object with specified parameters.
     * 
     * @param roomID the ID of the subroom
     * @param electricity indicates if the subroom has electricity
     * @param temperature the temperature conditions of the subroom
     * @param width the width of the subroom
     * @param length the length of the subroom
     * @param height the height of the subroom
     * @param humidity the humidity conditions of the subroom
     */
    public SubRoom(int roomID, boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(roomID, electricity, temperature, width, length, height, humidity, capacity);
    }
}
