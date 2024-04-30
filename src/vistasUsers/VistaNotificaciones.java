package vistasUsers;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controladores.ControladorNotificacionPanel;
import controladores.ControladorSorteoPanel;
import users.Notification;
import users.Raffle;
import vistasSystem.VistaSystem;

public class VistaNotificaciones extends JPanel{
	private VistaSystem parent;
	
	private JButton sorteos;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;
	private JScrollPane scroll;
	private JLabel empty;
	private JPanel scrollAux;

	
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
		
		this.scrollAux = new JPanel(new GridLayout(0, 1));
		this.scroll = new JScrollPane(scrollAux);
		scroll.setPreferredSize(new Dimension(1200, 700));
		this.empty = new JLabel("No tienes nuevas notificaciones");
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroll, 950, SpringLayout.WEST, this);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
		
		
		scrollAux.add(empty);
		empty.setVisible(false);
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

	}
	
	public void updateNotificaciones(Set<Notification> notis) {
		VistaNotificacionPanel aux;
		
		scrollAux.removeAll();
		scrollAux.add(empty);
		
		if (notis.isEmpty() || notis == null) {
			this.empty.setVisible(true);
			System.out.println("esta vacio");
		}else {
			this.empty.setVisible(false);
			for (Notification not : notis) {
				aux = new VistaNotificacionPanel(parent, not); 
				this.scrollAux.add(aux);
				new ControladorNotificacionPanel(parent, null, aux);
			}
			this.empty.setVisible(false);
			this.scroll.setVisible(true);
			this.revalidate();
			this.repaint();
			
		}
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
	}
}