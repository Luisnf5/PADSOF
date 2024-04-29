package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import system.ArtGallery;
import works.Exhibition;

public class ControladorExposicion implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public String getExposicion() {
		for(Exhibition e: ArtGallery.getSystem().getExhibitions()) {
			
		}
		return "";
	}
	
}
