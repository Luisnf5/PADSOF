package users;

import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends User implements Serializable{ 

	public Admin(String name, String surname, String nif, Gender gender, LocalDate date, String password) {
        super(name, surname, nif, gender, date, password);
    }
	
	
}
