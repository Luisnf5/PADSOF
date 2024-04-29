package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controladores.ControladorSorteos;
import vistasSystem.VistaSystem;

public class VistaSorteos extends JPanel{

	private VistaSystem parent;
	
	private JButton notificaciones;
	private JButton perfil;
	private JButton buscar;
	
	public VistaSorteos(VistaSystem parent) {
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.parent = parent;
		
		this.notificaciones = new JButton("Notificaciones");
		this.perfil = new JButton("Mi Perfil");
		this.buscar = new JButton("Buscar");
		

		
		layout.putConstraint(SpringLayout.NORTH, notificaciones, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, notificaciones, -130, SpringLayout.EAST, this);
		this.add(notificaciones);
		
		layout.putConstraint(SpringLayout.NORTH, perfil, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, perfil, -45, SpringLayout.EAST, this);
		this.add(perfil);
		
		layout.putConstraint(SpringLayout.NORTH, buscar, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, buscar, -800, SpringLayout.EAST, this);
		buscar.setPreferredSize(new Dimension(300, 25));
		this.add(buscar);
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}

	public void setControlador(ActionListener c) {
		notificaciones.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
	}
}