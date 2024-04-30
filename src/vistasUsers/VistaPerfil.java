
package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import system.ArtGallery;
import users.User;
import vistasSystem.VistaSystem;

public class VistaPerfil extends JPanel{
private VistaSystem parent;
	
	private JButton sorteos;
	private JButton notificaciones;
	private JButton buscar;
	private JButton principal;
	private JButton datos;
	private JButton contra;
	private JButton cerrar;
	
	
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
		
		this.datos = new JButton("Datos Personales");
		this.datos.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.datos);
		
		layout.putConstraint(SpringLayout.NORTH, datos, 70, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, datos, -50, SpringLayout.EAST, this);
		
		this.contra = new JButton("Cambiar Contraseña");
		this.contra.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.contra);
		
		layout.putConstraint(SpringLayout.NORTH, contra, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, contra, -50, SpringLayout.EAST, this);
		
		this.cerrar = new JButton("Cerrar Sesion");
		this.cerrar.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.cerrar);
		
		layout.putConstraint(SpringLayout.NORTH, cerrar, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, cerrar, -50, SpringLayout.EAST, this);
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		notificaciones.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
		datos.addActionListener(c);
		contra.addActionListener(c);
		cerrar.addActionListener(c);
	}
	
	public void showDatos(User u) {
		if(u == null)
			return;
		
		JLabel nombre = new JLabel("Nombre: " + u.getName());
		JLabel apellido = new JLabel("Apellido: " + u.getSurname());
		JLabel nif = new JLabel("NIF: " + u.getNif());
		JLabel genero = new JLabel("Genero: " + u.getGender());
		JLabel fecha = new JLabel("Fecha de Nacimiento: " + u.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		
		
	}
}
