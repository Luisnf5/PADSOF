/**
 * The CompositeRoom class represents a composite room composed of multiple sub-rooms.
 * It extends the Room class and implements Serializable.
 * 
 * <p>A composite room contains a set of other rooms.</p>
 * 
 * @author Javier Gael Luis
 */
package works;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

public class CompositeRoom extends Room implements Serializable{
    private static final long serialVersionUID = 1L;
    Set<Room> otherRoom = new HashSet<>(2);
    
    /**
     * Constructs a CompositeRoom object with the specified parameters.
     * 
     * @param roomID the ID of the room
     * @param electricity indicates if the room has electricity
     * @param temperature the temperature conditions suitable for the room
     * @param width the width of the room
     * @param length the length of the room
     * @param height the height of the room
     * @param humidity the humidity conditions suitable for the room
     */
    public CompositeRoom(int roomID, boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(roomID, electricity, temperature, width, length, height, humidity, capacity);
    }
    
}
