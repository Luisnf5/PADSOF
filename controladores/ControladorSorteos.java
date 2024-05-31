package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controladoresAdmin.ControladorSorteoEditPanel;
import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Raffle;
import vistasAdmin.VistaSorteoEditPanel;
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
			}else if (system.getLoggedUser() instanceof Admin) {
				vistaSorteos.setVisible(false);
				vistaSystem.getVistaPerfilAdmin().setVisible(true);
			}else if (system.getLoggedUser() instanceof Client){
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
		}else if (selected.getText().equals("Crear Sorteo")) {
			System.out.println("Nuevo sorteo pulsado");
			VistaSorteoEditPanel aux = new VistaSorteoEditPanel(vistaSystem, new Raffle("titulo ejemplo", "descripción ejemplo", 1, LocalDateTime.now(), LocalDateTime.now(), null), true); 
			new ControladorSorteoEditPanel(vistaSystem, null, aux);
			JOptionPane.showMessageDialog(null, aux);
			vistaSorteos.updateSorteos(vistaSystem.getControladorSorteos().getSorteos());
		}
		
	}
	
	public Set<Raffle> getSorteos() {
		Set<Raffle> sorts = new LinkedHashSet<>();
		for (Exhibition e : system.getExhibitions()){
			if (e.getRaffle() != null) {
				sorts.add(e.getRaffle());
				if (e.getRaffle().getStartDate() == null) {
					System.out.println(e.getRaffle().getTitle() + " START DATE IS NULLLLLLLLL");
				}
			}
			System.out.println("raff: " + e.getRaffle());
		}
		
		return sorts;
	}
	
	



}