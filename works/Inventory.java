/**
 * The Inventory class represents a collection of works.
 * It implements Serializable.
 * 
 * <p>An inventory contains a set of works.</p>
 * 
 * <p>This class provides constructors to create an inventory with specified works or based on another inventory.</p>
 * 
 * <p>It offers methods to add works to the inventory and to send a work for repair.</p>
 * 
 * <p>The set of works is maintained in a LinkedHashSet to preserve the insertion order.</p>
 * 
 * <p>Note: This class does not provide methods to remove works from the inventory.</p>
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Inventory implements Serializable{
    private static final long serialVersionUID = 1L;
    private Set<Work> works = new LinkedHashSet<>();

    /**
     * Constructs an Inventory object with specified works.
     * 
     * @param works the set of works to be included in the inventory
     */
    public Inventory(Set<Work> works) {
        super();
        this.works = works;
    }

    /**
     * Constructs a copy of an Inventory object.
     * 
     * @param last the previous inventory to copy from
     */
    public Inventory(Inventory last) {
        this.works = new LinkedHashSet<>(last.works);
    }
    
    /**
     * Constructs an empty Inventory object.
     */
    public Inventory(){
        super();
    }

    /**
     * Adds works to the inventory.
     * 
     * @param works the works to be added
     */
    public void addWorks(Work...works){
        for (Work w : works){
            this.works.add(w);
        }
    }
    
    /**
     * Sends a work for repair.
     * 
     * @param workRepair the work to be sent for repair
     * @return true if the work was found and sent for repair, false otherwise
     */
    public boolean sendReparation(Work workRepair){
        for(Work w: this.works){
            if(w == workRepair){
                w.repairWork();
                return true;
            }
        }
        return false;
    }

	public Set<Work> getWorks() {
		return works;
	}
	
	public boolean isEmpty() {
		return this.works.isEmpty();
	}
    
    
}
