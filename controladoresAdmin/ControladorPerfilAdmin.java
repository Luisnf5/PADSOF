
package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Admin;
import users.Gender;
import users.Staff;
import vistasAdmin.VistaExposicionEditPanel;
import vistasAdmin.VistaPerfilAdmin;
import vistasAdmin.VistaStaffPanel;
import vistasSystem.VistaSystem;
import works.Exhibition;

public class ControladorPerfilAdmin implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaPerfilAdmin vistaPerfil;

	public ControladorPerfilAdmin(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaPerfil = vistaSystem.getVistaPerfilAdmin();	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton selected;
		selected = (AbstractButton) e.getSource();
		
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
			vistaPerfil.updateDatos(getActualAdmin());
		}else if(selected.getText().equals("Cambiar Contraseña")) {
			vistaPerfil.updateCambioContraseña();
		}else if(selected.getText().equals("Ver Entradas")) {
			vistaPerfil.updateEntradas(getActualAdmin());
		}else if(selected.getText().equals("Gestionar Staff")) {
			vistaPerfil.updateStaff(system.getStaffs());
		}else if(selected.getText().equals("Gestionar Salas")) {
			vistaPerfil.updateSalas();
		}else if(selected.getText().equals("Gestionar Exposiciones")) {
			vistaPerfil.updateExpos(system.getExhibitions());
		}else if(selected.getText().equals("Gestionar Inventario")) {
			System.out.println("INVVVVVV");
			vistaPerfil.updateInv(system.getInventory());
		}else if(selected.getText().equals("Gestionar Usuarios")) {
			System.out.println("Gestion Usuartios pulsado");
			if (vistaPerfil.getBlockedUsers().isSelected()) {
				vistaPerfil.updateUsers(system.getBlockedClients());
			}else {
				vistaPerfil.updateUsers(system.getClients());
			}
		}else if(selected.getText().equals("Bloqueados")) {
			System.out.println("Gestion Usuartios pulsado");
			if (vistaPerfil.getBlockedUsers().isSelected()) {
				vistaPerfil.updateUsers(system.getBlockedClients());
			}else {
				vistaPerfil.updateUsers(system.getClients());
			}
		}else if(selected.getText().equals("Nuevo Empleado")) {
			System.out.println("Nuevo empleado pulsado");
			VistaStaffPanel aux = new VistaStaffPanel(vistaSystem, new Staff("", "", "", Gender.OTHER, LocalDate.of(2000, 1, 1))); 
			new ControladorStaffPanel(vistaSystem, null, aux, true);
			JOptionPane.showMessageDialog(null, aux);
			vistaPerfil.updateStaff(system.getStaffs());
		}else if(selected.getText().equals("Nueva Exposición")) {
			System.out.println("Nueva expo pulsado");
			VistaExposicionEditPanel aux = new VistaExposicionEditPanel(vistaSystem, new Exhibition("ejemplo", "ejemplo", LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)),  LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0))), true); 
			new ControladorExposicionEditPanel(vistaSystem, null, aux);
			JOptionPane.showMessageDialog(new JFrame("Nuevo Empleado"), aux);
			vistaPerfil.updateExpos(system.getExhibitions());
		}else if(selected.getText().equals("Cerrar Sesion")) {
			system.setLoggedUser(null);
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaPrincipal().setVisible(true);
		}else if (selected.getText().equals("Confirmar")) {
			char[] rawPwd1 = vistaPerfil.getNuevaContraseña().getPassword();
            char[] rawPwd2 = vistaPerfil.getNuevaContraseñaRepite().getPassword();
			String pwd1 = new String(rawPwd1);
			String pwd2 = new String(rawPwd2);
			
			if (!(pwd1.equals(pwd2))) {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				return;
			}
			
			if(!system.getLoggedUser().changePwd(pwd1)) {
				JOptionPane.showMessageDialog(null, "La contraseña no es valida. Debe contener:\n\tUn numero\n\tUna letra minúscula\n\tUna letra mayúscula\n\tSu longitud debe ser mayor o igual a 8");
				return;
			}else {
				JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito");
				 vistaPerfil.getNuevaContraseña().setText(null);
				 vistaPerfil.getNuevaContraseñaRepite().setText(null);
				return;
			}
			
		}else if(selected.getText().equals("Cambiar Contraseña Staff")) {
			vistaPerfil.updateCambioContraseñaStaff();
			System.out.println("sioq");
		}else if (selected.getText().equals("Confirmar Contraseña")) {
			char[] rawPwd1 = vistaPerfil.getNuevaContraseñaStaff().getPassword();
            char[] rawPwd2 = vistaPerfil.getNuevaContraseñaRepiteStaff().getPassword();
			String pwd1 = new String(rawPwd1);
			String pwd2 = new String(rawPwd2);
			
			if (!(pwd1.equals(pwd2))) {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				return;
			}
			
			Staff.changeStaffPwd(pwd2);
			JOptionPane.showMessageDialog(null, "Contraseña cambiada con éxito");
			vistaPerfil.getNuevaContraseña().setText(null);
			vistaPerfil.getNuevaContraseñaRepite().setText(null);
			return;
			
			
		}
	}
	
	public Admin getActualAdmin() {
		Admin cl;
		cl = (Admin) this.vistaSystem.getControladorVistaPrincipal().getSystem().getLoggedUser();
		return cl;
	}

}

