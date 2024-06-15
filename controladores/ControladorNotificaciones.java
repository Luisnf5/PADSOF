package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Staff;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificaciones;

public class ControladorNotificaciones implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaNotificaciones vistaNotificaciones;

	public ControladorNotificaciones(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaNotificaciones = vistaSystem.getVistaNotificaciones();	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if (selected.getText().equals("Sorteos")) {
			vistaNotificaciones.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());;
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			if (system.getLoggedUser() == null) {
				vistaNotificaciones.setVisible(false);
				vistaSystem.getVistaPrincipal().setVisible(true);
			}else if (system.getLoggedUser() instanceof Admin) {
				vistaNotificaciones.setVisible(false);
				vistaSystem.getVistaPerfilAdmin().setVisible(true);
			}else if (system.getLoggedUser() instanceof Client){
				vistaNotificaciones.setVisible(false);
				vistaSystem.getVistaPerfil().setVisible(true);
			}else if (system.getLoggedUser() instanceof Staff){
				vistaNotificaciones.setVisible(false);
				vistaSystem.getVistaPerfilStaff().setVisible(true);
			}
		}else if (selected.getText().equals("Principal")) {
			vistaNotificaciones.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaNotificaciones.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}
	}
	
	
	
	
	
}