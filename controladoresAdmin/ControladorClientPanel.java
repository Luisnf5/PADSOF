package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Client;
import users.Gender;
import users.Privileges;
import users.Staff;
import vistasAdmin.VistaClientPanel;
import vistasSystem.VistaSystem;

public class ControladorClientPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaClientPanel vistaClientPanel;
	
	public ControladorClientPanel(VistaSystem vistaSystem, ArtGallery system, VistaClientPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaClientPanel = vista;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		
		Client cl;
		cl = vistaClientPanel.getClient();
		String patronNif = "\\d{8}[A-Za-z]";
		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
		String fecha = vistaClientPanel.getFecha().getText();
		ButtonModel genderButonSelected = this.vistaClientPanel.getGenderGroup().getSelection();
		Gender genderSelected = null;
		int dia;
		int mes;
		int año;

		if (selected.getText().equals("Confirmar Cambios")){
			if (vistaClientPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
				return;
			}else if (vistaClientPanel.getApellido().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío");
				return;
			}else if (vistaClientPanel.getDni().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El NIF no puede estar vacío");
				return;
			}else if (!(vistaClientPanel.getDni().getText().matches(patronNif))) {
				JOptionPane.showMessageDialog(null, "Introduzca un NIF valido con 8 numeros y una letra mayúscula");
				return;
			}else if (!(fecha.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha válida con el formato: DD/MM/YYYY");
				return;
			}
			
			dia = Integer.parseInt(fecha.split("/")[0]);
			mes = Integer.parseInt(fecha.split("/")[1]);
			año = Integer.parseInt(fecha.split("/")[2]);
			
			System.out.println(dia + " " + mes + " " + año);
			
			if (genderButonSelected == vistaClientPanel.getMale().getModel()) {
				genderSelected = Gender.MALE;
			}else if (genderButonSelected == vistaClientPanel.getFemale().getModel()) {
				genderSelected = Gender.FEMALE;
			}else if (genderButonSelected == vistaClientPanel.getOther().getModel()) {
				genderSelected = Gender.OTHER;
			}

			cl.changeName(vistaClientPanel.getNombre().getText());
			cl.changeSurname(vistaClientPanel.getApellido().getText());
			cl.changeNif(vistaClientPanel.getDni().getText());
			cl.changeBirthDate(LocalDate.of(año, mes, dia));
			cl.changeGender(genderSelected);
			

			JOptionPane.showMessageDialog(null, "Se han confirmado los cambios de forma exitosa");
		}else if (selected.getText().equals("Eliminar Usuario")) {
			cl.deleteUser();
			JOptionPane.showMessageDialog(null, "Se ha eliminado el usuario de forma exitosa");
			if (vistaSystem.getVistaPerfilAdmin().getBlockedUsers().isSelected()) {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getBlockedClients());
			}else {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getClients());
			}
		}else if (selected.getText().equals("Bloquear Cuenta")) {
			System.out.println("bloquear pulsado");
			vistaClientPanel.getClient().block(true);
			JOptionPane.showMessageDialog(null, "La cuenta con NIF:" + vistaClientPanel.getClient().getNif() + " ha sido bloqueada");
			if (vistaSystem.getVistaPerfilAdmin().getBlockedUsers().isSelected()) {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getBlockedClients());
			}else {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getClients());
			}
		}else if (selected.getText().equals("Desbloquear Cuenta")) {
			vistaClientPanel.getClient().block(false);
			vistaClientPanel.getClient().setResetPwd(true);
			JOptionPane.showMessageDialog(null, "La cuenta con NIF:" + vistaClientPanel.getClient().getNif() + " ha sido desbloqueada");
			if (vistaSystem.getVistaPerfilAdmin().getBlockedUsers().isSelected()) {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getBlockedClients());
			}else {
				vistaSystem.getVistaPerfilAdmin().updateUsers(system.getClients());
			}
		}
	}

}
