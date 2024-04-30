
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaInicioCliente;

public class ControladorInicioCliente implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaInicioCliente vistaInicioCliente;
	
	
	
	
	public ControladorInicioCliente(VistaSystem vistaSystem, ArtGallery system) {
		super();
		this.system = system;
		this.vistaSystem = vistaSystem;
		
		this.vistaInicioCliente = vistaSystem.getVistaInicioCliente();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if (selected.getText().equals("Sorteos")) {
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Notificaciones")) {
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaPerfil().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaInicioCliente.setVisible(false);
			vistaSystem.getVistaExposicion().setVisible(true);
		}
		
	}
	
	
}
