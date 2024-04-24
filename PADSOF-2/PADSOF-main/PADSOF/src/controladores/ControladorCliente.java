
package controladores;

import java.time.LocalDate;
import java.util.Set;

import system.ArtGallery;
import users.Gender;
import users.User;

public class ControladorCliente {

	public boolean addCliente(String name, String surname, String nif, Gender gender, int dia, int mes, int ano, String password) {
		
		
		LocalDate date = LocalDate.of(ano, mes, dia);
		return ArtGallery.getSystem().newClient(name, surname, nif, gender, date, password);
	}
	
	
	public boolean iniciarSesion(String nif, String pwd) {
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

}
