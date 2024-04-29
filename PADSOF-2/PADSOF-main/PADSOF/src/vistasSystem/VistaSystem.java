	package vistasSystem;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

import controladores.Controlador;
import controladores.ControladorClienteReg;
import controladores.ControladorExposicion;
import controladores.ControladorInicioSesion;
import controladores.ControladorVistaPrincipal;
import vistasUsers.*;

public class VistaSystem extends JFrame{

	private ControladorClienteReg controladorClienteReg;
	private ControladorVistaPrincipal controladorVistaPrincipal;
	private ControladorInicioSesion controladorInicioSesion;
	private ControladorExposicion controladorExposicion;
	
	private VistaClienteReg vistaClienteReg;
	private VistaInicioSesion vistaInicioSesion;
	private VistaInicioCliente vistaInicioCliente;
	private VistaPrincipal vistaPrincipal;
	private VistaExposicion vistaExposicion;
	
	private JButton clienteReg;
	private JButton iniciar;
	private JButton boton;
	
	public VistaSystem() {
		super("ArtGallery");
		
		this.setLayout(new FlowLayout());
		
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaClienteReg = new VistaClienteReg(this);
		this.vistaInicioSesion = new VistaInicioSesion(this);
		this.vistaInicioCliente = new VistaInicioCliente(this);
		this.vistaExposicion = new VistaExposicion(this);
	

		// mostrar ventana
		vistaPrincipal.setVisible(true);
		vistaClienteReg.setVisible(false);
		vistaInicioSesion.setVisible(false);
		vistaInicioCliente.setVisible(false);
		vistaExposicion.setVisible(false);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        ControladorClienteReg.saveSystem();
				System.exit(0);
			}
		});
		
		
		
		this.add(vistaClienteReg);
		this.add(vistaInicioCliente);
		this.add(vistaInicioSesion);
		this.add(vistaExposicion);
		this.add(vistaPrincipal);
		
		vistaPrincipal.setBackground(Color.black);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.setVisible(true);
		
	}
	public void setControlador(Controlador controlador) {
		this.controladorVistaPrincipal = controlador.getControladorVistaPrincipal();
		this.vistaPrincipal.setControlador(controladorVistaPrincipal);
		this.controladorInicioSesion = controlador.getControladorInicioSesion();
		this.vistaInicioSesion.setControlador(controladorInicioSesion);
		this.controladorClienteReg = controlador.getControladorClienteReg();
		this.vistaClienteReg.setControlador(controladorClienteReg);
		
		
	}
	
	public void returnToMain(JPanel actual) {
		actual.setVisible(false);
		this.vistaPrincipal.setVisible(true);
	}
	
	public void goToInicioCliente(JPanel actual) {
		actual.setVisible(false);
		this.vistaInicioCliente.setVisible(true);
	}
	
	public VistaClienteReg getVistaClienteReg() {
		return this.vistaClienteReg;
	}
	
	public VistaInicioSesion getVistaInicioSesion() {
		return this.vistaInicioSesion;
	}

	public VistaPrincipal getVistaPrincipal() {
		return this.vistaPrincipal;
	}
	
	public VistaInicioCliente getVistaInicioCliente() {
		return vistaInicioCliente;
	}
	
	public VistaExposicion getVistaExposicion() {
		return vistaExposicion;
	}
	
	
}


