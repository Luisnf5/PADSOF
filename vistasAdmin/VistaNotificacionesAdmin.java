package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controladores.ControladorNotificacionPanel;
import users.Notification;
import vistasSystem.VistaSystem;
import vistasUsers.VistaNotificacionPanel;
import vistasUsers.VistaPrincipal;

public class VistaNotificacionesAdmin extends JPanel{
	private VistaSystem parent;
	
	private JButton sorteos;
	private JButton perfil;
	private JButton buscar;
	private JButton principal;
	private JScrollPane scroll;
	private JLabel empty;
	private JPanel scrollAux;
	
	private JPanel newNot;
	private JTextField titulo;
	private JScrollPane descripcionScroll;
	private JTextArea descripcion;
	
	private Set<JCheckBox> checks = new LinkedHashSet<>();
	
	private JButton enviar;
	

	
	public VistaNotificacionesAdmin(VistaSystem parent) {
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
		scroll.setPreferredSize(new Dimension(400, 700));
		
		layout.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scroll, 1300, SpringLayout.WEST, this);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalScrollBar = scroll.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(40);
        this.add(scroll);
        
        newNot = new JPanel();
        SpringLayout newNotLayout = new SpringLayout();
        newNot.setPreferredSize(new Dimension(800, 700));
        newNot.setBackground(Color.LIGHT_GRAY);
        newNot.setLayout(newNotLayout);
        
        enviar = new JButton("Enviar");
        enviar.setBackground(Color.GREEN);
        
        titulo = new JTextField("Título ejemplo");
        descripcion = new JTextArea("Descripción Ejemplo");
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);
        descripcionScroll = new JScrollPane(descripcion);
        
        newNotLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titulo, 0, SpringLayout.HORIZONTAL_CENTER, newNot);
        newNotLayout.putConstraint(SpringLayout.NORTH, titulo, 10, SpringLayout.NORTH, newNot);
		titulo.setPreferredSize(new Dimension(100, 25));
		newNot.add(titulo);
		
		newNotLayout.putConstraint(SpringLayout.NORTH, descripcionScroll, 30, SpringLayout.SOUTH, titulo);
		newNotLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, descripcionScroll, 0, SpringLayout.	HORIZONTAL_CENTER, newNot);
		descripcionScroll.setPreferredSize(new Dimension(500, 300));
		newNot.add(descripcionScroll);
		
		newNotLayout.putConstraint(SpringLayout.NORTH, enviar, 50, SpringLayout.SOUTH, descripcionScroll);
		newNotLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enviar, 0, SpringLayout.	HORIZONTAL_CENTER, newNot);
		enviar.setPreferredSize(new Dimension(100, 50));
		newNot.add(enviar);
		
		
		layout.putConstraint(SpringLayout.NORTH, newNot, 150, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.EAST, newNot, -10, SpringLayout.WEST, scroll);
		
		this.add(newNot);
		
		
		
		
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
		enviar.addActionListener(c);
	}
	
	public void updateClients(Set<String> clients) {
		JCheckBox nifAux;
		checks.clear();
		scrollAux.removeAll();
		
		for (String cl : clients) {
			nifAux = new JCheckBox(cl);
			nifAux.setSelected(false);
			scrollAux.add(nifAux);
			checks.add(nifAux);
		}
		
		titulo.setText("Título Ejemplo");
		descripcion.setText("Descripción ejemplo");
		
		this.revalidate();
		this.repaint();
	}
	
	public Set<JCheckBox> getChecks() {
		return checks;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public JTextArea getDescripcion() {
		return descripcion;
	}
	

}