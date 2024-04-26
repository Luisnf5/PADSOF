package vistasUsers;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaPrincipal extends JPanel {
	JButton boton;
	JButton iniciar;
	JButton clienteReg;
	
	public VistaPrincipal() {
		boton = new JButton("Haz click");
		iniciar = new JButton("Inciar Sesión");
		clienteReg = new JButton("Registrarse");
		
		this.add(boton);
		this.add(iniciar);
		this.add(clienteReg);
		
		
		
		
	}
	
	public void setControlador(ActionListener c) {
		boton.addActionListener(c);
		iniciar.addActionListener(c);
		clienteReg.addActionListener(c);
	}
}
