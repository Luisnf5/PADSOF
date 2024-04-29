package controladores;


import system.ArtGallery;
import vistasSystem.VistaSystem;

public class Controlador {
	private ArtGallery sytem;
	private VistaSystem ventana;
	
	
	
	private ControladorClienteReg controladorClienteReg;
	private ControladorExposicion controladorExpo;
	private ControladorInicioSesion controladorInicioSesion;
	private ControladorVistaPrincipal controladorVistaPrincipal;
	
	public Controlador(VistaSystem vistaSystem, ArtGallery system) {
		this.ventana = vistaSystem;
		this.controladorInicioSesion = new ControladorInicioSesion(vistaSystem, system);
		this.controladorVistaPrincipal = new ControladorVistaPrincipal(vistaSystem, system);
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
	
	
	
}
