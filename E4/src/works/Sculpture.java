/**
 * The Sculpture class represents a sculpture work with its properties and status.
 * It extends the Work class and implements Serializable.
 * 
 * @author Javier Luis Gael
 */
package works;

import java.io.Serializable;

public class Sculpture extends Work implements Serializable{
    private static final long serialVersionUID = 1L;
    private String material; 
    private String tool;

    /**
     * Constructs a Sculpture object with specified parameters.
     * 
     * @param title the title of the sculpture
     * @param author the author of the sculpture
     * @param elctricity indicates if the sculpture requires electricity
     * @param temperature the temperature conditions suitable for the sculpture
     * @param width the width of the sculpture
     * @param lenght the length of the sculpture
     * @param height the height of the sculpture
     * @param humidity the humidity conditions suitable for the sculpture
     * @param material the material used for the sculpture
     * @param tool the tool used for the sculpture
     */
    public Sculpture(String title, String author, Boolean elctricity, double temperature, double width, double lenght, double height, double humidity, String material, String tool) {
        super(title, author, elctricity, temperature, width, lenght, height, humidity);
        this.material = material;
        this.tool = tool;
        this.setStatus(Status.INVENTORY);
    }

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}  
}
