package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import vistasUsers.VistaInicioCliente;
import vistasUsers.VistaSorteoPanel;

public class ControladorSorteoPanel implements ActionListener{
	private ArtGallery system;
	private VistaSystem vistaSystem;
	
	private VistaSorteoPanel vistaSorteoPanel;

	public ControladorSorteoPanel(VistaSystem vistaSystem, ArtGallery system, VistaSorteoPanel vista) {
		super();
		this.system = system;
		this.vistaSystem = vistaSystem;
		this.vistaSorteoPanel = vista;
		
		vista.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "faaak");
	}
	


}
