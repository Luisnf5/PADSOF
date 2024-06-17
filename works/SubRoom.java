/**
 * The SubRoom class represents a subroom within a larger room.
 * It extends the Room class and implements Serializable.
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import activities.Activity;

public class SubRoom extends Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private SubroomExhibition srb = null;
    private Activity act = null;

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
    public SubRoom(boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(electricity, temperature, width, length, height, humidity, capacity);
    }

	@Override
	public Collection<? extends SubRoom> getSubRooms() {
		Set<SubRoom> sbr = new LinkedHashSet<>();
		System.out.println("getSubRooms llamada desde " + this.getName());
		sbr.add(this);
		return sbr;
		
	}

	public String getName() {
		return "Sala " + this.getRoomID();
	}

	public SubroomExhibition getSrb() {
		return srb;
	}

	public void setSrb(SubroomExhibition srb) {
		this.srb = srb;
	}

	@Override
	public boolean isExposing() {
		if (srb == null) {
			return false;
		}else if (srb.getExpo() == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isDivisible() {
		if(this.isExposing()) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean isColapsable() {
		if (this.getParent().getParent() == null) {
			System.out.println("PRIMER NIVEL");
			return false;
		}else if(this.getParent().isExposing()) {
			System.out.println("EXPOSING");
			return false;
		}else {
			return true;
		}
	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}
	
	public boolean isActiviting() {
		if (this.act == null) {
			return false;
		}
		
		return true;
	}
}