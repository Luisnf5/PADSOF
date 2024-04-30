package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
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
			vistaNotificaciones.setVisible(false);
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