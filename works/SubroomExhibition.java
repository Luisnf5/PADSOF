/**
 * The SubroomExhibition class represents an exhibition within a subroom.
 * It implements Serializable.
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class SubroomExhibition implements Serializable{
    private static final long serialVersionUID = 1L;
    private Set<Work> worksIn = new LinkedHashSet<Work>();
    private SubRoom salaHija;
    private Exhibition expo;
    
    /**
     * Constructs a SubroomExhibition object with specified parameters.
     * 
     * @param salaHija the subroom associated with the exhibition
     */
    public SubroomExhibition(SubRoom salaHija){
        super();
        this.salaHija = salaHija;
    }

    /**
     * Adds works to the exhibition.
     * 
     * @param works the works to be added
     */
    public void addWorks(Work...works){
        for(Work w : works){
        	if (w.getSta() == Status.INVENTORY) {
        		this.worksIn.add(w);
                w.setSubRoomExhibition(this);
                w.setSta(Status.EXHIBITED);
        	}
            
        }   
    }
    
    public void removeWork (String name) {
    	for (Work w : worksIn) {
    		if (w.getTitle().equals(name)) {
    			worksIn.remove(w);
    			w.setSta(Status.INVENTORY);
    			w.setSubRoomExhibition(null);
    		}
    	}
    }

    /**
     * Sets the status of all works in the exhibition. 
     * 
     * @param st the status to be set
     */
    public void setWorkStatus(Status st){
        for (Work w : this.worksIn){
            w.setStatus(st);
        }
    }
    
    /**
     * Gets the works in the exhibition.
     * 
     * @return the set of works in the exhibition
     */
    public Set<Work> getWorks(){
        return this.worksIn;
    }
    
    public SubRoom getSubRoom() {
    	return this.salaHija;
    }
    
    public int getCapacity() {
    	return this.salaHija.getCapacity();
    }

	public Exhibition getExpo() {
		return expo;
	}

	public void setExpo(Exhibition expo) {
		this.expo = expo;
	}

	public SubRoom getSalaHija() {
		return salaHija;
	}
}
