
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaClienteReg;
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
			}else if (!ControladorClienteReg.iniciarSesion(nif, pwd)) {
				JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
				return;
			}
			JOptionPane.showMessageDialog(null, "Bienvenido");
			this.vistaSystem.getVistaInicioCliente().setVisible(true);
			this.vistaInicioSesion.setVisible(false);
		}
	}
	

		
	

	
	
	
}
