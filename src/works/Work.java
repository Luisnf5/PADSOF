/**
 * The Work class represents an abstract work with its properties and status.
 * It serves as a base class for specific types of works.
 * 
 * @author Javier Gael Luis */
package works;

import java.io.Serializable;

public abstract class Work implements Serializable{
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private Boolean elctricity;
    private double temperature;
    private double width;
    private double length;
    private double height;
    private double humidity;
    private Status sta;
    private Origin origin;

    /**
     * Constructs a Work object with specified parameters.
     * 
     * @param title the title of the work
     * @param author the author of the work
     * @param elctricity indicates if the work requires electricity
     * @param temperature the temperature conditions suitable for the work
     * @param width the width of the work
     * @param lenght the length of the work
     * @param height the height of the work
     * @param humidity the humidity conditions suitable for the work
     */
    public Work(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
            double height, double humidity, Origin origin) {
        this.title = title;
        this.author = author;
        this.elctricity = elctricity;
        this.temperature = temperature;
        this.width = width;
        this.length = lenght;
        this.height = height;
        this.humidity = humidity;
        this.sta = Status.INVENTORY;
        this.origin = origin;
    }

    /**
     * Repairs the work if it is in the inventory status.
     * 
     * @return true if the work is successfully repaired, false otherwise
     */
    public boolean repairWork() {
        if(this.sta == Status.INVENTORY){
            this.sta = Status.RESTORATION;
            return true;
        }
        return false; 
    }

    /**
     * Sets the status of the work to borrowed.
     */
    public void lendWork() {
    	if(this.sta.equals(Status.INVENTORY))
    		this.sta = Status.BORROWED;
    }

    /**
     * Sets the status of the work to inventory.
     */
    public void goInventoryWork() {
        this.sta = Status.INVENTORY;
    }

    /**
     * Sets the status of the work to borrowed.
     */
    public void withdrawWork() {
        this.sta = Status.BORROWED;
    }
    
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Boolean getElctricity() {
		return elctricity;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getHumidity() {
		return humidity;
	}

	public Status getSta() {
		return sta;
	}  
    
    
}
