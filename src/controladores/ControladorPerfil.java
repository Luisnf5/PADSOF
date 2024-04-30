
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificaciones;
import vistasUsers.VistaPerfil;

public class ControladorPerfil implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaPerfil vistaPerfil;

	public ControladorPerfil(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaPerfil = vistaSystem.getVistaPerfil();	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		Client cl;
		
		if (selected.getText().equals("Notificaciones") && system.getLoggedUser() != null) {
			cl = (Client) system.getLoggedUser();
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaNotificaciones().updateNotificaciones(cl.getNotifications());
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Sorteos")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());;
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Principal")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaPerfil.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}
	}

}

