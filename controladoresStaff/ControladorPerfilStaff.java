
package controladoresStaff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import activities.Activity;
import activities.ActivityType;
import controladoresAdmin.ControladorActivityEditPanel;
import controladoresAdmin.ControladorExposicionEditPanel;
import controladoresAdmin.ControladorSalaPanel;
import system.ArtGallery;
import users.Admin;
import users.Privileges;
import users.Staff;
import vistasAdmin.VistaActivityEditPanel;
import vistasAdmin.VistaExposicionEditPanel;
import vistasAdmin.VistaSalaPanel;
import vistasStaff.VistaPerfilStaff;
import vistasSystem.VistaSystem;
import works.Exhibition;
import works.SubRoom;

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
		}else if(selected.getText().equals("Confirmar Cambios")) {
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
				vistaPerfil.updateSalas(system.getSubRooms());
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
		}else if(selected.getText().equals("Gestionar Actividades")) {
			if (s.hasPrivilege(Privileges.GESTION_ACTIVIDADES)) {
				vistaPerfil.updateActivities(system.getActivities());
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
		}else if(selected.getText().equals("Nueva Actividad")) {
			System.out.println("Nueva act pulsado");
			VistaActivityEditPanel aux = new VistaActivityEditPanel(vistaSystem, new Activity("Ejemplo", ActivityType.VISITA, "Descripcion ejemplo", 50, LocalDateTime.now(), null), true); 
			new ControladorActivityEditPanel(vistaSystem, null, aux);
			JOptionPane.showMessageDialog(new JFrame("Nueva Actividad"), aux);
			vistaPerfil.updateActivities(system.getActivities());
		}else if(selected.getText().equals("Crear Sala")) {
			System.out.println("Nueva sala pulsado");
			VistaSalaPanel aux = new VistaSalaPanel(vistaSystem, new SubRoom(false, 0, 0, 0, 0, 0, 0), true); 
			new ControladorSalaPanel(vistaSystem, null, aux);
			JOptionPane.showMessageDialog(null, aux);
			vistaPerfil.updateSalas(system.getSubRooms());
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

