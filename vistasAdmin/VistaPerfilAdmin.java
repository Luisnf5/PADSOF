
package vistasAdmin;

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
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

import controladoresAdmin.ControladorClientPanel;
import controladoresAdmin.ControladorStaffPanel;
import users.Admin;
import users.Client;
import users.Staff;
import vistasSystem.VistaSystem;
import vistasUsers.VistaPrincipal;

public class VistaPerfilAdmin extends JPanel{
private VistaSystem parent;
	
	private JButton sorteos;
	private JButton notificaciones;
	private JButton buscar;
	private JButton principal;
	private JButton datos;
	private JButton contra;
	private JButton cerrar;
	private JButton entradas;
	private JButton staff;
	private JButton salas;
	private JButton expos;
	private JButton users;
	
	//DATOS PERSONALES
	private JPanel personales;
	private JLabel nombreCliente;
	private JLabel apellidoCliente;
	private JLabel nifCliente;
	private JLabel generoCliente;
	private JLabel fechaCliente;
	
	//CAMBIO CONTRASEÑA
	private JPanel cambioContraseña;
	private JLabel contraseña1;
	private JLabel contraseña2;
	private JPasswordField nuevaContraseña;
	private JPasswordField nuevaContraseñaRepite;
	private JButton confirmarContraseña;
	
	private JLabel entradasCliente;

	//GESTIONAR STAFF
	private JPanel scrollStaffAux;
	private JScrollPane scrollStaff;
	private JButton crearStaff;
	
	//GESTIONAR USUARIOS
	private JPanel gestionUsuarios;
	private JPanel scrollUsersAux;
	private JScrollPane scrollUsers;
	private JToggleButton blockedUsers;
		
	
	
	
	public VistaPerfilAdmin(VistaSystem parent) {
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
		
		this.datos = new JButton("Datos Personales");
		this.datos.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.datos);
		
		layout.putConstraint(SpringLayout.NORTH, datos, 70, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, datos, -50, SpringLayout.EAST, this);
		
