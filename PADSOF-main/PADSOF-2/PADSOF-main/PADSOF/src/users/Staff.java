package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import system.ArtGallery;

public class Staff extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankAccount;
	private static String password;
	private Set<Privileges> privileges = new HashSet<>();

	public Staff(String name, String surname, String nif, Gender gender, LocalDate date){
		super(name, surname, nif, gender, date);
	}
	
	@Override
	public Boolean changePwd(String newPwd) {
		if (this.isPwdValid(newPwd) && this == ArtGallery.getSystem().getLoggedUser()) {
			Staff.password = newPwd;
			return true;
		}
		return false;
	}
	
	
}
