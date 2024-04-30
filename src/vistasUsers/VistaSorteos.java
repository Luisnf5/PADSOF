package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controladores.ControladorSorteos;
import users.Raffle;
import vistasSystem.VistaSystem;

public class VistaSorteos extends JPanel{

	private VistaSystem parent;
	
	private JButton notificaciones;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;
	private JScrollPane scroll;
	
	public VistaSorteos(VistaSystem parent) {
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.parent = parent;
		
		this.notificaciones = new JButton("Notificaciones");
		this.perfil = new JButton("Mi Perfil");
		this.buscar = new JButton("Buscar");
		this.principal = new JButton("Principal");
		String pathLogo = VistaPrincipal.class.getResource("logo.png").getPath();
		ImageIcon logo = new ImageIcon(pathLogo);
		this.principal.setIcon(logo);
		this.scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(500, 500));
		
		layout.putConstraint(SpringLayout.NORTH, principal, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, principal, 50, SpringLayout.WEST, this);
		principal.setPreferredSize(new Dimension(150, 40));
		this.add(principal);
		
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
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 200, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.WEST, scroll, (int) ((anchoPanel - scroll.getWidth())/2), SpringLayout.WEST, this);
		
		for (Raffle sorteo : parent.getControladorSorteos().getSorteos()) {
			scroll.add(new VistaSorteoPanel(sorteo)); //para cuando se crea esta vista el controlador aun no está creado por el orden en el que se crean las cosas en VistaSystem
		}
		
		this.add(scroll);
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}

	public void setControlador(ActionListener c) {
		notificaciones.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
	}
}