package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import system.ArtGallery;

public class Staff extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankAccount;
	protected static String password;
	private Set<Privileges> privileges = new HashSet<>();

	public Staff(String name, String surname, String nif, Gender gender, LocalDate date){
		super(name, surname, nif, gender, date);
	}
	
	@Override
	public Boolean changePwd(String newPwd) {
		return false;
	}
	
	public void setBankAccount(String bankAccount) {
		if(this.equals(ArtGallery.getSystem().getLoggedUser()))
			this.bankAccount = bankAccount;
	}
	
	
}
