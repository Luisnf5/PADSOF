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
    private double lenght;
    private double height;
    private double humidity;
    private Status sta;
    private SubroomExhibition subRoomExhibition;

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
            double height, double humidity) {
        this.title = title;
        this.author = author;
        this.elctricity = elctricity;
        this.temperature = temperature;
        this.width = width;
        this.lenght = lenght;
        this.height = height;
        this.humidity = humidity;
        this.sta = Status.INVENTORY;
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
    public void lentWork() {
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

    /**
     * Sets the status of the work to the specified status.
     * 
     * @param sta the status to be set
     */
    public void setStatus(Status sta){
        this.sta = sta;
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

	public double getLenght() {
		return lenght;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setElctricity(Boolean elctricity) {
		this.elctricity = elctricity;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setSta(Status sta) {
		this.sta = sta;
	}

	public SubroomExhibition getSubRoomExhibition() {
		return subRoomExhibition;
	}

	public void setSubRoomExhibition(SubroomExhibition subRoomExhibition) {
		this.subRoomExhibition = subRoomExhibition;
	}  
    
    
}
