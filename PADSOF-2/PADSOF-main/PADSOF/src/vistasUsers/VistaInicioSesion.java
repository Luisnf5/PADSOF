package vistasUsers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorClienteReg;
import users.Gender;
import users.User;
import vistasSystem.VistaSystem;

public class VistaInicioSesion extends JPanel {
	VistaSystem parent;
	
	JLabel etiquetaNif;
	JTextField campoNif;
	
	JLabel etiquetaContraseña;
	JTextField campoContraseña;
	
	JButton iniciarSesion;
	JButton volver;
	
	public VistaInicioSesion(VistaSystem parent) {
		this.parent = parent;
		
		this.setLayout(new GridLayout(3,2));
		
		this.etiquetaNif = new JLabel("NIF");
		this.campoNif = new JTextField(10);
		
		this.etiquetaContraseña = new JLabel("Contraseña");
		this.campoContraseña = new JTextField(10);
		
		this.iniciarSesion = new JButton("Iniciar Sesión");
		this.volver = new JButton("Volver");
		
		
		this.add(etiquetaNif);
		this.add(campoNif);
		this.add(etiquetaContraseña);
		this.add(campoContraseña);
		this.add(iniciarSesion);
		this.add(volver);
		
	}
	
	public void setControlador(ActionListener c) {
		iniciarSesion.addActionListener(c);
		volver.addActionListener(c);
	}

}