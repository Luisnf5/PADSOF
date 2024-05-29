package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaExposicion;
import vistasUsers.VistaExposicionPanel;

public class ControladorExposicionPanel implements ActionListener {
	
	private VistaSystem vistaSystem;
	private ArtGallery system;
	
	private VistaExposicionPanel vistaExposicionPanel;
	
	
	
	public ControladorExposicionPanel(ArtGallery system, VistaSystem vistaSystem, VistaExposicionPanel vista) {
		
		this.vistaSystem = vistaSystem;
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem();
		
		this.vistaExposicionPanel = vista;
		
		vistaExposicionPanel.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Client cl;
		if (!(system.getLoggedUser() instanceof Client)) {
			JOptionPane.showMessageDialog(null, "Debe registrase como Cliente \npara poder registrarse en un sorteo");
			return;
		}else {
			cl = (Client) system.getLoggedUser();
		}
		
		this.vistaSystem.getVistaExposicion().setVisible(false);
		this.vistaSystem.getVistaCompraEntradas().updateExhibition(vistaExposicionPanel.getExhibition());
		this.vistaSystem.getVistaCompraEntradas().setVisible(true);
	}

}
