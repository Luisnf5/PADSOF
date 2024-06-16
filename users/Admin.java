package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import activities.Activity;
import system.ArtGallery;

public class Admin extends User implements Serializable{ 

	public Admin(String name, String surname, String nif, Gender gender, LocalDate date, String password) {
        super(name, surname, nif, gender, date, password);
    }
	
	public boolean enroll(String nif, Activity activity) {

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

	}
    
	
}
