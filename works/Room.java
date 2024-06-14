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
    static int cont = 1;
    private int roomID;
    private boolean electricity; 
    private double temperature; 
    private double width;
    private double length;
    private double height;
    private double humidity;
    protected int capacity;
    private boolean divided;

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
    public Room(boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity) { 
        super();
        this.roomID = cont;
        cont++;
        this.electricity = electricity;
        this.temperature = temperature;
        this.width = width;
        this.length = length;
        this.height = height;
        this.humidity = humidity;
        this.capacity = capacity;
        this.divided = false;
    }
        
    public void add(Room room) {
    	throw new UnsupportedOperationException();
    }
    
    public void remove(Room room) {
    	throw new UnsupportedOperationException();
    }
    
    public Room getChild(int index) {
    	throw new UnsupportedOperationException();
    }
    
    public int getCapacity() {
		return capacity;
	}
    
    public boolean getDivided() {
    	return this.divided;
    }
    
    public void setDivided(boolean divided) {
    	this.divided = divided;
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
     * Gets the length of the room.
     * 
     * @return the length of the room
     */
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
    	this.length = length;
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
