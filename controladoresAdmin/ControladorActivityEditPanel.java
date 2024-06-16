package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import activities.Activity;
import activities.ActivityType;
import system.ArtGallery;
import users.Admin;
import users.Staff;
import vistasAdmin.VistaActivityEditPanel;
import vistasSystem.VistaSystem;

public class ControladorActivityEditPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaActivityEditPanel vistaActivityEditPanel;
	
	public ControladorActivityEditPanel(VistaSystem vistaSystem, ArtGallery system, VistaActivityEditPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaActivityEditPanel = vista;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();

		
		
		Activity act;
		act = vistaActivityEditPanel.getActivity();
		String patronFecha = "^([0-2][0-9]|3[01])/([0-1][0-9])/([0-9]{4})/([0-1][0-9]|2[0-3])$";
		String fecha = vistaActivityEditPanel.getFecha().getText();
		int diaInicio;
		int mesInicio;
		int añoInicio;
		int hour;
		ActivityType type = null;
		

		if (selected.getText().equals("Crear Actividad")){
			
			if (vistaActivityEditPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaActivityEditPanel.getDescription().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía");
				return;
			}else if (!(fecha.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de inicio válida con el formato: DD/MM/YYYY/HH");
				return;
			}else if (vistaActivityEditPanel.getSalasSeleccionadas().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una sala");
				return;
			}else if (vistaActivityEditPanel.getTipo().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo");
				return;
			}
			
			diaInicio = Integer.parseInt(fecha.split("/")[0]);
			mesInicio = Integer.parseInt(fecha.split("/")[1]);
			añoInicio = Integer.parseInt(fecha.split("/")[2]);
			hour = Integer.parseInt(fecha.split("/")[3]);
			LocalDateTime fechaLDT = LocalDateTime.of(añoInicio, mesInicio, diaInicio, hour, 0);
			
			if (fechaLDT.toLocalDate().isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha de inicio anterior a la fecha actual");
				return;
			}
			
			String typeStr = (String)vistaActivityEditPanel.getTipo().getSelectedItem();
			
			if (typeStr.equals("CONFERENCIA")) {
				type = ActivityType.CONFERENCIA;
			}else if(typeStr.equals("MESA")) {
				type = ActivityType.MESA;
			}else if(typeStr.equals("PROYECCION")) {
				type = ActivityType.PROYECCION;
			}else if(typeStr.equals("ACTUACION")) {
				type = ActivityType.ACTUACION;
			}else if(typeStr.equals("VISITA")) {
				type = ActivityType.VISITA;
			}else if(typeStr.equals("FORMATIVA")) {
				type = ActivityType.FORMATIVA;
			}else if(typeStr.equals("OTROS")) {
				type = ActivityType.OTROS;
			}

			
			ArtGallery.getSystem().createActivity(vistaActivityEditPanel.getNombre().getText(), type, vistaActivityEditPanel.getDescription().getText(), hour, fechaLDT, system.getSubRoomFromName(vistaActivityEditPanel.getSalas().getSelectedValue()));
			
			
			JOptionPane.showMessageDialog(null, "La actividad se ha creado correctamente");
			if (system.getLoggedUser() instanceof Admin) {
				vistaSystem.getVistaPerfilAdmin().updateActivities(system.getActivities());
			}else {
				vistaSystem.getVistaPerfilStaff().updateActivities(system.getActivities());
			}
		}else if (selected.getText().equals("Editar")) {
			
			if (vistaActivityEditPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaActivityEditPanel.getDescription().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía");
				return;
			}else if (!(fecha.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha válida con el formato: DD/MM/YYYY/HH");
				return;
			}else if (vistaActivityEditPanel.getSalasSeleccionadas().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una sala");
				return;
			}else if (vistaActivityEditPanel.getTipo().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar un tipo");
				return;
			}
			
			String typeStr = (String)vistaActivityEditPanel.getTipo().getSelectedItem();
			
			if (typeStr.equals("CONFERENCIA")) {
				type = ActivityType.CONFERENCIA;
			}else if(typeStr.equals("MESA")) {
				type = ActivityType.MESA;
			}else if(typeStr.equals("PROYECCION")) {
				type = ActivityType.PROYECCION;
			}else if(typeStr.equals("ACTUACION")) {
				type = ActivityType.ACTUACION;
			}else if(typeStr.equals("VISITA")) {
				type = ActivityType.VISITA;
			}else if(typeStr.equals("FORMATIVA")) {
				type = ActivityType.FORMATIVA;
			}else if(typeStr.equals("OTROS")) {
				type = ActivityType.OTROS;
			}
			
			act.setName(vistaActivityEditPanel.getNombre().getText());
			act.setDescription(vistaActivityEditPanel.getDescription().getText());
			act.setRoom(system.getSubRoomFromName(vistaActivityEditPanel.getSalas().getSelectedValue()));
			act.setType(type);
			
			JOptionPane.showMessageDialog(null, "La actposición se ha editado correctamente (No se ha editado la fecha)");
			
			if (system.getLoggedUser() instanceof Admin) {
				vistaSystem.getVistaPerfilAdmin().updateActivities(system.getActivities());
			}else {
				vistaSystem.getVistaPerfilStaff().updateActivities(system.getActivities());
			}
			
		}else if (selected.getText().equals("Inscribir NIF")) {
			String patronNif = "\\d{8}[A-Za-z]";
			if (!(vistaActivityEditPanel.getNif().getText().matches(patronNif))) {
				JOptionPane.showMessageDialog(null, "Introduzca un NIF válido con el formato: XXXXXXXX[A-Z]");
				return;
			}
			
			if (system.getLoggedUser() instanceof Admin) {
				Admin aux = (Admin) system.getLoggedUser();
				aux.enroll(vistaActivityEditPanel.getNif().getText(), act);
			}else {
				Staff aux = (Staff) system.getLoggedUser();
				aux.enroll(vistaActivityEditPanel.getNif().getText(), act);
			}
			
			
			JOptionPane.showMessageDialog(null, "El cliente con NIF " + vistaActivityEditPanel.getNif().getText() + " se ha inscrito correctamente");
			if (system.getLoggedUser() instanceof Admin) {
				vistaSystem.getVistaPerfilAdmin().updateActivities(system.getActivities());
			}else {
				vistaSystem.getVistaPerfilStaff().updateActivities(system.getActivities());
			}
		}
	}

}
