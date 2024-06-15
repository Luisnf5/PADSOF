package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
