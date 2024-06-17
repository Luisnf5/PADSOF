
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Client;
import users.User;
import vistasSystem.VistaSystem;
import vistasUsers.VistaInicioSesion;

public class ControladorInicioSesion implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaInicioSesion vistaInicioSesion;
	
	
	public ControladorInicioSesion(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaInicioSesion = vistaSystem.getVistaInicioSesion();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		if(selected.getText().equals("Volver")) {
			vistaSystem.returnToMain(this.vistaInicioSesion);
		}
		
		if(selected.getText().equals("Iniciar Sesión")) {
			String pwd = this.vistaInicioSesion.getCampoContraseña().getText();
    		String nif = this.vistaInicioSesion.getCampoNif().getText();
			
			if (nif.equals("")) {
				JOptionPane.showMessageDialog(null, "introduzca un NIF");
				return;
			}
			else if (pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "Introduzca una contraseña");
				return;
			}else if (system.getUserFromNif(nif) == null) {
				JOptionPane.showMessageDialog(null, "El NIF introducido no coincide con ningún usuario en el sistema");
				return;
			}else if (system.getUserFromNif(nif).isBlocked()) {
				JOptionPane.showMessageDialog(null, "La cuenta se encuentra bloqueada, contacte con el administrador");
				return;
			}else if (ControladorClienteReg.iniciarSesion(nif, pwd) && system.getUserFromNif(nif).isResetPwd() == false) {
				JOptionPane.showMessageDialog(null, "Bienvenido");
				this.vistaInicioSesion.getCampoNif().setText("");
				this.vistaInicioSesion.getCampoContraseña().setText("");
				system.getUserFromNif(nif).restartIntentos();
				this.vistaSystem.getVistaInicioCliente().setVisible(true);
				this.vistaInicioSesion.setVisible(false);
				return;
			}else if (!ControladorClienteReg.iniciarSesion(nif, pwd) && system.getUserFromNif(nif).isResetPwd() == false) {
				JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
				if (system.getUserFromNif(nif) instanceof Client) system.getUserFromNif(nif).incrementarIntentos();
				return;
			}else if (system.getUserFromNif(nif).isResetPwd() && User.isPwdValidStatic(pwd)) {
				system.getUserFromNif(nif).setPassword(pwd);
				system.setLoggedUser(system.getUserFromNif(nif));
				system.getUserFromNif(nif).setResetPwd(false);;
				JOptionPane.showMessageDialog(null, "Su contraseña ha sido reestablecida correctamente");
				system.getUserFromNif(nif).restartIntentos();
				this.vistaSystem.getVistaInicioCliente().setVisible(true);
				this.vistaInicioSesion.setVisible(false);
				return;
			}else if (system.getUserFromNif(nif).isResetPwd() && !User.isPwdValidStatic(pwd)) {
				JOptionPane.showMessageDialog(null, "Introduzca una contraseña valida. Debe contener:\\n\\tUn numero\\n\\tUna letra minúscula\\n\\tUna letra mayúscula\\n\\tSu longitud debe ser mayor o igual a 8");
				return;
			}
			
		}
	}
	

		
	

	
	
	
}
