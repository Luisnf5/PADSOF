
package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;

public class VistaPerfil extends JPanel{
private VistaSystem parent;
	
	private JButton sorteos;
	private JButton notificaciones;
	private JButton buscar;
	private JButton principal;

	
	public VistaPerfil(VistaSystem parent) {
		super();
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.parent = parent;
		
		
		this.sorteos = new JButton("Sorteos");
		this.notificaciones = new JButton("Notificaciones");
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
		
		layout.putConstraint(SpringLayout.NORTH, notificaciones, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, notificaciones, -130, SpringLayout.EAST, this);
		this.add(notificaciones);
		
		
		layout.putConstraint(SpringLayout.NORTH, buscar, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, buscar, -800, SpringLayout.EAST, this);
		buscar.setPreferredSize(new Dimension(300, 25));
		this.add(buscar);
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		notificaciones.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
	}
}
