package vistasSystem;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import vistasUsers.*;

public class vistaSystem extends JFrame{

	public vistaSystem() {
		JFrame ventana = new JFrame("ART GALLERY");
		JPanel ventanaPrincipal = new JPanel();
		JPanel ventanaCliente = new vistaCliente();
		
		
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		// crear componentes
		JButton boton = new JButton("Haz click");
		JButton inciar = new JButton("Inciar Sesión");
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
		
		
		
		// aniadir componentes al contenedor
		ventanaPrincipal.add(boton);
		ventanaPrincipal.add(inciar);
		ventanaPrincipal.add(clienteReg);
		ventanaPrincipal.setVisible(true);
		contenedor.add(ventanaPrincipal);
		
	
		contenedor.add(ventanaCliente);
		
		// mostrar ventana
		ventanaCliente.setVisible(false);	
		
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(250,140);
		ventana.setVisible(true);
		
	}
	
}


