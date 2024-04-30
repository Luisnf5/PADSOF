
package vistasUsers;

import java.awt.Color;
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

import controladores.ControladorSorteoPanel;
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
	private JLabel emptySorteos;
	private JPanel scrollAux;
	Set<Raffle> sorteos;
	
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
		this.scrollAux = new JPanel(new GridLayout(0, 1));
		this.scroll = new JScrollPane(scrollAux);
		scroll.setPreferredSize(new Dimension(1200, 700));
		this.emptySorteos = new JLabel("No existen sorteos");
		
		
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
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroll, 950, SpringLayout.WEST, this);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
		
		
		this.add(emptySorteos);
		emptySorteos.setVisible(false);
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void updateSorteos(Set<Raffle> sorteos) {
		VistaSorteoPanel aux;
		
		scrollAux.removeAll();
		scrollAux.add(emptySorteos);
		
		if (sorteos.isEmpty()) {
			this.emptySorteos.setVisible(true);
			this.scroll.setVisible(false);
		}else {
			this.sorteos = sorteos;
			for (Raffle sorteo : sorteos) {
				aux = new VistaSorteoPanel(parent, sorteo); 
				this.scrollAux.add(aux);
				new ControladorSorteoPanel(parent, null, aux);
			}
			this.emptySorteos.setVisible(false);
			this.scroll.setVisible(true);
		}
	}

	public void setControlador(ActionListener c) {
		notificaciones.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
	}
}