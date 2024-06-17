package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Raffle;
import vistasAdmin.VistaSorteoEditPanel;
import vistasSystem.VistaSystem;

public class ControladorSorteoEditPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaSorteoEditPanel vistaSorteoEditPanel;

	public ControladorSorteoEditPanel(VistaSystem vistaSystem, ArtGallery system, VistaSorteoEditPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaSorteoEditPanel = vista;
		
		vista.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton selected;
		selected = (AbstractButton) e.getSource();
		String selectedExpo = (String) vistaSorteoEditPanel.getExposicion().getSelectedItem();
		Raffle sorteo = vistaSorteoEditPanel.getSorteo();
		
		String format = "\\d{2}/\\d{2}/\\d{4}";
		String fechaInicioString = vistaSorteoEditPanel.getFechaInicio().getText(); 
		String fechaFinalString = vistaSorteoEditPanel.getFechaFinal().getText(); 
		System.out.println(fechaInicioString);
		System.out.println(fechaFinalString);
		LocalDate fechaInicio;
		LocalDate fechaFinal;
		int diaInicio;
		int mesInicio;
		int añoInicio;
		
		int diaFinal;
		int mesFinal;
		int añoFinal;
		
		if (vistaSorteoEditPanel.getTitulo().getText().length() < 1) {
			JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
			return;
		}else if (vistaSorteoEditPanel.getDescripcion().getText().length() < 1) {
			JOptionPane.showMessageDialog(null, "La descripción no puede estar vacía");
			return;
		}else if (!fechaInicioString.matches(format)) {
				JOptionPane.showMessageDialog(null, "La fecha de inicio debe tener formato DD/MM/YYYY");
				return;
		}else if (!fechaFinalString.matches(format)) {
			JOptionPane.showMessageDialog(null, "La fecha de final debe tener formato DD/MM/YYYY");
			return;
		}
		
		diaInicio = Integer.parseInt(fechaInicioString.split("/")[0]);
		mesInicio = Integer.parseInt(fechaInicioString.split("/")[1]);
		añoInicio = Integer.parseInt(fechaInicioString.split("/")[2]);
		
		diaFinal = Integer.parseInt(fechaFinalString.split("/")[0]);
		mesFinal = Integer.parseInt(fechaFinalString.split("/")[1]);
		añoFinal = Integer.parseInt(fechaFinalString.split("/")[2]);
		
		fechaInicio = LocalDate.of(añoInicio, mesInicio, diaInicio);
		fechaFinal = LocalDate.of(añoFinal, mesFinal, diaFinal);
		
		if (fechaInicio.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser posterior a la fecha actual");
			return;
		}else if (fechaInicio.isAfter(fechaFinal)) {
			JOptionPane.showMessageDialog(null, "La fecha de inicio debe ser anterior a la fecha final");
			return;
		}else if (fechaFinal.isAfter(system.searchExhibition(selectedExpo).getEndDate().toLocalDate())) {
			JOptionPane.showMessageDialog(null, "La fecha de final debe ser anterior a la fecha final de la exposición");
			return;
		}
		
		
		
		sorteo.setTitle(vistaSorteoEditPanel.getTitulo().getText());
		sorteo.setDescription(vistaSorteoEditPanel.getDescripcion().getText());
		sorteo.setStartDate(LocalDateTime.of(fechaInicio, LocalTime.of(10, 0)));
		sorteo.setEndDate(LocalDateTime.of(fechaFinal, LocalTime.of(20, 0)));
		
		System.out.println(sorteo.getTitle());
		System.out.println(sorteo.getDescription());
		System.out.println(sorteo.getStartDate());
		System.out.println(sorteo.getEndDate());
		
			
		if (selected.getText().equals("Editar Sorteo")) {
			if (!selectedExpo.equals(sorteo.getExhibition().getTitle())) {
				JOptionPane.showMessageDialog(null, "No se puede modificar la exposición de un sorteo ya creado");
				return;
			}
			JOptionPane.showMessageDialog(null, "El sorteo ha sido modificado correctamente");
			return;
		}else if (selected.getText().equals("Crear Sorteo")) {
			sorteo.setExhibition(system.searchExhibition(selectedExpo));
			if (system.searchExhibition(selectedExpo).getRaffle() != null) {
				JOptionPane.showMessageDialog(null, "El sorteo no se pudo crear porque la exposición seleccionada ya tiene un sorteo en curso.");
				return;
			}
			system.searchExhibition(selectedExpo).createRaffle(sorteo);
			JOptionPane.showMessageDialog(null, "El sorteo ha sido creado correctamente");
		}
	}
	
	

}
