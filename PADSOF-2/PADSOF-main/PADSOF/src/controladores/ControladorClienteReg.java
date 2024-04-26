
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Set;

import system.ArtGallery;
import users.Gender;
import users.User;

public class ControladorClienteReg implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public boolean addCliente(String name, String surname, String nif, Gender gender, int dia, int mes, int ano, String password) {
		
		
		LocalDate date = LocalDate.of(ano, mes, dia);
		return ArtGallery.getSystem().newClient(name, surname, nif, gender, date, password);
	}
	
	
	public static boolean iniciarSesion(String nif, String pwd) {
		User u = ArtGallery.getSystem().getUserFromNif(nif);
		if (u == null) {
			return false;
		}else {
			if (u.getPassword().equals(pwd)) {
				ArtGallery.getSystem().setLoggedUser(u);
				return true;
			}else {
				return false;
			}
			

		}
	}
	
	public static void saveSystem() {
		ArtGallery.getSystem().saveSistem();
	}

}
