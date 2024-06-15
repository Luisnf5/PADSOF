package controladoresAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Gender;
import users.Privileges;
import users.Staff;
import vistasAdmin.VistaSalaPanel;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificacionPanel;
import works.SubRoom;

public class ControladorSalaPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	private boolean newRoom = false;
	
	private VistaSalaPanel vistaSalaPanel;
	
	public ControladorSalaPanel(VistaSystem vistaSystem, ArtGallery system, VistaSalaPanel vista, boolean newRoom) {
		super();
		this.system = vistaSystem.getControladorVistaPrincipal().getSystem(); 
		this.vistaSystem = vistaSystem;
		this.vistaSalaPanel = vista;
		this.newRoom = newRoom;
		
		vista.setControlador(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		String tempStr = vistaSalaPanel.getTemperature().getText().replaceAll(",", ".");
		String altoStr = vistaSalaPanel.getAlto().getText().replaceAll(",", ".");
		String anchoStr = vistaSalaPanel.getAncho().getText().replaceAll(",", ".");
		String largoStr = vistaSalaPanel.getLargo().getText().replaceAll(",", ".");
		String capacidadStr = vistaSalaPanel.getLargo().getText();
        double temp = 0, alto = 0, ancho = 0, largo = 0;
        int capacidad = 0;
        SubRoom r = vistaSalaPanel.getRoom();
		if (selected.getText().equals("Crear Sala")){
			try {
	            temp = Double.parseDouble(tempStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "La temperatura no es un valor válido.\nDebe tener formato XX,XX");
	            return;
	        }
			try {
	            alto = Double.parseDouble(altoStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "La altura no es un valor válido.\nDebe tener formato XX,XX");
	            return;
	        }
			try {
	            ancho = Double.parseDouble(anchoStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "La anchura no es un valor válido.\nDebe tener formato XX,XX");
	            return;
	        }
			try {
	            largo = Double.parseDouble(largoStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "El largo no es un valor válido.\nDebe tener formato XX,XX");
	            return;
	        }
			try {
	            capacidad = Integer.parseInt(capacidadStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "La capacidad no es un valor válido.\nDebe ser un número");
	            return;
	        }
			if (tempStr.length() < 1) {
				JOptionPane.showMessageDialog(null, "La temperatura no puede estar vacía");
				return;
			}else if(temp < 1) {
				JOptionPane.showMessageDialog(null, "La temperatura no puede ser negativa");
				return;
			}else if (altoStr.length() < 1) {
				JOptionPane.showMessageDialog(null, "La altura no puede estar vacía");
				return;
			}else if (alto < 1) {
				JOptionPane.showMessageDialog(null, "La altura no puede ser negativa");
				return;
			}else if (anchoStr.length() < 1) {
				JOptionPane.showMessageDialog(null, "La anchura no puede estar vacía");
				return;
			}else if (ancho < 1) {
				JOptionPane.showMessageDialog(null, "La anchura no puede ser negativa");
				return;
			}else if (largoStr.length() < 1) {
				JOptionPane.showMessageDialog(null, "El largo no puede estar vacío");
				return;
			}else if (largo < 1) {
				JOptionPane.showMessageDialog(null, "El largo no puede ser negativa");
				return;
			}
			else if (capacidadStr.length() < 1) {
				JOptionPane.showMessageDialog(null, "La capacidad no puede estar vacío");
				return;
			}else if (capacidad < 1) {
				JOptionPane.showMessageDialog(null, "La capacidad no puede ser negativa");
				return;
			}
			
			system.createSalaFisica(vistaSalaPanel.getElecticidad().isSelected(), temp, ancho, largo, alto, 10, capacidad);
				
		}else if (selected.getText().equals("Confirmar Cambios")) {
			try {
	            temp = Double.parseDouble(tempStr);
	        }catch (NumberFormatException exc) {
	            JOptionPane.showMessageDialog(null, "La temperatura no es un valor válido.\nDebe tener formato XX,XX");
	            return;
	        }
			if(vistaSalaPanel.getTemperature().getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "La temperatura no puede estar vacía");
				return;
			}
			else if(temp < 1) {
				JOptionPane.showMessageDialog(null, "La temperatura no puede ser negativa");
				return;
			}
			
		}else if(selected.getText().equals("Dividir Sala")) {
			
		}else {
			
		}
		
	}

}
