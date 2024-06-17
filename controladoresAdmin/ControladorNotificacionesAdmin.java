package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Admin;
import users.Client;
import users.Staff;
import vistasAdmin.VistaNotificacionesAdmin;
import vistasSystem.VistaSystem;

public class ControladorNotificacionesAdmin implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaNotificacionesAdmin vistaNotificacionesAdmin;

	public ControladorNotificacionesAdmin(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaNotificacionesAdmin = vistaSystem.getVistaNotificacionesAdmin();	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if (selected.getText().equals("Sorteos")) {
			vistaNotificacionesAdmin.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());;
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Mi Perfil")) {
			if (system.getLoggedUser() instanceof Admin) {
				vistaNotificacionesAdmin.setVisible(false);
				vistaSystem.getVistaPerfilAdmin().setVisible(true);
			}else if (system.getLoggedUser() instanceof Staff) {
				vistaNotificacionesAdmin.setVisible(false);
				vistaSystem.getVistaPerfilStaff().setVisible(true);
			}
		}else if (selected.getText().equals("Principal")) {
			vistaNotificacionesAdmin.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaNotificacionesAdmin.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}else if (selected.getText().equals("Enviar")) {
			enviarNotificaciones();
			Set<String> clients = system.getClientsStrings();
			vistaNotificacionesAdmin.updateClients(clients);
			JOptionPane.showMessageDialog(null, "Las notificaciones han sido enviadas correctamente");
            return;
		}
	}
	
	private void enviarNotificaciones() {
		Set<JCheckBox> checks = vistaNotificacionesAdmin.getChecks();
		
		for (JCheckBox box : checks) {
			if (box.isSelected()) {
				ArtGallery.getSystem().createNotification(vistaNotificacionesAdmin.getTitulo().getText(), vistaNotificacionesAdmin.getDescripcion().getText(), (Client) ArtGallery.getSystem().getUserFromNif(box.getText()));
			}
		}
	}
	
	
	
	
	
}