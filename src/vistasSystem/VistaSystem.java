
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

import controladores.Controlador;
import controladores.ControladorClienteReg;
import controladores.ControladorExposicion;
import controladores.ControladorInicioCliente;
import controladores.ControladorInicioSesion;
import controladores.ControladorNotificaciones;
import controladores.ControladorPerfil;
import controladores.ControladorSorteos;
import controladores.ControladorVistaPrincipal;
import vistasUsers.*;

public class VistaSystem extends JFrame{

	private ControladorClienteReg controladorClienteReg;
	private ControladorVistaPrincipal controladorVistaPrincipal;
	private ControladorInicioSesion controladorInicioSesion;
	private ControladorExposicion controladorExposicion;
	private ControladorSorteos controladorSorteos;
	private ControladorInicioCliente controladorInicioCliente;
	private ControladorNotificaciones controladorNotificaciones;
	private ControladorPerfil controladorPerfil;
	
	private VistaClienteReg vistaClienteReg;
	private VistaInicioSesion vistaInicioSesion;
	private VistaInicioCliente vistaInicioCliente;
	private VistaPrincipal vistaPrincipal;
	private VistaExposicion vistaExposicion;
	private VistaSorteos vistaSorteos;
	private VistaNotificaciones vistaNotificaciones;
	private VistaPerfil vistaPerfil;
	
	
	public VistaSystem() {
		super("ArtGallery");
		
		
		
		setLayout(new FlowLayout());
		
		this.vistaPrincipal = new VistaPrincipal(this);
		this.vistaClienteReg = new VistaClienteReg(this);
		this.vistaInicioSesion = new VistaInicioSesion(this);
		this.vistaInicioCliente = new VistaInicioCliente(this);
		this.vistaExposicion = new VistaExposicion(this);
		this.vistaSorteos = new VistaSorteos(this);
		this.vistaNotificaciones = new VistaNotificaciones(this);
		this.vistaPerfil = new VistaPerfil(this);
		
		
		// crear componentes

		
		// asociar acciones a componentes
		vistaPrincipal.setVisible(true);


		// mostrar ventana
		vistaClienteReg.setVisible(false);
		vistaInicioSesion.setVisible(false);
		vistaInicioCliente.setVisible(false);
		vistaExposicion.setVisible(false);
		vistaSorteos.setVisible(false);
		vistaNotificaciones.setVisible(false);
		vistaPerfil.setVisible(false);
		

		
		
		
		this.add(vistaClienteReg);
		this.add(vistaInicioCliente);
		this.add(vistaInicioSesion);
		this.add(vistaExposicion);
		this.add(vistaPrincipal);
		this.add(vistaSorteos);
		this.add(vistaNotificaciones);
		this.add(vistaPerfil);
		
		vistaPrincipal.setBackground(Color.black);
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		        controladorVistaPrincipal.saveSystem();
				System.exit(0);
			}
		});
		
	}
	public void setControlador(Controlador controlador) {
		this.controladorVistaPrincipal = controlador.getControladorVistaPrincipal();
		this.vistaPrincipal.setControlador(controladorVistaPrincipal);
		this.controladorInicioSesion = controlador.getControladorInicioSesion();
		this.vistaInicioSesion.setControlador(controladorInicioSesion);
		this.controladorClienteReg = controlador.getControladorClienteReg();
		this.vistaClienteReg.setControlador(controladorClienteReg);
		this.controladorExposicion = controlador.getControladorExpo();
		//set controladorExpo
		this.controladorSorteos = controlador.getControladorSorteos();
		this.vistaSorteos.setControlador(controladorSorteos);
		this.controladorInicioCliente = controlador.getControladorInicioCliente();
		this.vistaInicioCliente.setControlador(controladorInicioCliente);
		this.controladorNotificaciones = controlador.getControladorNotificaciones();
		this.vistaNotificaciones.setControlador(controladorNotificaciones);
		this.controladorPerfil = controlador.getControladorPerfil();
		this.vistaPerfil.setControlador(controladorPerfil);
		
	}
	
	public void returnToMain(JPanel actual) {
		actual.setVisible(false);
		this.vistaPrincipal.setVisible(true);
	}
	
	public VistaClienteReg getVistaClienteReg() {
		return this.vistaClienteReg;
	}
	
	public VistaInicioCliente getVistaInicioCliente() {
		return this.vistaInicioCliente;
	}
	public VistaExposicion getVistaExposicion() {
		return this.vistaExposicion;
	}
	public VistaInicioSesion getVistaInicioSesion() {
		return this.vistaInicioSesion;
	}

	public VistaPrincipal getVistaPrincipal() {
		return this.vistaPrincipal;
	}
	public VistaSorteos getVistaSorteos() {
		return vistaSorteos;
	}
	public VistaNotificaciones getVistaNotificaciones() {
		return vistaNotificaciones;
	}
	public VistaPerfil getVistaPerfil() {
		return vistaPerfil;
	}
	
	
	
}


