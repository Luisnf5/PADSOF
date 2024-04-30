package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;

import vistasSystem.VistaSystem;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VistaExposicion extends JPanel {
	
	private JLabel nombreExp;
	private JLabel fecha;
	private VistaSystem parent;
	private static final long serialVersionUID = 1L;
	private JButton buton;
	private JButton notificaciones;
	private JButton sorteos;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;
	
	public VistaExposicion(VistaSystem parent) {
		this.parent = parent;
		
		SpringLayout springLayout = new SpringLayout();
		this.setLayout(springLayout);
		this.notificaciones = new JButton("Notificaciones");
		this.sorteos = new JButton("Sorteos");
		this.perfil = new JButton("Mi Perfil");
		this.buscar = new JButton("Buscar");
		this.principal = new JButton("Principal");
		String pathLogo = VistaPrincipal.class.getResource("logo.png").getPath();
		ImageIcon logo = new ImageIcon(pathLogo);
		this.principal.setIcon(logo);
		
		springLayout.putConstraint(SpringLayout.NORTH, principal, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, principal, 50, SpringLayout.WEST, this);
		principal.setPreferredSize(new Dimension(150, 40));
		this.add(principal);
		
		springLayout.putConstraint(SpringLayout.NORTH, sorteos, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, sorteos, -250, SpringLayout.EAST, this);
		this.add(sorteos);
		
		springLayout.putConstraint(SpringLayout.NORTH, notificaciones, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, notificaciones, -130, SpringLayout.EAST, this);
		this.add(notificaciones);
		
		springLayout.putConstraint(SpringLayout.NORTH, perfil, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, perfil, -45, SpringLayout.EAST, this);
		this.add(perfil);
		
		springLayout.putConstraint(SpringLayout.NORTH, buscar, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buscar, -800, SpringLayout.EAST, this);
		buscar.setPreferredSize(new Dimension(300, 25));
		this.add(buscar);
		

		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void setControlador(ActionListener c) {
		
	}

	
}
