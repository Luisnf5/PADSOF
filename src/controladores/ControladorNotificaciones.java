package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import users.User;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificaciones;
import vistasUsers.VistaSorteos;

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
			Client cl;
			User u = system.getLoggedUser();
			if (u instanceof Client) {
				cl = (Client) u;
			}else {
				return;
			}
			vistaNotificaciones.setVisible(false);
			System.out.println(cl);
			System.out.println(cl.getRaffles());
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());;
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			vistaNotificaciones.setVisible(false);
			vistaSystem.getVistaPerfil().setVisible(true);
		}else if (selected.getText().equals("Principal")) {
			vistaNotificaciones.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaNotificaciones.setVisible(false);
			vistaSystem.getVistaExposicion().setVisible(true);
		}
	}
	
	
}