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
            if(this.salaHija.getTemperature() == w.getTemperature()) {
                this.worksIn.add(w);
            }
            else {
                // Possible error message print
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
    
    public int getCapacity() {
    	return this.salaHija.getCapacity();
    }
}
