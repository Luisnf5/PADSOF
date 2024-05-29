package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;

import controladores.Controlador;
import controladores.ControladorExposicionPanel;
import system.ArtGallery;
import vistasSystem.VistaSystem;

/*NO se deberia hacer el import, ya que los controladores pierden sentido
pero preferimos que funcione */

import works.Exhibition;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaExposicion extends JPanel {
	
	
	private VistaSystem parent;
	private JPanel panelContenido;
	
	private JButton notificaciones;
	private JButton sorteos;
	private JButton perfil;
	private JButton principal;

	
	public VistaExposicion(VistaSystem parent) {
		
		this.parent = parent;
		SpringLayout thisspringLayout = new SpringLayout();
		setLayout(thisspringLayout);
		
		JScrollPane scroller = new JScrollPane();
		Dimension dThis = Toolkit.getDefaultToolkit().getScreenSize();
		dThis.height = 580;
		dThis.width -= 180;
		scroller.setPreferredSize(dThis);
		thisspringLayout.putConstraint(SpringLayout.VERTICAL_CENTER, scroller, 0, SpringLayout.VERTICAL_CENTER, this);
		thisspringLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroller, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		JScrollBar verticalScrollBar = scroller.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(40);
		
		scroller.setViewportView(panelContenido);
		this.add(scroller);
		
		
	
		//Paneles del scroll
		
		
		//Fuera del scroll
		this.notificaciones = new JButton("Notificaciones");
		this.sorteos = new JButton("Sorteos");
		this.perfil = new JButton("Mi Perfil");
		this.principal = new JButton("Principal");
		
		//FOTO
		String pathLogo = VistaPrincipal.class.getResource("logo.png").getPath();
		ImageIcon logo = new ImageIcon(pathLogo);
		this.principal.setIcon(logo);
		
		thisspringLayout.putConstraint(SpringLayout.NORTH, principal, 10, SpringLayout.NORTH, this);
		thisspringLayout.putConstraint(SpringLayout.WEST, principal, 50, SpringLayout.WEST, this);
		principal.setPreferredSize(new Dimension(150, 40));
		this.add(principal);
		
		thisspringLayout.putConstraint(SpringLayout.NORTH, sorteos, 10, SpringLayout.NORTH, this);
		thisspringLayout.putConstraint(SpringLayout.EAST, sorteos, -250, SpringLayout.EAST, this);
		this.add(sorteos);
		
		thisspringLayout.putConstraint(SpringLayout.NORTH, notificaciones, 10, SpringLayout.NORTH, this);
		thisspringLayout.putConstraint(SpringLayout.EAST, notificaciones, -130, SpringLayout.EAST, this);
		this.add(notificaciones);
		
		thisspringLayout.putConstraint(SpringLayout.NORTH, perfil, 10, SpringLayout.NORTH, this);
		thisspringLayout.putConstraint(SpringLayout.EAST, perfil, -45, SpringLayout.EAST, this);
		this.add(perfil);
		
		
		this.setBackground(Color.pink);
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void updateExhibitions(Set<Exhibition> ex) {
		
		panelContenido.removeAll();
		
		for(Exhibition e: ex) {
			VistaExposicionPanel v = new VistaExposicionPanel(parent, e);
			new ControladorExposicionPanel(null, parent, v);
			panelContenido.add(v);
			
		}
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		notificaciones.addActionListener(c);
		perfil.addActionListener(c);
		principal.addActionListener(c);
	}

	
}
