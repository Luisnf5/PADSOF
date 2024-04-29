package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		
	}
	
	
	
	
	public String getExposicion() {
		for(Exhibition e: ArtGallery.getSystem().getExhibitions()) {
			
		}
		return "";
	}
	
}
