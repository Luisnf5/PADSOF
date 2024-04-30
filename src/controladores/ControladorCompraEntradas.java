package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaClienteReg;
import vistasUsers.VistaCompraEntradas;

public class ControladorCompraEntradas implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaCompraEntradas vistaCompraEntradas;

	public ControladorCompraEntradas(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaCompraEntradas = vistaSystem.getVistaCompraEntradas();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
 	