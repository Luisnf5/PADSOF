package vistasUsers;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vistasSystem.VistaSystem;

public class VistaPrincipal extends JPanel {
	VistaSystem parent;
	
	JButton boton;
	JButton iniciar;
	JButton clienteReg;
	JButton expo;
	
	public VistaPrincipal(VistaSystem parent) {
		this.parent = parent;
		
		boton = new JButton("Haz click");
		iniciar = new JButton("Iniciar Sesión");
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
