

package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Gender;
import users.Staff;
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
		Client cl = null;
		
		if (selected.getText().equals("Volver")) {
			this.vistaSystem.returnToMain(this.vistaClienteReg);
		}
		
		if (selected.getText().equals("Resgistrarse")) {
			String fecha = this.vistaClienteReg.getCampoDia().getText();
    		String nombre = this.vistaClienteReg.getCampoNombre().getText();
    		String apellido = this.vistaClienteReg.getCampoApellido().getText();
    		String pwd = this.vistaClienteReg.getCampoPwd().getText();
    		String nie = this.vistaClienteReg.getCampoNie().getText();
    		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
    		String patronNif = "\\d{8}[A-Za-z]";
    		ButtonModel genderButonSelected = this.vistaClienteReg.getGenderGroup().getSelection();
			Gender genderSelected = null;
			
			if (fecha.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduzca una fecha de nacimiento");
				return;
			}else if (nombre.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduzca un nombre");
				return;
			}
			else if (apellido.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduzca un apellido");
				return;
			}
			else if (nie.equals("")) {
				JOptionPane.showMessageDialog(null, "introduzca un NIF");
				return;
			}
			else if (pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduzca una contraseña");
				return;
			}else if (!fecha.matches(patronFecha)) {
				JOptionPane.showMessageDialog(null, "Introduzca una fecha con un formato valido \n(DD/MM/YYYY)");
				return;
			}else if (!User.isPwdValidStatic(pwd)) {
				JOptionPane.showMessageDialog(null, "Introduzca una contraseña valida. Debe contener:\n\tUn numero\n\tUna letra minúscula\n\tUna letra mayúscula\n\tSu longitud debe ser mayor o igual a 8");
				return;
			}else if (!nie.matches(patronNif)) {
				JOptionPane.showMessageDialog(null, "Introduzca un NIF valido con 8 numeros y una letra mayúscula");
				return;
			}else if (genderButonSelected == null) {
				JOptionPane.showMessageDialog(null, "Seleccione un genero");
				return;
			}
			 
			if (selected == this.vistaClienteReg.getMale().getModel()) {
				genderSelected = Gender.MALE;
			}else if (selected == this.vistaClienteReg.getFemale().getModel()) {
				genderSelected = Gender.MALE;
			}else if (selected == this.vistaClienteReg.getOther().getModel()) {
				genderSelected = Gender.OTHER;
			}


			int dia_f = Integer.parseInt(fecha.split("/")[0]);
			int mes_f = Integer.parseInt(fecha.split("/")[1]);
			int ano_f = Integer.parseInt(fecha.split("/")[2]);

			if (addCliente(nombre, apellido, nie, genderSelected, dia_f, mes_f, ano_f, pwd)) {
				for (User u : system.getUsers()) {
					if (u.getName().equals(nombre)) {
						cl = (Client) u;
						break;
					}
				}
				system.createNotification("Muchas Gracias", "¡Muchas gracias por registrarse en nuestra galería de exposiciones! Disfrute de nuestras exposiciones", cl);
				
				JOptionPane.showMessageDialog(null, "Nuevo cliente creado con éxito");
				this.vistaSystem.returnToMain(this.vistaClienteReg);
			}else {
				JOptionPane.showMessageDialog(null, "Error, ya existe un cliente con ese NIF");
				return;
			}
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
	
	

}
