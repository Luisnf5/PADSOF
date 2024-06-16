
package vistasStaff;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

import controladoresAdmin.ControladorClientPanel;
import controladoresAdmin.ControladorExposicionEditPanel;
import controladoresAdmin.ControladorSalaPanel;
import controladoresAdmin.ControladorWorkEditPanel;
import users.Admin;
import users.Client;
import users.Staff;
import vistasAdmin.VistaClientPanel;
import vistasAdmin.VistaExposicionEditPanel;
import vistasAdmin.VistaSalaPanel;
import vistasAdmin.VistaWorkEditPanel;
import vistasSystem.VistaSystem;
import vistasUsers.VistaPrincipal;
import works.Exhibition;
import works.Inventory;
import works.SubRoom;
import works.Work;

public class VistaPerfilStaff extends JPanel{
private VistaSystem parent;
	
	private JButton sorteos;
	private JButton notificaciones;
	private JButton buscar;
	private JButton principal;
	private JButton datos;
	private JButton cerrar;
	private JButton salas;
	private JButton expos;
	private JButton users;
	private JButton inv;
	private JButton confirmarCambios;
	
	//DATOS PERSONALES
	private JPanel personales;
	private JLabel nombreCliente;
	private JLabel apellidoCliente;
	private JLabel nifCliente;
	private JLabel generoCliente;
	private JLabel fechaCliente;
	private JLabel cuentaBancariaLabel;
	private JTextField cuentaBancaria;
	
	
	//GESTIONAR USUARIOS
	private JPanel gestionUsuarios;
	private JPanel scrollUsersAux;
	private JScrollPane scrollUsers;
	private JToggleButton blockedUsers;
	
	//GESTIONAR EXPOSICIONES
	private JPanel scrollExpoAux;
	private JScrollPane scrollExpo;
	private JButton crearExpo;
	
	//GESTIONAR INVENTARIO
	private JPanel scrollInvAux;
	private JScrollPane scrollInv;
	private JButton crearObra;
	
	//GESTIONAR SALAS
	private JPanel scrollSalaAux;
	private JScrollPane scrollSala;
	private JButton crearSala;
		
	
	
	
	public VistaPerfilStaff(VistaSystem parent) {
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
		
		
		this.salas = new JButton("Gestionar Salas");
		this.salas.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.salas);
		
		layout.putConstraint(SpringLayout.NORTH, salas, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, salas, -50, SpringLayout.EAST, this);
		
		
		this.expos = new JButton("Gestionar Exposiciones");
		this.expos.setPreferredSize(new Dimension(170, 30));
		
		this.add(this.expos);
		
