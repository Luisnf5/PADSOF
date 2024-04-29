package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaClienteReg;
import vistasUsers.VistaInicioSesion;

public class ControladorInicioSesion implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaInicioSesion vistaInicioSesion;
	
	
	public ControladorInicioSesion(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaInicioSesion = vistaSystem.getInicioSesion();
		
	} 
		
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if(selected.getText().equals("Volver")) {
			vistaSystem.returnToMain(this.vistaInicioSesion);
		}
		
		
		
		this.vistaInicioSesion.setVisible(true);
		this.vistaSystem.getVistaPrincipal().setVisible(false);
		
		
	}
	
	
	
	
}
