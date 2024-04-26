	package vistasSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import controladores.ControladorClienteReg;
import vistasUsers.*;

public class VistaSystem extends JFrame{
	private JPanel ventanaPrincipal;
	private VistaClienteReg vistaClienteReg;
	private VistaInicioSesion vistaInicioSesion;
	private VistaInicioCliente vistaInicioCliente;
	private VistaPrincipal vistaPrincipal;
	
	public VistaSystem() {
		super("ArtGallery");
		this.ventanaPrincipal = new VistaPrincipal();
		this.vistaClienteReg = new VistaClienteReg(this);
		this.vistaInicioSesion = new VistaInicioSesion(this);
		this.vistaInicioCliente = new VistaInicioCliente(this);
		
		
		// obtener contenedor, asignar layout
		Container contenedor = this.getContentPane();
		contenedor.setLayout(new FlowLayout(1, 900, 1));
		contenedor.setLocation(500, 500);
		
		
		// crear componentes

		
		// asociar acciones a componentes
		clienteReg.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		             		 ventanaPrincipal.setVisible(false);
		                	 vistaClienteReg.setVisible(true);
		                	 
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
		
		boton.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		             		 ventanaPrincipal.setVisible(false);
		                	 ventanaInicioCliente.setVisible(true);
		                	 
		                 }
		           }
		       );


		// mostrar ventana
		vistaClienteReg.setVisible(false);
		ventanaInicioSesion.setVisible(false);
		ventanaInicioCliente.setVisible(false	);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        ControladorClienteReg.saveSystem();
				System.exit(0);
			}
		});
		
		this.setSize(1920,1080);
		this.setVisible(true);
		
	}
	
	public void returnToMain(JPanel actual) {
		actual.setVisible(false);
		this.ventanaPrincipal.setVisible(true);
	}
	
	public void goToInicioCliente(JPanel actual) {
		actual.setVisible(false);
		this.ventanaInicioCliente.setVisible(true);
	}
	
}


