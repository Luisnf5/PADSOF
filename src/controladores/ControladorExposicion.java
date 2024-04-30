package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaExposicion;
import vistasUsers.VistaInicioSesion;
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
		
		if (selected.getText().equals("Sorteos")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaPerfil().setVisible(true);
		}else if (selected.getText().equals("Principal")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Notificaciones")) {
			vistaExposicion.setVisible(false);
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}
		
	}
	
	
	
	
	public String getExposicion() {
		for(Exhibition e: ArtGallery.getSystem().getExhibitions()) {
			
		}
		return "";
	}
	
}
