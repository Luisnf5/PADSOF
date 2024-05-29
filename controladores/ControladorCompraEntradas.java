package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.ArtGallery;
import users.Client;
import vistasSystem.VistaSystem;
import vistasUsers.VistaClienteReg;
import vistasUsers.VistaCompraEntradas;

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
            
            if (!(cl.buyTickets(this.vistaCompraEntradas.getExhibition(), fecha))) {
            	JOptionPane.showMessageDialog(null, "La fecha seleccionada '" + fecha + "' no está disponible o no es válida");
	            return;
            }else {
            	
            	for (int i=1; i<numEntradas; i++) {
            		if (!(cl.buyTickets(this.vistaCompraEntradas.getExhibition(), fecha))) {
                    	JOptionPane.showMessageDialog(null, "La fecha seleccionada '" + fecha + "' no está disponible o no es válida\n Se han podido comprar " + i + " entradas");
                    	System.out.println(cl.getTickets());
        	            return;
                    }
            	}
            	
            	JOptionPane.showMessageDialog(null, "Las entrada/s se ha comprado con éxito");
            	vistaSystem.getVistaInicioCliente().setVisible(true);
            	vistaCompraEntradas.setVisible(false);
            	System.out.println(cl.getTickets());
            	
	            return;
            }
		}
			
		
	}
}
 	