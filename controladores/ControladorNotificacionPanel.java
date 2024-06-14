package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificacionPanel;
import vistasUsers.VistaSorteoPanel;

public class ControladorNotificacionPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaNotificacionPanel vistaSorteoPanel;
	
	public ControladorNotificacionPanel(VistaSystem vistaSystem, ArtGallery system, VistaNotificacionPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaSorteoPanel = vista;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Client cl;
		
		if (!(system.getLoggedUser() instanceof Client)) {
			return;
		}
		
		cl = (Client) system.getLoggedUser();
		
		cl.removeNotification(vistaSorteoPanel.getNotificacion());
		System.out.println("se borro");
		vistaSystem.getVistaNotificaciones().updateNotificaciones(cl.getNotifications());
		System.out.println("ahora si");
	}

}
