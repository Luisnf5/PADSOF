
package controladores;


import controladoresAdmin.ControladorNotificacionesAdmin;
import controladoresAdmin.ControladorPerfilAdmin;
import controladoresStaff.ControladorPerfilStaff;
import system.ArtGallery;
import vistasSystem.VistaSystem;

public class Controlador {
	private ArtGallery sytem;
	private VistaSystem ventana;
	
	
	
	private ControladorClienteReg controladorClienteReg;
	private ControladorExposicion controladorExpo;
	private ControladorInicioSesion controladorInicioSesion;
	private ControladorVistaPrincipal controladorVistaPrincipal;
	private ControladorInicioCliente controladorInicioCliente;
	private ControladorSorteos controladorSorteos;
	private ControladorNotificaciones controladorNotificaciones;
	private ControladorPerfil controladorPerfil;
	private ControladorCompraEntradas controladorCompraEntradas;
	private ControladorPerfilAdmin controladorPerfilAdmin;
	private ControladorNotificacionesAdmin controladorNotificacionesAdmin;
	private ControladorPerfilStaff controladorPerfilStaff;
	
	public Controlador(VistaSystem vistaSystem, ArtGallery system) {
		this.ventana = vistaSystem;
		this.controladorInicioSesion = new ControladorInicioSesion(vistaSystem, system);
		this.controladorVistaPrincipal = new ControladorVistaPrincipal(vistaSystem, system);
		this.controladorClienteReg = new ControladorClienteReg(vistaSystem, system);
		this.controladorSorteos = new ControladorSorteos(vistaSystem, system);
		this.controladorInicioCliente = new ControladorInicioCliente(vistaSystem, system);
		this.controladorNotificaciones = new ControladorNotificaciones(vistaSystem, system);
		this.controladorPerfil = new ControladorPerfil(vistaSystem, system);
		this.controladorCompraEntradas = new ControladorCompraEntradas(vistaSystem, system);
		this.controladorExpo = new ControladorExposicion(system, vistaSystem);
		this.controladorPerfilAdmin = new ControladorPerfilAdmin(vistaSystem, system);	
		this.controladorNotificacionesAdmin = new ControladorNotificacionesAdmin(vistaSystem, system);
		this.controladorPerfilStaff = new ControladorPerfilStaff(vistaSystem, system);
	
	}

	public ControladorCompraEntradas getControladorCompraEntradas() {
		return controladorCompraEntradas;
	}

	public ControladorClienteReg getControladorClienteReg() {
		return controladorClienteReg;
	}


	public ControladorExposicion getControladorExpo() {
		return controladorExpo;
	}

	public ControladorInicioSesion getControladorInicioSesion() {
		return controladorInicioSesion;
	}

	public ControladorVistaPrincipal getControladorVistaPrincipal() {
		return controladorVistaPrincipal;
	}

	public ControladorInicioCliente getControladorInicioCliente() {
		return controladorInicioCliente;
	}

	public ControladorSorteos getControladorSorteos() {
		return controladorSorteos;
	}

	public ControladorNotificaciones getControladorNotificaciones() {
		return controladorNotificaciones;
	}

	public ControladorPerfil getControladorPerfil() {
		return controladorPerfil;
	}

	public ControladorPerfilAdmin getControladorPerfilAdmin() {
		return controladorPerfilAdmin;
	}

	public ControladorNotificacionesAdmin getControladorNotificacionesAdmin() {
		return controladorNotificacionesAdmin;
	}

	public ControladorPerfilStaff getControladorPerfilStaff() {
		return controladorPerfilStaff;
	}
	
	
	
	
	
	
}
