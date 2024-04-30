package controladores;
import works.Exhibition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	public Set<Exhibition> getExposicion() {
		return system.getExhibitions();
	}
	
}
