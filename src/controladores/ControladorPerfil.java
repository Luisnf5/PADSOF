package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
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
		
		if (selected.getText().equals("Notificaciones")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Sorteos")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaSorteos().setVisible(true);
		}
	}

}
