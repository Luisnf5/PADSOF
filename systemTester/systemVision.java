package systemTester;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import controladores.Controlador;
import system.ArtGallery;
import vistasSystem.VistaSystem;

public class systemVision {
	static boolean load = false;
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					VistaSystem frame = new VistaSystem();
					ArtGallery system = ArtGallery.getSystem();
					Controlador controlador = new Controlador(frame, system);
					frame.setControlador(controlador);
					frame.setVisible(true);
					ArtGallery.getSystem().readSistem();
				} catch (FileNotFoundException ex) {
					changeLoad(true);
				}
				
				if (load) SystemManual.loadInfoExample();
			}
		});
	}
	
	
	static private void changeLoad(boolean b) {
		load = b;
	}
}
