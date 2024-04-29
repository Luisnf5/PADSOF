package systemTester;

import java.awt.EventQueue;

import controladores.Controlador;
import system.ArtGallery;
import vistasSystem.VistaSystem;

public class systemVision {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					VistaSystem frame = new VistaSystem();
					ArtGallery system = ArtGallery.getSystem();
					Controlador controlador = new Controlador(frame, system);
					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
