
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaInicioCliente;

public class ControladorInicioCliente implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaInicioCliente vistaInicioCliente;
	
	
	
	
	public ControladorInicioCliente(VistaSystem vistaSystem, ArtGallery system) {
		super();
		this.system = system;
		this.vistaSystem = vistaSystem;
		
		this.vistaInicioCliente = vistaSystem.getVistaInicioCliente();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		Client cl;
		
		if (selected.getText().equals("Sorteos")) {
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Notificaciones") && system.getLoggedUser() != null) {
			cl = (Client) system.getLoggedUser();
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaNotificaciones().updateNotificaciones(cl.getNotifications());
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			if (system.getLoggedUser() == null) {
				vistaInicioCliente.setVisible(false);
				vistaSystem.getVistaPrincipal().setVisible(true);
			}else {
				vistaInicioCliente.setVisible(false);
				vistaSystem.getVistaPerfil().setVisible(true);
			}
			
		}else if (selected.getText().equals("Buscar")) {
			vistaInicioCliente.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}
		
	}
	
	
}
