
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaPerfil;

public class ControladorPerfil implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaPerfil vistaPerfil;

	public ControladorPerfil(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaPerfil = vistaSystem.getVistaPerfil();	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		Client cl = (Client) system.getLoggedUser();
		
		if (selected.getText().equals("Notificaciones")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaNotificaciones().setVisible(true);
		}else if (selected.getText().equals("Sorteos")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaSorteos().updateSorteos(vistaSystem.getControladorSorteos().getSorteos());
			vistaSystem.getVistaSorteos().setVisible(true);
		}else if(selected.getText().equals("Confirmar Cambios")) {
			if (vistaPerfil.getCuentaBancaria().getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "El espacio de Cuenta Bancaria no puede estar vacío");
				return;
			}else if (!TeleChargeAndPaySystem.isValidCardNumber(vistaPerfil.getCuentaBancaria().getText())) {
				JOptionPane.showMessageDialog(null, "La cuenta bancaria proporcionada no es un número de cuenta válido");
				return;
			}else {
				cl.setBankAccount(vistaPerfil.getCuentaBancaria().getText());
				JOptionPane.showMessageDialog(null, "La cuenta bancaria ha sido cambiada correctamente");
				return;
			}
		}else if (selected.getText().equals("Principal")) {
			vistaPerfil.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Buscar")) {
			vistaPerfil.setVisible(false);
			this.vistaSystem.getVistaExposicion().updateExhibitions(system.getExhibitions());
			vistaSystem.getVistaExposicion().setVisible(true);
		}else if(selected.getText().equals("Datos Personales")) {
			vistaPerfil.updateDatos(getActualClient());
		}else if(selected.getText().equals("Cambiar Contraseña")) {
			vistaPerfil.updateCambioContraseña();
		}else if(selected.getText().equals("Ver Entradas")) {
			vistaPerfil.updateEntradas(getActualClient());
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
			
		}
	}
	
	public Client getActualClient() {
		Client cl;
		cl = (Client) this.vistaSystem.getControladorVistaPrincipal().getSystem().getLoggedUser();
		return cl;
	}

}