		this.entradas = new JButton("Ver Entradas");
		this.entradas.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.entradas);
		
		layout.putConstraint(SpringLayout.NORTH, entradas, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, entradas, -50, SpringLayout.EAST, this);
		
		
		
		this.contra = new JButton("Cambiar Contraseña");
		this.contra.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.contra);
		
		layout.putConstraint(SpringLayout.NORTH, contra, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, contra, -50, SpringLayout.EAST, this);
		
		
		
		this.staff = new JButton("Gestionar Staff");
		this.staff.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.staff);
		
		layout.putConstraint(SpringLayout.NORTH, staff, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, staff, -50, SpringLayout.EAST, this);
		
		
		this.salas = new JButton("Gestionar Salas");
		this.salas.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.salas);
		
		layout.putConstraint(SpringLayout.NORTH, salas, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, salas, -50, SpringLayout.EAST, this);
		
		
		this.expos = new JButton("Gestionar Exposiciones");
		this.expos.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.expos);
		
		layout.putConstraint(SpringLayout.NORTH, expos, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, expos, -50, SpringLayout.EAST, this);
		
		
		this.users = new JButton("Gestionar Usuarios");
		this.users.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.users);
		
		layout.putConstraint(SpringLayout.NORTH, users, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, users, -50, SpringLayout.EAST, this);
		
		
		
		this.cerrar = new JButton("Cerrar Sesion");
		this.cerrar.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.cerrar);
		
		layout.putConstraint(SpringLayout.NORTH, cerrar, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, cerrar, -50, SpringLayout.EAST, this);
		
		
		//PANEL DE DATOS PERSONALES
		personales = new JPanel();
		
		SpringLayout personalesLayout = new SpringLayout();
		personales.setLayout(personalesLayout);
		personales.setPreferredSize(new Dimension(400, 400));
		
		nombreCliente = new JLabel("Nombre: example");
		apellidoCliente = new JLabel("Apellido: example");
		nifCliente = new JLabel("NIF: 12345678X");
		generoCliente = new JLabel("Genero: example");
		fechaCliente = new JLabel("Fecha de Nacimiento: DD/MM/YYYY");
		
		layout.putConstraint(SpringLayout.NORTH, personales, 50, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.EAST, personales, -300, SpringLayout.EAST, this);
		personales.setBackground(Color.cyan);
		this.add(personales);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, nombreCliente, 20, SpringLayout.NORTH, personales);
		personalesLayout.putConstraint(SpringLayout.WEST, nombreCliente, 20, SpringLayout.WEST, personales);
		personales.add(nombreCliente);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, apellidoCliente, 20, SpringLayout.NORTH, personales);
		personalesLayout.putConstraint(SpringLayout.WEST, apellidoCliente, 20, SpringLayout.EAST, nombreCliente);
		personales.add(apellidoCliente);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, nifCliente, 20, SpringLayout.NORTH, personales);
		personalesLayout.putConstraint(SpringLayout.WEST, nifCliente, 20, SpringLayout.EAST, apellidoCliente);
		personales.add(nifCliente);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, generoCliente, 20, SpringLayout.NORTH, nombreCliente);
		personalesLayout.putConstraint(SpringLayout.WEST, generoCliente, 20, SpringLayout.WEST, personales);
		personales.add(generoCliente);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, fechaCliente, 20, SpringLayout.NORTH, nombreCliente);
		personalesLayout.putConstraint(SpringLayout.WEST, fechaCliente, 20, SpringLayout.EAST, generoCliente);
		personales.add(fechaCliente);
		
		personales.setVisible(false);
		
		//CAMBIO CONTRASEÑA
		cambioContraseña = new JPanel();
		
		SpringLayout cambioContraseñaLayout = new SpringLayout();
		cambioContraseña.setLayout(cambioContraseñaLayout);
		cambioContraseña.setPreferredSize(new Dimension(400, 400));
		
		contraseña1 = new JLabel("Nueva Contraseña");
		contraseña2 = new JLabel("Repita la Contraseña");
		nuevaContraseña = new JPasswordField(20);
		nuevaContraseñaRepite = new JPasswordField(20);
		confirmarContraseña = new JButton("Confirmar");
		
		layout.putConstraint(SpringLayout.NORTH, cambioContraseña, 50, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.EAST, cambioContraseña, -300, SpringLayout.EAST, this);
		cambioContraseña.setBackground(Color.pink);
		this.add(cambioContraseña);
		
		cambioContraseñaLayout.putConstraint(SpringLayout.NORTH, contraseña1, 20, SpringLayout.NORTH, cambioContraseña);
		cambioContraseñaLayout.putConstraint(SpringLayout.EAST, contraseña1, -50, SpringLayout.EAST, cambioContraseña);
		cambioContraseña.add(contraseña1);
		
		cambioContraseñaLayout.putConstraint(SpringLayout.NORTH, nuevaContraseña, 5, SpringLayout.SOUTH, contraseña1);
		cambioContraseñaLayout.putConstraint(SpringLayout.EAST, nuevaContraseña, -50, SpringLayout.EAST, cambioContraseña);
		cambioContraseña.add(nuevaContraseña);
		
		cambioContraseñaLayout.putConstraint(SpringLayout.NORTH, contraseña2, 50, SpringLayout.SOUTH, nuevaContraseña);
		cambioContraseñaLayout.putConstraint(SpringLayout.EAST, contraseña2, -50, SpringLayout.EAST, cambioContraseña);
		cambioContraseña.add(contraseña2);
		
		cambioContraseñaLayout.putConstraint(SpringLayout.NORTH, nuevaContraseñaRepite, 5, SpringLayout.SOUTH, contraseña2);
		cambioContraseñaLayout.putConstraint(SpringLayout.EAST, nuevaContraseñaRepite, -50, SpringLayout.EAST, cambioContraseña);
		cambioContraseña.add(nuevaContraseñaRepite);
		
		cambioContraseñaLayout.putConstraint(SpringLayout.NORTH, confirmarContraseña, 30, SpringLayout.SOUTH, nuevaContraseñaRepite);
		cambioContraseñaLayout.putConstraint(SpringLayout.EAST, confirmarContraseña, -50, SpringLayout.EAST, cambioContraseña);
		cambioContraseña.add(confirmarContraseña);
		
		cambioContraseña.setVisible(false);
		
		//ENTRADAS
		entradasCliente = new JLabel("");
		layout.putConstraint(SpringLayout.NORTH, entradasCliente, 50, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.EAST, entradasCliente, -300, SpringLayout.EAST, this);
		entradasCliente.setPreferredSize(new Dimension(600, 400));
		entradasCliente.setBackground(Color.LIGHT_GRAY);
		entradasCliente.setOpaque(true);
		this.add(entradasCliente);
		entradasCliente.setVisible(false);
		
		
		//GESTIONAR STAFF
		this.crearStaff = new JButton("Nuevo Empleado");
		crearStaff.setBackground(Color.CYAN);
		crearStaff.setPreferredSize(new Dimension(200, 100));
		this.scrollStaffAux = new JPanel(new GridLayout(0, 1));
		this.scrollStaff = new JScrollPane(scrollStaffAux);
		scrollStaff.setPreferredSize(new Dimension(1200, 700));
	
		layout.putConstraint(SpringLayout.NORTH, scrollStaff, 150, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollStaff, 950, SpringLayout.WEST, this);
		scrollStaff.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollStaff.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalscrollStaffBar = scrollStaff.getVerticalScrollBar();
        verticalscrollStaffBar.setUnitIncrement(40);
        this.add(scrollStaff);
        scrollStaff.setVisible(false);
        
        //GESTIONAR USUARIOS
        this.gestionUsuarios = new JPanel();
        SpringLayout usuariosLayout = new SpringLayout();
		gestionUsuarios.setLayout(usuariosLayout);
		gestionUsuarios.setPreferredSize(new Dimension(1100, 800));
		
		this.blockedUsers = new JToggleButton("Bloqueados");
		
		this.scrollUsersAux = new JPanel(new GridLayout(0, 1));
		this.scrollUsers = new JScrollPane(scrollUsersAux);
		scrollUsers.setPreferredSize(new Dimension(1100, 700));
	
		layout.putConstraint(SpringLayout.NORTH, gestionUsuarios, 100, SpringLayout.SOUTH, buscar);
		layout.putConstraint(SpringLayout.EAST, gestionUsuarios, -150, SpringLayout.WEST, cerrar);
		gestionUsuarios.setBackground(Color.LIGHT_GRAY);
		this.add(gestionUsuarios);
		
		usuariosLayout.putConstraint(SpringLayout.NORTH, blockedUsers, 30, SpringLayout.NORTH, gestionUsuarios);
		usuariosLayout.putConstraint(SpringLayout.EAST, blockedUsers, -550, SpringLayout.EAST, gestionUsuarios);
		gestionUsuarios.add(blockedUsers);
		
		usuariosLayout.putConstraint(SpringLayout.SOUTH, scrollUsers, 0, SpringLayout.SOUTH, gestionUsuarios);
		usuariosLayout.putConstraint(SpringLayout.EAST, scrollUsers, 0, SpringLayout.EAST, gestionUsuarios);
		scrollUsers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollUsers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalScrollUsersBar = scrollUsers.getVerticalScrollBar();
        verticalScrollUsersBar.setUnitIncrement(40);
        gestionUsuarios.add(scrollUsers);
        scrollUsers.setVisible(true);
        
		gestionUsuarios.setVisible(false);
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		notificaciones.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
		datos.addActionListener(c);
		contra.addActionListener(c);
		cerrar.addActionListener(c);
		confirmarContraseña.addActionListener(c);
		entradas.addActionListener(c);
		staff.addActionListener(c);
		salas.addActionListener(c);
		expos.addActionListener(c);
		crearStaff.addActionListener(c);
		blockedUsers.addActionListener(c);
		users.addActionListener(c);
	}
	
	public void updateDatos(Admin cl) {
		if(cl == null)
			return;
		
		nombreCliente.setText("Nombre: " + cl.getName());
		apellidoCliente.setText("Apellido: " + cl.getSurname());
		nifCliente.setText("NIF: " + cl.getNif());
		generoCliente.setText("Genero: " + cl.getGender());
		fechaCliente.setText("Fecha de Nacimiento: " + cl.getBirthDate());
		personales.setVisible(true);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(false);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(false);
	}
	
	public void updateCambioContraseña() {
		personales.setVisible(false);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(true);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(false);
		
	}
	
	public void updateStaff(Set<Staff> empleados) {
		VistaStaffPanel aux;
		
		scrollStaffAux.removeAll();
		
		
		if (empleados.isEmpty() || empleados == null) {
			System.out.println("esta vacio");
			scrollStaffAux.add(crearStaff);
		}else {
			for (Staff e : empleados) {
				aux = new VistaStaffPanel(parent, e); 
				this.scrollStaffAux.add(aux);
				new ControladorStaffPanel(parent, null, aux, false);
			}
			scrollStaffAux.add(crearStaff);
			this.revalidate();
			this.repaint();
			
		}
		
		
		personales.setVisible(false);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(false);
		scrollStaff.setVisible(true);
		crearStaff.setVisible(true);
		gestionUsuarios.setVisible(false);
		
	}
	
	public void updateUsers(Set<Client> clientes) {
		VistaClientPanel aux;
		
		scrollUsersAux.removeAll();
		System.out.println("all removed");
		
		
		if (clientes.isEmpty() || clientes == null) {
			System.out.println("esta vacio");
		}else {
			for (Client e : clientes) {
				System.out.println("added client");
				aux = new VistaClientPanel(parent, e); 
				this.scrollUsersAux.add(aux);
				new ControladorClientPanel(parent, null, aux);
			}
			this.revalidate();
			this.repaint();
			
		}
		
		
		personales.setVisible(false);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(false);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(true);
		
	}
	
	public void updateSalas() {
		personales.setVisible(false);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(false);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(false);
		
	}
	
	public void updateExpos() {
		personales.setVisible(false);
		entradasCliente.setVisible(false);
		cambioContraseña.setVisible(false);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(false);
		
	}
	
	public void updateEntradas(Admin cl) {
		cambioContraseña.setVisible(false);
		personales.setVisible(false);
		entradasCliente.setVisible(true);
		scrollStaff.setVisible(false);
		crearStaff.setVisible(false);
		gestionUsuarios.setVisible(false);
	}

	public JPasswordField getNuevaContraseña() {
		return nuevaContraseña;
	}

	public JPasswordField getNuevaContraseñaRepite() {
		return nuevaContraseñaRepite;
	}

	public JToggleButton getBlockedUsers() {
		return blockedUsers;
	}

	
	
	
	
	
}
