package users;

import java.io.Serializable;
import java.time.LocalDate;
import system.*;

public class Admin extends User implements Serializable{ 

	public Admin(String name, String surname, String nif, Gender gender, LocalDate date, String password) {
        super(name, surname, nif, gender, date, password);
    }
    
    public Boolean changeStaffPwd(String newPwd) {
		if (this.isPwdValid(newPwd) && this == ArtGallery.getSystem().getLoggedUser()) {
			Staff.password = newPwd;
			return true;
		}
		return false;
	}
    
    /**
     * Adds a privilege to the user.
     * 
     * @param p the privilege to add
     */
    public void addPrivilege(Privileges p){
    	if(ArtGallery.getSystem().getLoggedUser().equals(this))
    		this.privileges.add(p);
    }
	
}
