package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Gender;
import users.Privileges;
import users.Staff;
import vistasAdmin.VistaStaffPanel;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificacionPanel;

public class ControladorStaffPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	private boolean newStaff = false;
	
	private VistaStaffPanel vistaStaffPanel;
	
	public ControladorStaffPanel(VistaSystem vistaSystem, ArtGallery system, VistaStaffPanel vista, boolean newStaff) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaStaffPanel = vista;
		this.newStaff = newStaff;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		
		Staff cl;
		cl = vistaStaffPanel.getStaff();
		String patronNif = "\\d{8}[A-Za-z]";
		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
		String fecha = vistaStaffPanel.getFecha().getText();
		ButtonModel genderButonSelected = this.vistaStaffPanel.getGenderGroup().getSelection();
		Gender genderSelected = null;
		int dia;
		int mes;
		int año;

		if (selected.getText().equals("Confirmar Cambios")){
			if (vistaStaffPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
				return;
			}else if (vistaStaffPanel.getApellido().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío");
				return;
			}else if (vistaStaffPanel.getDni().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El NIF no puede estar vacío");
				return;
			}else if (!(vistaStaffPanel.getDni().getText().matches(patronNif))) {
				JOptionPane.showMessageDialog(null, "Introduzca un NIF valido con 8 numeros y una letra mayúscula");
				System.out.println(vistaStaffPanel.getNombre().getText());
				return;
			}else if (!(fecha.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha válida con el formato: DD/MM/YYYY");
				return;
			}
			
			dia = Integer.parseInt(fecha.split("/")[0]);
			mes = Integer.parseInt(fecha.split("/")[1]);
			año = Integer.parseInt(fecha.split("/")[2]);
			
			if (genderButonSelected == vistaStaffPanel.getMale().getModel()) {
				genderSelected = Gender.MALE;
			}else if (genderButonSelected == vistaStaffPanel.getFemale().getModel()) {
				genderSelected = Gender.FEMALE;
			}else if (genderButonSelected == vistaStaffPanel.getOther().getModel()) {
				genderSelected = Gender.OTHER;
			}
			if (newStaff) {
				cl = new Staff(vistaStaffPanel.getNombre().getText(), vistaStaffPanel.getApellido().getText(), vistaStaffPanel.getDni().getText(), genderSelected, LocalDate.of(año, mes, dia));
				system.newStaff(cl);
			}else{
				cl.changeName(vistaStaffPanel.getNombre().getText());
				cl.changeSurname(vistaStaffPanel.getApellido().getText());
				cl.changeNif(vistaStaffPanel.getDni().getText());
				cl.changeBirthDate(LocalDate.of(año, mes, dia));
				cl.changeGender(genderSelected);
				if (vistaStaffPanel.getTemp().isSelected()) {
					cl.addPrivilege(Privileges.TEMPERATURA);
				}else {
					cl.deletePrivilege(Privileges.TEMPERATURA);
				}
			}
			JOptionPane.showMessageDialog(null, "Se han confirmado los cambios de forma exitosa");
		}else if (selected.getText().equals("Eliminar Empleado")) {
			cl.deleteStaff();
			JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado de forma exitosa");
			vistaSystem.getVistaPerfilAdmin().updateStaff(system.getStaffs());
		}
	}

}
