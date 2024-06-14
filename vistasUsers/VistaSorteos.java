  
package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.function.ToLongBiFunction;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controladores.ControladorSorteoPanel;
import controladoresAdmin.ControladorSorteoEditPanel;
import system.ArtGallery;
import users.Client;
import users.Raffle;
import vistasAdmin.VistaSorteoEditPanel;
import vistasSystem.VistaSystem;

public class VistaSorteos extends JPanel{

	private VistaSystem parent;
	
	private JButton notificaciones;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;
	private JButton crearSorteo;
	private JScrollPane scroll;
	private JLabel emptySorteos;
	private JPanel scrollAux;
	Set<Raffle> sorteos;
	
	public VistaSorteos(VistaSystem parent) {
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.parent = parent;
		
		this.notificaciones = new JButton("Notificaciones");
		this.crearSorteo = new JButton("Crear Sorteo");
		crearSorteo.setBackground(Color.CYAN);
		this.perfil = new JButton("Mi Perfil");
		this.buscar = new JButton("Buscar");
		this.principal = new JButton("Principal");
		String pathLogo = VistaPrincipal.class.getResource("logo.png").getPath();
		ImageIcon logo = new ImageIcon(pathLogo);
		this.principal.setIcon(logo);
		this.scrollAux = new JPanel(new GridLayout(0, 1));
		this.scroll = new JScrollPane(scrollAux);
		
		Dimension dScroll = Toolkit.getDefaultToolkit().getScreenSize();
		dScroll.height -= 300;
		dScroll.width -= 450;
		
		scroll.setPreferredSize(dScroll);
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
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroll, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, scroll, 0, SpringLayout.VERTICAL_CENTER, this);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalscrollStaffBar = scroll.getVerticalScrollBar();
        verticalscrollStaffBar.setUnitIncrement(40);
        this.add(scroll);
        scroll.setVisible(true);
		
		
		this.add(emptySorteos);
		emptySorteos.setVisible(false);
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void updateSorteos(Set<Raffle> sorteos) {
		if (ArtGallery.getSystem().getLoggedUser() instanceof Client) {
			VistaSorteoPanel aux;
			
			scrollAux.removeAll();
			scrollAux.add(emptySorteos);
			
			if (sorteos.isEmpty()) {
				this.emptySorteos.setVisible(true);
				this.scroll.setVisible(true);
			}else {
				this.sorteos = sorteos;
				for (Raffle sorteo : sorteos) {
					if (sorteo.getStartDate().isBefore(LocalDateTime.now()) && sorteo.getEndDate().isAfter(LocalDateTime.now())) {
						aux = new VistaSorteoPanel(parent, sorteo); 
						this.scrollAux.add(aux);
						new ControladorSorteoPanel(parent, null, aux);
					}
				}
				this.emptySorteos.setVisible(false);
				this.scroll.setVisible(true);
			}
		}else {
			VistaSorteoEditPanel aux;
			
			scrollAux.removeAll();
			scrollAux.add(emptySorteos);
			
			if (sorteos.isEmpty()) {
				this.emptySorteos.setVisible(true);
				this.scroll.setVisible(true);
			}else {
				this.sorteos = sorteos;
				for (Raffle sorteo : sorteos) {
					aux = new VistaSorteoEditPanel(parent, sorteo, false); 
					this.scrollAux.add(aux);
					new ControladorSorteoEditPanel(parent, null, aux);
				}
				this.emptySorteos.setVisible(false);
				this.scroll.setVisible(true);
			}
			
			scrollAux.add(crearSorteo);
			
		}
	}

	public void setControlador(ActionListener c) {
		notificaciones.addActionListener(c);
		perfil.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
		crearSorteo.addActionListener(c);
	}
}