package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import system.ArtGallery;
import activities.*;

public class Staff extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankAccount;
	protected static String password;
	Set<Privileges> privileges = new LinkedHashSet<>();

	public Staff(String name, String surname, String nif, Gender gender, LocalDate date){
		super(name, surname, nif, gender, date);
	}
	
	@Override
	public Boolean changePwd(String newPwd) {
		return false;
	}
	
	public void deleteStaff() {
		ArtGallery.getSystem().deleteUser(this);
	}
	
	public boolean enroll(String nif, Activity activity) {
		if(this.hasPrivilege(Privileges.ACTIVIDADES)) {
			for(Client c : ArtGallery.getSystem().getClients()) {
				if(c.getNif().equals(nif)) {
					//Si es antes que pasado mañana (es mañana u hoy)
					if(activity.getDate().isBefore(LocalDateTime.now().plusDays(2)) && activity.getDate().isAfter(LocalDateTime.now())) {
						return activity.enroll(nif);
					}
				}
			}
			//Si no es cliente
			//Si es antes que mañana (es hoy)
			if(activity.getDate().isBefore(LocalDateTime.now().plusDays(1)) && activity.getDate().isAfter(LocalDateTime.now())) {
				return activity.enroll(nif);
			}
			
			return false;
		}else {
			return false;
		}
	}
	
	/**
     * Checks if the staff has a specific privilege.
     * 
     * @param p the privilege to check
     * @return true if the staff has the privilege, false otherwise
     */
    public boolean hasPrivilege(Privileges p) {
        return this.privileges.contains(p);
    }
    
    /**
     * Adds a privilege to the staff.
     * 
     * @param p the privilege to add
     */
    public void addPrivilege(Privileges p) {
        this.privileges.add(p);
    }
    
    public void deletePrivilege(Privileges p) {
    	this.privileges.remove(p);
    }
	
}
