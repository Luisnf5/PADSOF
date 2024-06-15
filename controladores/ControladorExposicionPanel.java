package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Privileges;
import users.Staff;
import vistasSystem.VistaSystem;
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
		if (system.getLoggedUser() == null || system.getLoggedUser() instanceof Admin) {
			JOptionPane.showMessageDialog(null, "Debe registrase como Cliente o Staff \npara poder comprar una entrada");
			return;
		}else if (system.getLoggedUser() instanceof Client){
			this.vistaSystem.getVistaExposicion().setVisible(false);
			this.vistaSystem.getVistaCompraEntradas().updateExhibition(vistaExposicionPanel.getExhibition());
			this.vistaSystem.getVistaCompraEntradas().setVisible(true);
		}else if (system.getLoggedUser() instanceof Staff) {
			Staff s = (Staff) system.getLoggedUser();
			if (s.hasPrivilege(Privileges.COMPRA_ENTRADAS)) {
				this.vistaSystem.getVistaExposicion().setVisible(false);
				this.vistaSystem.getVistaCompraEntradas().updateExhibition(vistaExposicionPanel.getExhibition());
				this.vistaSystem.getVistaCompraEntradas().setVisible(true);
				return;
			}else {
				JOptionPane.showMessageDialog(null, "No posee este privilegio, contacte con el administrador");
				return;
			}
		}
		
		
	}

}
