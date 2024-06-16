package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import activities.Activity;
import system.ArtGallery;

public class Staff extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bankAccount;
	protected static String pass;

	public Staff(String name, String surname, String nif, Gender gender, LocalDate date){
		super(name, surname, nif, gender, date);
		this.password = Staff.pass;
	}
	
	
	public static void changeStaffPwd(String newPwd) {
		Staff.pass = newPwd;
		Set<Staff> stfs = ArtGallery.getSystem().getStaffs();
		
		for (Staff s : stfs) {
			s.changePwd(newPwd);
		}
	}
	
	public boolean enroll(String nif, Activity activity) {
		if(this.hasPrivilege(Privileges.GESTION_ACTIVIDADES)) {
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
	
	@Override
	public Boolean changePwd(String newPwd) {
		this.password = newPwd;
		return true;
	}
	
	public void deleteStaff() {
		ArtGallery.getSystem().deleteUser(this);
	}


	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
	
	
}
