package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaPrincipal;

public class ControladorVistaPrincipal implements ActionListener {
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaPrincipal vistaPrincipal;
	
	
	public ControladorVistaPrincipal(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaPrincipal = vistaSystem.getVistaPrincipal();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if(selected.getText().equals("Iniciar Sesión")) {
			this.vistaPrincipal.setVisible(false);
			this.vistaSystem.getVistaInicioSesion().setVisible(true);
		}
		else if(selected.getText().equals("Registrarse")) {
			this.vistaPrincipal.setVisible(false);
			this.vistaSystem.getVistaClienteReg().setVisible(true);
		}else if(selected.getText().equals("Invitado")) {
			this.vistaPrincipal.setVisible(false);
			this.vistaSystem.getVistaInicioCliente().setVisible(true);
		}
	}
	
	public Client getLoggedClient() {
		return (Client) system.getLoggedUser();
	}
	
	
	public void saveSystem() {
		ArtGallery.getSystem().saveSistem();
	}

	public ArtGallery getSystem() {
		return system;
	}
	
	
}
