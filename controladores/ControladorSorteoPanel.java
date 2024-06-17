package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaInicioCliente;
import vistasUsers.VistaSorteoPanel;

public class ControladorSorteoPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaSorteoPanel vistaSorteoPanel;

	public ControladorSorteoPanel(VistaSystem vistaSystem, ArtGallery system, VistaSorteoPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaSorteoPanel = vista;
		
		vista.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Client cl;
		if (!(system.getLoggedUser() instanceof Client)) {
			JOptionPane.showMessageDialog(null, "Debe registrase como Cliente \npara poder registrarse en un sorteo");
			return;
		}else {
			cl = (Client) system.getLoggedUser();
		}
		String format = "\\d{2}/\\d{2}/\\d{4}/\\d{2}";
		String fechaString = vistaSorteoPanel.getSelectedHora().getText(); 
		LocalDateTime fecha;
		int dia;
		int mes;
		int año;
		int hora;
		
		if (!fechaString.matches(format)) {
			JOptionPane.showMessageDialog(null, "Introduzca la hora y el día deseado para la\n entrada del sorteo con el formato: DD/MM/YYYY/HH");
			return;
		}else {
			dia = Integer.parseInt(fechaString.split("/")[0]);
			mes = Integer.parseInt(fechaString.split("/")[1]);
			año = Integer.parseInt(fechaString.split("/")[2]);
			hora = Integer.parseInt(fechaString.split("/")[3]);
			fecha = LocalDateTime.of(año, mes, dia, hora, 0);
		}
		if (!cl.participateRaffle(this.vistaSorteoPanel.getSorteo().getExhibition(), fecha)){
			JOptionPane.showMessageDialog(null, "La fecha seleccionada '" + fecha + "' no está disponible o no es válida");
			return;
		}else {
			JOptionPane.showMessageDialog(null, "Te has registrado en el sorteo '" + this.vistaSorteoPanel.getSorteo().getTitle() + "' correctamente");
			this.vistaSorteoPanel.updatePart();
			return;
		}
	}
	


}
