package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import vistasAdmin.VistaExposicionEditPanel;
import vistasSystem.VistaSystem;
import works.Exhibition;
import works.ExhibitionStatus;

public class ControladorExposicionEditPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaExposicionEditPanel vistaExposicionEditPanel;
	
	public ControladorExposicionEditPanel(VistaSystem vistaSystem, ArtGallery system, VistaExposicionEditPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaExposicionEditPanel = vista;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		
		Exhibition ex;
		ex = vistaExposicionEditPanel.getExposicion();
		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
		String fechaInicio = vistaExposicionEditPanel.getFechaInicio().getText();
		String fechaFinal = vistaExposicionEditPanel.getFechaFinal().getText();
		LocalDate fechaInicioLDT;
		LocalDate fechaFinalLDT;
		int diaInicio;
		int mesInicio;
		int añoInicio;
		
		int diaFinal;
		int mesFinal;
		int añoFinal;

		if (selected.getText().equals("Publicar Exposición")){
			if (vistaExposicionEditPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaExposicionEditPanel.getAutor().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El autor no puede estar vacío");
				return;
			}else if (!(fechaInicio.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de inicio válida con el formato: DD/MM/YYYY");
				return;
			}else if (!(fechaFinal.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de final válida con el formato: DD/MM/YYYY");
				return;
			}
			
			diaInicio = Integer.parseInt(fechaInicio.split("/")[0]);
			mesInicio = Integer.parseInt(fechaInicio.split("/")[1]);
			añoInicio = Integer.parseInt(fechaInicio.split("/")[2]);
			fechaInicioLDT = LocalDate.of(añoInicio, mesInicio, diaInicio);
			
			diaFinal = Integer.parseInt(fechaFinal.split("/")[0]);
			mesFinal = Integer.parseInt(fechaFinal.split("/")[1]);
			añoFinal = Integer.parseInt(fechaFinal.split("/")[2]);
			fechaFinalLDT = LocalDate.of(añoFinal, mesFinal, diaFinal);
			
			if (!fechaInicioLDT.isEqual(ex.getStartDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED || ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha de inicio de una exposición una vez publicada");
				return;
			}else if (fechaInicioLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha de inicio anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha final anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final a una anterior a la propuesta una vez publicada la exposición");
				return;
			}else if (!fechaFinalLDT.isEqual(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final de una exposición una vez cancelada");
				return;
			}
			
			ex.setTitle(vistaExposicionEditPanel.getNombre().getText());
			ex.setAuthor(vistaExposicionEditPanel.getAutor().getText());
			ex.setStartDate(LocalDateTime.of(añoInicio, mesInicio, diaInicio, 10, 0));
			ex.setEndDate(LocalDateTime.of(añoFinal, mesFinal, diaFinal, 20, 0));
			ex.publishExposition();
			

			JOptionPane.showMessageDialog(null, "La exposición se ha publicado correctamente");
		}else if (selected.getText().equals("Editar Exposición")) {
			if (vistaExposicionEditPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaExposicionEditPanel.getAutor().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El autor no puede estar vacío");
				return;
			}else if (!(fechaInicio.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de inicio válida con el formato: DD/MM/YYYY");
				return;
			}else if (!(fechaFinal.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de final válida con el formato: DD/MM/YYYY");
				return;
			}
			
			diaInicio = Integer.parseInt(fechaInicio.split("/")[0]);
			mesInicio = Integer.parseInt(fechaInicio.split("/")[1]);
			añoInicio = Integer.parseInt(fechaInicio.split("/")[2]);
			fechaInicioLDT = LocalDate.of(añoInicio, mesInicio, diaInicio);
			
			diaFinal = Integer.parseInt(fechaFinal.split("/")[0]);
			mesFinal = Integer.parseInt(fechaFinal.split("/")[1]);
			añoFinal = Integer.parseInt(fechaFinal.split("/")[2]);
			fechaFinalLDT = LocalDate.of(añoFinal, mesFinal, diaFinal);
			
			if (!fechaInicioLDT.isEqual(ex.getStartDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED || ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha de inicio de una exposición una vez publicada");
				return;
			}else if (fechaInicioLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha de inicio anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha final anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final a una anterior a la propuesta una vez publicada la exposición");
				return;
			}else if (!fechaFinalLDT.isEqual(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final de una exposición una vez cancelada");
				return;
			}
			
			ex.setTitle(vistaExposicionEditPanel.getNombre().getText());
			ex.setAuthor(vistaExposicionEditPanel.getAutor().getText());
			ex.setStartDate(LocalDateTime.of(añoInicio, mesInicio, diaInicio, 10, 0));
			ex.setEndDate(LocalDateTime.of(añoFinal, mesFinal, diaFinal, 20, 0));
			

			JOptionPane.showMessageDialog(null, "La exposición se ha publicado correctamente");
		}else if (selected.getText().equals("Cancelar Exposición")) {
			ex.cancelExibition();
			JOptionPane.showMessageDialog(null, "La exposición se ha cancelado correctamente y terminará de aqui a 7 días");
		}else if (selected.getText().equals("Crear Exposición")) {
			if (vistaExposicionEditPanel.getNombre().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaExposicionEditPanel.getAutor().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El autor no puede estar vacío");
				return;
			}else if (!(fechaInicio.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de inicio válida con el formato: DD/MM/YYYY");
				return;
			}else if (!(fechaFinal.matches(patronFecha))) {
				JOptionPane.showMessageDialog(null, "Introduzca una Fecha de final válida con el formato: DD/MM/YYYY");
				return;
			}
			
			diaInicio = Integer.parseInt(fechaInicio.split("/")[0]);
			mesInicio = Integer.parseInt(fechaInicio.split("/")[1]);
			añoInicio = Integer.parseInt(fechaInicio.split("/")[2]);
			fechaInicioLDT = LocalDate.of(añoInicio, mesInicio, diaInicio);
			
			diaFinal = Integer.parseInt(fechaFinal.split("/")[0]);
			mesFinal = Integer.parseInt(fechaFinal.split("/")[1]);
			añoFinal = Integer.parseInt(fechaFinal.split("/")[2]);
			fechaFinalLDT = LocalDate.of(añoFinal, mesFinal, diaFinal);
			
			if (!fechaInicioLDT.isEqual(ex.getStartDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED || ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha de inicio de una exposición una vez publicada");
				return;
			}else if (fechaInicioLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha de inicio anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "No se puede poner una fecha final anterior a la fecha actual");
				return;
			}else if (fechaFinalLDT.isBefore(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.PUBLISHED)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final a una anterior a la propuesta una vez publicada la exposición");
				return;
			}else if (!fechaFinalLDT.isEqual(ex.getEndDate().toLocalDate()) && (ex.getStatus() == ExhibitionStatus.ENDING)) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la fecha final de una exposición una vez cancelada");
				return;
			}
			
			ex.setTitle(vistaExposicionEditPanel.getNombre().getText());
			ex.setAuthor(vistaExposicionEditPanel.getAutor().getText());
			ex.setStartDate(LocalDateTime.of(añoInicio, mesInicio, diaInicio, 10, 0));
			ex.setEndDate(LocalDateTime.of(añoFinal, mesFinal, diaFinal, 20, 0));
			ex.setStatus(ExhibitionStatus.DRAFT);
			
			system.createExhibition(ex);
			

			JOptionPane.showMessageDialog(null, "La exposición se ha creado correctamente");
		}
	}

}
