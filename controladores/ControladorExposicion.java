package controladores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;

import system.ArtGallery;
import users.Admin;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaExposicion;
import works.Exhibition;

public class ControladorExposicion implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaExposicion vistaExposicion;
	
	
	
	
	public ControladorExposicion(ArtGallery system, VistaSystem vistaSystem) {
		this.system = system;
		this.vistaSystem = vistaSystem;
		
		this.vistaExposicion = vistaSystem.getVistaExposicion();
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		Client cl;
		
		if (selected.getText().equals("Sorteos")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Notificaciones") && system.getLoggedUser() != null) {
			cl = (Client) system.getLoggedUser();
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaNotificaciones().updateNotificaciones(cl.getNotifications());
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			if (system.getLoggedUser() == null) {
				vistaExposicion.setVisible(false);
				vistaSystem.getVistaPrincipal().setVisible(true);
			}else if (system.getLoggedUser() instanceof Admin) {
				vistaExposicion.setVisible(false);
				vistaSystem.getVistaPerfilAdmin().setVisible(true);
			}else if (system.getLoggedUser() instanceof Client){
				vistaExposicion.setVisible(false);
				vistaSystem.getVistaPerfil().setVisible(true);
			}
		}else if (selected.getText().equals("Principal")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}
	}
	
	public Set<Exhibition> getExposicion() {
		return system.getExhibitions();
	}
	
}
