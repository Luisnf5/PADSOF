
package controladores;

import java.time.LocalDate;
import java.util.Set;

import system.ArtGallery;
import users.Gender;
import users.User;

public class ControladorCliente {

	public Set<User> addCliente(String name, String surname, String nif, String gender, String dia, String mes, String ano, String password) {
		LocalDate date = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
		ArtGallery.getSystem().newClient(name, surname, nif, Gender.OTHER, date, password);
		return this.printTest();
	}
	
	public Set<User> printTest() {
		return ArtGallery.getSystem().getUsers();
	}
}
