package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import es.uam.eps.padsof.tickets.NonExistentFileException;
import es.uam.eps.padsof.tickets.UnsupportedImageTypeException;
import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaCompraEntradas;
import works.Exhibition;

public class ControladorCompraEntradas implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaCompraEntradas vistaCompraEntradas;

	public ControladorCompraEntradas(VistaSystem vistaSystem, ArtGallery system) {
		this.vistaSystem = vistaSystem;
		this.system = system;
		
		this.vistaCompraEntradas = vistaSystem.getVistaCompraEntradas();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton selected;
		selected = (JButton) e.getSource();
		
		Client cl;
		
		String format = "\\d{2}/\\d{2}/\\d{4}/\\d{2}";
        String fechaString = vistaCompraEntradas.getFechaElegida().getText();
        LocalDateTime fecha;
        int dia;
        int mes;
        int año;
        int hora;
		
		if (selected.getText().equals("Volver")) {
			vistaCompraEntradas.setVisible(false);
			vistaSystem.getVistaInicioCliente().setVisible(true);
		}else if (selected.getText().equals("Comprar")) {
			Exhibition ex = this.vistaCompraEntradas.getExhibition();
			
			int numEntradas = Integer.parseInt(vistaCompraEntradas.getSeleccion().getText());
			if (numEntradas < 1) {
				JOptionPane.showMessageDialog(null, "El numero de entradas no puede ser menor que 1");
	            return;
			}
			if (!fechaString.matches(format)) {
	            JOptionPane.showMessageDialog(null, "Introduzca la hora y el día deseado para la\n entrada del sorteo con el formato: DD/MM/YYYY/HH");
	            return;
	        }
			dia = Integer.parseInt(fechaString.split("/")[0]);
            mes = Integer.parseInt(fechaString.split("/")[1]);
            año = Integer.parseInt(fechaString.split("/")[2]);
            hora = Integer.parseInt(fechaString.split("/")[3]);
            fecha = LocalDateTime.of(año, mes, dia, hora, 0);
            
            cl = (Client) system.getLoggedUser();
            
            if (ex.getCapacityHour(fecha) == -1) {
            	JOptionPane.showMessageDialog(null, "La fecha seleccionada no está dentro del rango de fechas posibles");
	            return;
            }else if (ex.getCapacityHour(fecha) < numEntradas){
            	JOptionPane.showMessageDialog(null, "No hay capacidad para " + numEntradas +", solo quedan " + this.vistaCompraEntradas.getExhibition().getCapacityHour(fecha) + " entradas para esta hora");
	            return;
            }else if (cl.getBankAccount() == null){
            	JOptionPane.showMessageDialog(null, "No tiene ninguna cuenta bancaria asociada a su cuenta");
	            return;
            }else if (!TeleChargeAndPaySystem.isValidCardNumber(cl.getBankAccount())){
            	JOptionPane.showMessageDialog(null, "Su tarjeta bancaria no es válida");
	            return;
            }else {
            	try {
					ex.payTicket(cl, fecha, numEntradas, cl.getBankAccount(), ex.getPrice());
				} catch (NonExistentFileException | OrderRejectedException | UnsupportedImageTypeException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "El pago no se pudo procesar");
					return;
				}
				JOptionPane.showMessageDialog(null, "Se ha/n comprado la/s entrada/s correctamente");
				return;
				
            }
		}
			
		
	}
}
 	