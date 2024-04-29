
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Set;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Gender;
import users.User;
import vistasSystem.VistaSystem;
import vistasUsers.VistaClienteReg;

public class ControladorClienteReg implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaClienteReg vistaClienteReg;
	
	
	public ControladorClienteReg(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaClienteReg = vistaSystem.getVistaClienteReg();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if(selected.getText().equals("Volver")) {
			this.vistaSystem.returnToMain(this.vistaClienteReg);
		}
		
		

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
