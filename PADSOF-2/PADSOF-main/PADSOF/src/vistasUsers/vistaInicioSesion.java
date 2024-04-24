package vistasUsers;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class vistaInicioSesion extends JPanel {

	public vistaInicioSesion() {
		
		this.setLayout(new FlowLayout());
		
		JLabel etiquetaNif = new JLabel("NIF");
		JTextField campoNif = new JTextField(10);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña");
		JTextField campoContraseña = new JTextField(10);
		
		JButton iniciarSesion = new JButton("Iniciar Sesión");
		
		this.add(etiquetaNif);
		this.add(campoNif);
		this.add(etiquetaContraseña);
		this.add(campoContraseña);
		this.add(iniciarSesion);
	}
	
	
}
