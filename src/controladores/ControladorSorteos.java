package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import users.Raffle;
import vistasSystem.VistaSystem;
import vistasUsers.VistaSorteos;

public class ControladorSorteos implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaSorteos vistaSorteos;
	
	
	public ControladorSorteos( VistaSystem vistaSystem, ArtGallery system) {
		super();
		this.system = system;
		this.vistaSystem = vistaSystem;
		
		this.vistaSorteos = this.vistaSystem.getVistaSorteos();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if (selected.getText().equals("Notificaciones")) {
			vistaSorteos.setVisible(false);
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			vistaSorteos.setVisible(false);
			vistaSystem.getVistaPerfil().setVisible(true);
		}else if (selected.getText().equals("Principal")) {
			vistaSorteos.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaSorteos.setVisible(false);
			vistaSystem.getVistaExposicion().setVisible(true);
		}
		
	}
	
	public Set<Raffle> getSorteos() {
		Client cl = (Client) this.system.getLoggedUser();
		Set<Raffle> sorteos = cl.getRaffles();
		
		return sorteos;
		
	
		
	}



}