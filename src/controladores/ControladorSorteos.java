package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;

import system.ArtGallery;
import users.Client;
import users.Raffle;
import vistasSystem.VistaSystem;
import vistasUsers.VistaSorteos;
import works.Exhibition;

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
		Client cl;
		
		if (selected.getText().equals("Notificaciones") && system.getLoggedUser() != null) {
			if (system.getLoggedUser() instanceof Client) {
				cl = (Client) system.getLoggedUser();
				vistaSorteos.setVisible(false);
				vistaSystem.getVistaNotificaciones().updateNotificaciones(cl.getNotifications());
				vistaSystem.getVistaNotificaciones().setVisible(true);
			}
		}else if (selected.getText().equals("Mi Perfil")) {
			if (system.getLoggedUser() == null) {
				vistaSorteos.setVisible(false);
				vistaSystem.getVistaPrincipal().setVisible(true);
			}else {
				vistaSorteos.setVisible(false);
				vistaSystem.getVistaPerfil().setVisible(true);
			}
		}else if (selected.getText().equals("Principal")) {
			vistaSorteos.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaSorteos.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}
		
	}
	
	public Set<Raffle> getSorteos() {
		Set<Raffle> sorts = new LinkedHashSet<>();
		for (Exhibition e : system.getExhibitions()){
			if (e.getRaffle() != null) {
				sorts.add(e.getRaffle());
			}
			System.out.println("raff: " + e.getRaffle());
		}
		
		return sorts;
	}
	
	



}