		layout.putConstraint(SpringLayout.NORTH, expos, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, expos, -50, SpringLayout.EAST, this);
		
		
		this.users = new JButton("Gestionar Usuarios");
		this.users.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.users);
		
		layout.putConstraint(SpringLayout.NORTH, users, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, users, -50, SpringLayout.EAST, this);
		
		this.inv = new JButton("Gestionar Inventario");
		this.inv.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.inv);
		
		layout.putConstraint(SpringLayout.NORTH, inv, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, inv, -50, SpringLayout.EAST, this);
		
		
		this.cerrar = new JButton("Cerrar Sesion");
		this.cerrar.setPreferredSize(new Dimension(150, 30));
		
		this.add(this.cerrar);
		
		layout.putConstraint(SpringLayout.NORTH, cerrar, 270, SpringLayout.NORTH, this);
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
		cuentaBancariaLabel = new JLabel("Cuenta Bancaria");
		cuentaBancaria = new JTextField("CUENTA_BANCARIA_AQUI");
		confirmarCambios = new JButton("Confirmar Cambios");
		
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
		
		personalesLayout.putConstraint(SpringLayout.NORTH, cuentaBancariaLabel, 20, SpringLayout.NORTH, generoCliente);
		personalesLayout.putConstraint(SpringLayout.WEST, cuentaBancariaLabel, 20, SpringLayout.WEST, personales);
		personales.add(cuentaBancariaLabel);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, cuentaBancaria, 20, SpringLayout.NORTH, generoCliente);
		personalesLayout.putConstraint(SpringLayout.WEST, cuentaBancaria, 20, SpringLayout.EAST, cuentaBancariaLabel);
		cuentaBancaria.setPreferredSize(new Dimension(210, 20));
		personales.add(cuentaBancaria);
		
		personalesLayout.putConstraint(SpringLayout.NORTH, confirmarCambios, 60, SpringLayout.NORTH, cuentaBancaria);
		personalesLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmarCambios, 0, SpringLayout.HORIZONTAL_CENTER, personales);
		personales.add(confirmarCambios);
		
		personales.setVisible(false);
		

		//original dimension
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        d.width -= 415;
        d.height -= 300;

        
        //GESTIONAR USUARIOS
        Dimension d3 = Toolkit.getDefaultToolkit().getScreenSize();
		d3.height -= 300;
		d3.width -= 400;
        this.gestionUsuarios = new JPanel();
        SpringLayout usuariosLayout = new SpringLayout();
		gestionUsuarios.setLayout(usuariosLayout);
		gestionUsuarios.setPreferredSize(d3);
		
		this.blockedUsers = new JToggleButton("Bloqueados");
		
		this.scrollUsersAux = new JPanel(new GridLayout(0, 1));
		this.scrollUsers = new JScrollPane(scrollUsersAux);
		
		
		scrollUsers.setPreferredSize(new Dimension(d3.width, d3.height -100));
	
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
		
		 //GESTIONAR SALAS
  		Dimension d5 = Toolkit.getDefaultToolkit().getScreenSize();
  		d5.width -= 415;
  		d5.height -= 300;
  		  
  		this.crearSala = new JButton("Crear Sala");
  		crearSala.setBackground(Color.CYAN);
  		crearSala.setPreferredSize(new Dimension(200, 100));
  		this.scrollSalaAux = new JPanel(new GridLayout(0, 1));
  		this.scrollSalaAux.setVisible(true);
  		this.scrollSala = new JScrollPane(scrollSalaAux);
  		scrollSalaAux.add(crearSala);
  		scrollSalaAux.setBackground(Color.GREEN);
  		
  		scrollSala.setPreferredSize(d5);
  		  
  		layout.putConstraint(SpringLayout.VERTICAL_CENTER, scrollSala, 0, SpringLayout.VERTICAL_CENTER, this);
  		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollSala, -70, SpringLayout.HORIZONTAL_CENTER, this);
  		scrollSala.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  		scrollSala.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  		JScrollBar verticalscrollSalaBar = scrollSala.getVerticalScrollBar();
  		verticalscrollSalaBar.setUnitIncrement(40);
  		this.add(scrollSala);
  		scrollSala.setVisible(false);
      	
		
		//GESTIONAR EXPOSICIONES
		Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
        d2.width -= 400;
        d2.height -= 300;
        
		this.crearExpo = new JButton("Nueva Exposición");
		crearExpo.setBackground(Color.CYAN);
		crearExpo.setPreferredSize(new Dimension(d.width -20, 100));
		this.scrollExpoAux = new JPanel(new GridLayout(0, 1));
		this.scrollExpo = new JScrollPane(scrollExpoAux);
		
		
		scrollExpo.setPreferredSize(d2);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, scrollExpo, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollExpo, -70, SpringLayout.HORIZONTAL_CENTER, this);
		
		scrollExpo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollExpo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar verticalScrollExpoBar = scrollExpo.getVerticalScrollBar();
        verticalScrollExpoBar.setUnitIncrement(40);
        this.add(scrollExpo);
        scrollExpo.setVisible(false);
        
      //GESTIONAR INVENTARIO
  		this.crearObra = new JButton("Nueva Obra");
  		crearObra.setBackground(Color.CYAN);
  		crearObra.setPreferredSize(new Dimension(200, 100));
  		this.scrollInvAux = new JPanel(new GridLayout(0, 1));
  		this.scrollInv = new JScrollPane(scrollInvAux);
  		scrollInv.setPreferredSize(new Dimension(1200, 700));
  	
  		layout.putConstraint(SpringLayout.NORTH, scrollInv, 150, SpringLayout.SOUTH, buscar);
  		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollInv, 950, SpringLayout.WEST, this);
  		scrollInv.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    scrollInv.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    JScrollBar verticalScrollInvBar = scrollInv.getVerticalScrollBar();
	    verticalScrollInvBar.setUnitIncrement(40);
	    this.add(scrollInv);
	    scrollInv.setVisible(false);
	
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	
	public void setControlador(ActionListener c) {
		sorteos.addActionListener(c);
		notificaciones.addActionListener(c);
		buscar.addActionListener(c);
		principal.addActionListener(c);
		datos.addActionListener(c);
		cerrar.addActionListener(c);
		salas.addActionListener(c);
		expos.addActionListener(c);
		blockedUsers.addActionListener(c);
		users.addActionListener(c);
		crearExpo.addActionListener(c);
		crearObra.addActionListener(c);
		inv.addActionListener(c);
		confirmarCambios.addActionListener(c);
		crearSala.addActionListener(c);
		
	}
	
	public void updateDatos(Staff cl) {
		if(cl == null)
			return;
		
		nombreCliente.setText("Nombre: " + cl.getName());
		apellidoCliente.setText("Apellido: " + cl.getSurname());
		nifCliente.setText("NIF: " + cl.getNif());
		generoCliente.setText("Genero: " + cl.getGender());
		fechaCliente.setText("Fecha de Nacimiento: " + cl.getBirthDate());
		if (cl.getBankAccount() == null || cl.getBankAccount().equals("")) {
			cuentaBancaria.setText("INTRODUZCA_CUENTA_BANCARIA");
		}else {
			cuentaBancaria.setText(cl.getBankAccount());
		}
		personales.setVisible(true);
		gestionUsuarios.setVisible(false);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(false);
		scrollSala.setVisible(false);
	}
	
	public void updateCambioContraseña() {
		personales.setVisible(false);
		gestionUsuarios.setVisible(false);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(false);
		scrollSala.setVisible(false);
	}
	

	public void updateExpos(Set<Exhibition> expos) {
		VistaExposicionEditPanel aux;
		
		scrollExpoAux.removeAll();
		
		
		if (expos.isEmpty() || expos == null) {
			System.out.println("esta vacio");
			scrollExpoAux.add(crearExpo);
		}else {
			for (Exhibition e : expos) {
				aux = new VistaExposicionEditPanel(parent, e, false); 
				this.scrollExpoAux.add(aux);
				new ControladorExposicionEditPanel(parent, null, aux);
			}
			scrollExpoAux.add(crearExpo);
			this.revalidate();
			this.repaint();
			
		}
		
		
		personales.setVisible(false);
		gestionUsuarios.setVisible(false);
		scrollInv.setVisible(false);
		scrollExpo.setVisible(true);
		scrollSala.setVisible(false);
		
	}
	
	
	public void updateInv(Inventory inv) {
		VistaWorkEditPanel aux;
		
		scrollInvAux.removeAll();
		
		
		if (inv.isEmpty() || inv == null) {
			System.out.println("esta vacio");
			scrollExpoAux.add(crearExpo);
		}else {
			for (Work e : inv.getWorks()) {
				aux = new VistaWorkEditPanel(parent, e, false); 
				this.scrollInvAux.add(aux);
				new ControladorWorkEditPanel(parent, null, aux);
			}
			scrollInvAux.add(crearExpo);
			this.revalidate();
			this.repaint();
			
		}
		
		
		personales.setVisible(false);
		gestionUsuarios.setVisible(false);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(true);
		scrollSala.setVisible(false);
		
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
		gestionUsuarios.setVisible(true);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(false);
		scrollSala.setVisible(false);
	}
	
	public void updateSalas(Set<SubRoom> salas) {
		VistaSalaPanel aux;
		
		scrollSalaAux.removeAll();
		
		System.out.println(salas);
		
		
		if (salas.isEmpty() || salas == null) {
			System.out.println("No ha salas disponibles");
			scrollSalaAux.add(crearSala);
		}else {
			for (SubRoom r : salas) {
				aux = new VistaSalaPanel(parent, r, false); 
				this.scrollSalaAux.add(aux);
				new ControladorSalaPanel(parent, null, aux);
			}
			scrollSalaAux.add(crearSala);
			this.revalidate();
			this.repaint();
			
		}
		
		
		personales.setVisible(false);
		gestionUsuarios.setVisible(false);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(false);
		scrollSala.setVisible(true);
	}
	
	
	public void updateEntradas(Admin cl) {
		personales.setVisible(false);
		gestionUsuarios.setVisible(false);
		scrollExpo.setVisible(false);
		scrollInv.setVisible(false);
		scrollSala.setVisible(false);
	}

	public JToggleButton getBlockedUsers() {
		return blockedUsers;
	}

	public JTextField getCuentaBancaria() {
		return cuentaBancaria;
	}

	
	
	
	
	
}
