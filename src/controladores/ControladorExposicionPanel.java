package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaExposicion;
import vistasUsers.VistaExposicionPanel;

public class ControladorExposicionPanel implements ActionListener {
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaExposicionPanel vistaExposicionPanel;
	
	
	
	public ControladorExposicionPanel(ArtGallery system, VistaSystem vistaSystem, VistaExposicionPanel vista) {
		this.system = system;
		this.vistaSystem = vistaSystem;
		
		this.vistaExposicionPanel = vista;
		
		vistaExposicionPanel.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.vistaSystem.getVistaExposicion().setVisible(false);
		this.vistaSystem.getVistaCompraEntradas().setVisible(true);
	}

}
