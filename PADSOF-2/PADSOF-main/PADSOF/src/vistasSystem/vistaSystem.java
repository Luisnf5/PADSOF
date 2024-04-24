	package vistasSystem;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import vistasUsers.*;

public class vistaSystem extends JFrame{
	private JPanel ventanaPrincipal;
	private JPanel ventanaCliente;
	private JPanel ventanaInicioSesion;
	
	public vistaSystem() {
		super("ArtGallery");	
		this.ventanaPrincipal = new JPanel();
		this.ventanaCliente = new vistaCliente(this);
		this.ventanaInicioSesion = new vistaInicioSesion(this);

		
		
		
		
		
		
		// obtener contenedor, asignar layout
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		contenedor.setLocation(0, 0);
		
		
		// crear componentes
		JButton boton = new JButton("Haz click");
		JButton iniciar = new JButton("Inciar Sesión");
		JButton clienteReg = new JButton("Registrarse");
		
		// asociar acciones a componentes
		clienteReg.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		             		 ventanaPrincipal.setVisible(false);
		                	 ventanaCliente.setVisible(true);
		                	 
		                 }
		           }
		       );	
		
		iniciar.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		             		 ventanaPrincipal.setVisible(false);
		                	 ventanaInicioSesion.setVisible(true);
		                	 
		                 }
		           }
		       );
		
		
		// aniadir componentes al contenedor
		ventanaPrincipal.add(boton);
		ventanaPrincipal.add(iniciar);
		ventanaPrincipal.add(clienteReg);
		ventanaPrincipal.setVisible(true);
		
		contenedor.setSize(1920, 1080);

        // Agregar paneles al contenedor principal
        contenedor.add(ventanaPrincipal);
        contenedor.add(ventanaCliente);
        contenedor.add(ventanaInicioSesion);
        
        
        
		
	
		
		
		
		// mostrar ventana
		ventanaCliente.setVisible(false);
		ventanaInicioSesion.setVisible(false);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setVisible(true);
		
	}
	
	public void returnToMain(JPanel actual) {
		actual.setVisible(false);
		this.ventanaPrincipal.setVisible(true);
	}
	
}


