package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import vistasAdmin.VistaWorkEditPanel;
import vistasSystem.VistaSystem;
import works.Exhibition;
import works.Status;
import works.SubRoom;
import works.Work;

public class ControladorWorkEditPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaWorkEditPanel vistaWorkEditPanel;
	
	public ControladorWorkEditPanel(VistaSystem vistaSystem, ArtGallery system, VistaWorkEditPanel vista) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaWorkEditPanel = vista;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		
		Work ex;
		ex = vistaWorkEditPanel.getWork();

		String tempStr = vistaWorkEditPanel.getTemp().getText().replaceAll(",", ".");
		double temp = 0;
		
		String anchoStr = vistaWorkEditPanel.getAncho().getText().replaceAll(",", ".");
		double ancho = 0;
		
		String largoStr = vistaWorkEditPanel.getLargo().getText().replaceAll(",", ".");
		double largo = 0;
		
		String altoStr = vistaWorkEditPanel.getAlto().getText().replaceAll(",", ".");
		double alto = 0;
		
		
		try {
			temp = Double.parseDouble(tempStr);
		}catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(null, "La temperatura no es un valor válido.\nDebe tener formato XX,XX");
			return;
		}
		
		try {
			ancho = Double.parseDouble(anchoStr);
		}catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(null, "El ancho no es un valor válido.\nDebe tener formato XX,XX");
			return;
		}
		
		try {
			largo = Double.parseDouble(largoStr);
		}catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(null, "El largo no es un valor válido.\nDebe tener formato XX,XX");
			return;
		}
		
		try {
			alto = Double.parseDouble(altoStr);
		}catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(null, "El alto no es un valor válido.\nDebe tener formato XX,XX");
			return;
		}

		if (selected.getText().equals("Exponer Obra")){
			
			if (vistaWorkEditPanel.getTitle().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaWorkEditPanel.getAutor().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El autor no puede estar vacío");
				return;
			}else if (vistaWorkEditPanel.getExpo().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una exposición");
				return;
			}else if (vistaWorkEditPanel.getSala().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una sala");
				return;
			}
			
			Exhibition expo = system.getExhibitionFromName((String) vistaWorkEditPanel.getExpo().getSelectedItem());
			SubRoom room = expo.getRoomFromName((String)vistaWorkEditPanel.getSala().getSelectedItem());
			
			if (room.getHeight() < alto) {
				JOptionPane.showMessageDialog(null, "El alto de la obra es mayor al alto de la " + vistaWorkEditPanel.getSala().getSelectedItem() + " que es " + room.getHeight());
				return;
			}else if (room.getWidth() < ancho) {
				JOptionPane.showMessageDialog(null, "El ancho de la obra es mayor al ancho de la " + vistaWorkEditPanel.getSala().getSelectedItem() + " que es " + room.getWidth());
				return;
			}else if (room.getLength() < largo) {
				JOptionPane.showMessageDialog(null, "El largo de la obra es mayor al largo de la " + vistaWorkEditPanel.getSala().getSelectedItem() + " que es " + room.getLength());
				return;
			}else if (room.getTemperature() + 5 < temp || room.getTemperature() - 5 > temp) {
				JOptionPane.showMessageDialog(null, "La temperatura necesaria de la obra debe estar entre " + (room.getTemperature() + 5) + " y " + (room.getTemperature() - 5) + " para esta sala");
				return;
			}else if (room.isElectricity() == true && vistaWorkEditPanel.getElec().isSelected()) {
				JOptionPane.showMessageDialog(null, "La sala seleccionada no tiene el elemento Electricidad");
				return;
			}else if (!vistaWorkEditPanel.previousType().equals((String) vistaWorkEditPanel.getTipo().getSelectedItem())){
				JOptionPane.showMessageDialog(null, "No puedes modificar el tipo de obra una vez creada, vuelve a colocar el tipo " + vistaWorkEditPanel.previousType() + " para continuar");
				return;
			}
			
			ex.setTitle(vistaWorkEditPanel.getTitle().getText());
			ex.setAuthor(vistaWorkEditPanel.getAutor().getText());
			ex.setWidth(ancho);
			ex.setLenght(largo);
			ex.setHeight(alto);
			ex.setTemperature(temp); 
			ex.setElctricity(vistaWorkEditPanel.getElec().isSelected());
			
			expo.getRoomExhibitionFromName((String)vistaWorkEditPanel.getSala().getSelectedItem()).addWorks(ex);
			
			JOptionPane.showMessageDialog(null, "La obra se ha añadido correctamente a la exposición");
			vistaSystem.getVistaPerfilAdmin().updateInv(system.getInventory());
			return;
		}else if (selected.getText().equals("Editar Obra")) {
			if (ex.getSta() != Status.INVENTORY) {
				JOptionPane.showMessageDialog(null, "La obra debe estar en el inventario para poder editarla");
				return;
			}else if (vistaWorkEditPanel.getTitle().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
				return;
			}else if (vistaWorkEditPanel.getAutor().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "El autor no puede estar vacío");
				return;
			}
			
			ex.setTitle(vistaWorkEditPanel.getTitle().getText());
			ex.setAuthor(vistaWorkEditPanel.getAutor().getText());
			ex.setWidth(ancho);
			ex.setLenght(largo);
			ex.setHeight(alto);
			ex.setTemperature(temp);
			
			JOptionPane.showMessageDialog(null, "La obra se ha editado correctamente (no se ha modificado la sala a la que estuviera asignada)");
			vistaSystem.getVistaPerfilAdmin().updateInv(system.getInventory());
		}else if (selected.getText().equals("Devolver a Inventario")) {
			ex.getSubRoomExhibition().removeWork(ex.getTitle());
			
			JOptionPane.showMessageDialog(null, "La obra se ha devuelto al inventario (no se ha modificado ningún parámetro de la obra)");
			vistaSystem.getVistaPerfilAdmin().updateInv(system.getInventory());
		}
	}

}
