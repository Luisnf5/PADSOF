/**
 * The Room class represents a room with its properties.
 * It is an abstract class and implements Serializable.
 * 
 * <p>This class serves as a base for specific types of rooms.</p>
 * 
 * <p>Rooms have attributes such as room ID, electricity availability, temperature, dimensions, and humidity.</p>
 * 
 * <p>It provides methods to access and modify these attributes.</p>
 * 
 * <p>This class also contains commented-out methods for managing child rooms, such as collapsing or separating rooms.</p>
 * 
 * <p>Note: The child room management functionality is commented out and not currently in use.</p>
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private int roomID;
    private boolean electricity; 
    private double temperature; 
    private double width;
    private double length;
    private double height;
    private double humidity; 

    /**
     * Constructs a Room object with specified parameters.
     * 
     * @param roomID the ID of the room
     * @param electricity indicates if the room has electricity
     * @param temperature the temperature conditions of the room
     * @param width the width of the room
     * @param length the length of the room
     * @param height the height of the room
     * @param humidity the humidity conditions of the room
     */
    public Room(int roomID, boolean electricity, double temperature, double width, double length, double height, double humidity) { 
        super();
        this.roomID = roomID;
        this.electricity = electricity;
        this.temperature = temperature;
        this.width = width;
        this.length = length;
        this.height = height;
        this.humidity = humidity;
    }

    /**
     * Gets the temperature of the room.
     * 
     * @return the temperature of the room
     */
    public double isTemperature() {
        return temperature;
    }
    
    /**
     * Sets the temperature of the room.
     * 
     * @param temperature the temperature to be set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    /**
     * Gets the width of the room.
     * 
     * @return the width of the room
     */
    public double getWidth() {
        return width;
    }
    
    /**
     * Sets the width of the room.
     * 
     * @param width the width to be set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
    /**
     * Gets the length of the room.
     * 
     * @return the length of the room
     */
    public double getLength() {
        return length;
    }
    
    /**
     * Sets the length of the room.
     * 
     * @param length the length to be set
     */
    public void setLength(double length) {
        this.length = length;
    }
    
    /**
     * Gets the height of the room.
     * 
     * @return the height of the room
     */
    public double getHeihgt() {
        return height;
    }
    
    /**
     * Sets the height of the room.
     * 
     * @param heihgt the height to be set
     */
    public void setHeihgt(double heihgt) {
        this.height = heihgt;
    }

    /**
     * Gets the ID of the room.
     * 
     * @return the ID of the room
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * Checks if the room has electricity.
     * 
     * @return true if the room has electricity, false otherwise
     */
    public boolean isElectricity() {
        return electricity;
    }

    /**
     * Gets the temperature of the room.
     * 
     * @return the temperature of the room
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Gets the height of the room.
     * 
     * @return the height of the room
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the humidity of the room.
     * 
     * @return the humidity of the room
     */
    public double getHumidity() {
        return humidity;
    }
    
    /* 
     * The following methods are for managing child rooms.
     * 
     * public boolean isChild() {
     *     return this.childRooms.isEmpty(); 
     * }
     * 
     * public boolean colapseRoom() {
     *     if(this.childRooms.isEmpty() == true) {
     *         return false;
     *     }
     *     this.childRooms.clear();
     *     return true;
     * }
     * 
     * public boolean separate() {
     *     if(this.isChild() == true ) {
     *         Room newRoom1 = new Room(this.roomID + 1, this.electricity, this.temperature, this.width, this.length/2, this.height, this.humidity);
     *         this.childRooms.add(newRoom1);
     *         Room newRoom2 = new Room(this.roomID + 2, this.electricity, this.temperature, this.width, this.length/2, this.height, this.humidity);
     *         this.childRooms.add(newRoom2);
     *         return true;
     *     }
     *     
     *     return false; 
     * }
     */
}
