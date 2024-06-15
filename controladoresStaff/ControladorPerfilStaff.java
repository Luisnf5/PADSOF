
package controladoresStaff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladoresAdmin.ControladorExposicionEditPanel;
import system.ArtGallery;
import users.Admin;
import users.Privileges;
import users.Staff;
import vistasAdmin.VistaExposicionEditPanel;
import vistasStaff.VistaPerfilStaff;
import vistasSystem.VistaSystem;
import works.Exhibition;

public class ControladorPerfilStaff implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaPerfilStaff vistaPerfil;

	public ControladorPerfilStaff(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaPerfil = vistaSystem.getVistaPerfilStaff();	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton selected;
		selected = (AbstractButton) e.getSource();
		
		Staff s = (Staff) system.getLoggedUser();
		
		if (selected.getText().equals("Notificaciones")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaNotificacionesAdmin().updateClients(system.getClientsStrings());
			vistaSystem.getVistaNotificacionesAdmin().setVisible(true);
		}else if (selected.getText().equals("Sorteos")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if (selected.getText().equals("Principal")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaExposicion().setVisible(true);
		}else if(selected.getText().equals("Datos Personales")) {
			vistaPerfil.updateDatos(getActualStaff());
		}
		else if(selected.getText().equals("Confirmar Cambios")) {
			if (vistaPerfil.getCuentaBancaria().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "El espacio de Cuenta Bancaria no puede estar vacío");
				return;
			}else {
				s.setBankAccount(vistaPerfil.getCuentaBancaria().getText());
				JOptionPane.showMessageDialog(null, "La cuenta bancaria ha sido cambiada correctamente");
				return;
			}
		}else if(selected.getText().equals("Gestionar Salas")) {
			if (s.hasPrivilege(Privileges.GESTION_SALAS)) {
				vistaPerfil.updateSalas();
			}else {
				JOptionPane.showMessageDialog(null, "No posee este privilegio, contacte con el administrador");
				return;
			}
		}else if(selected.getText().equals("Gestionar Exposiciones")) {
			if (s.hasPrivilege(Privileges.GESTION_EXPOSICIONES)) {
				vistaPerfil.updateExpos(system.getExhibitions());
			}else {
				JOptionPane.showMessageDialog(null, "No posee este privilegio, contacte con el administrador");
				return;
			}
		}else if(selected.getText().equals("Gestionar Inventario")) {
			if (s.hasPrivilege(Privileges.GESTION_INVENTARIO)) {
				vistaPerfil.updateInv(system.getInventory());
			}else {
				JOptionPane.showMessageDialog(null, "No posee este privilegio, contacte con el administrador");
				return;
			}
		}else if(selected.getText().equals("Gestionar Usuarios")) {
			if (s.hasPrivilege(Privileges.GESTION_USUARIOS)) {
				if (vistaPerfil.getBlockedUsers().isSelected()) {
					vistaPerfil.updateUsers(system.getBlockedClients());
				}else {
					vistaPerfil.updateUsers(system.getClients());
				}
			}else {
				JOptionPane.showMessageDialog(null, "No posee este privilegio, contacte con el administrador");
				return;
			}
		}else if(selected.getText().equals("Bloqueados")) {
			System.out.println("Gestion Usuarios Bloqueados pulsado");
			if (vistaPerfil.getBlockedUsers().isSelected()) {
				vistaPerfil.updateUsers(system.getBlockedClients());
			}else {
				vistaPerfil.updateUsers(system.getClients());
			}
		}else if(selected.getText().equals("Nueva Exposición")) {
			VistaExposicionEditPanel aux = new VistaExposicionEditPanel(vistaSystem, new Exhibition("ejemplo", "ejemplo", LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)),  LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0))), true); 
			new ControladorExposicionEditPanel(vistaSystem, null, aux);
			JOptionPane.showMessageDialog(new JFrame("Nueva Exposicion"), aux);
			vistaPerfil.updateExpos(system.getExhibitions());
		}else if(selected.getText().equals("Cerrar Sesion")) {
			system.setLoggedUser(null);
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaPrincipal().setVisible(true);
		}
	}
	
	public Staff getActualStaff() {
		Staff cl;
		cl = (Staff) this.vistaSystem.getControladorVistaPrincipal().getSystem().getLoggedUser();
		return cl;
	}

}

