package vistasUsers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;

public class VistaNotificaciones extends JPanel{
	private VistaSystem parent;
	
	private JButton sorteos;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;

	
	public VistaNotificaciones(VistaSystem parent) {
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.parent = parent;
		
		this.sorteos = new JButton("Sorteos");
		this.perfil = new JButton("Mi Perfil");
		this.buscar = new JButton("Buscar");
		this.principal = new JButton("Principal");
		String pathLogo = VistaPrincipal.class.getResource("logo.png").getPath();
		ImageIcon logo = new ImageIcon(pathLogo);
		this.principal.setIcon(logo);
		
		layout.putConstraint(SpringLayout.NORTH, principal, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, principal, 50, SpringLayout.WEST, this);
		principal.setPreferredSize(new Dimension(150, 40));
		this.add(principal);
		
		
		layout.putConstraint(SpringLayout.NORTH, sorteos, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, sorteos, -250, SpringLayout.EAST, this);
		this.add(sorteos);
		
		
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
		sorteos.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
	}
}