package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;

import users.Gender;
import users.Privileges;
import users.Staff;
import vistasSystem.VistaSystem;

public class VistaStaffPanel extends JPanel{
	private Staff staff;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton eliminar;
	
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField fecha;
	
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JLabel fechaLabel;
	private JLabel genderLabel;
	
	private JLabel privilegios;
	
	private ButtonGroup genderGroup;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton other;
	
	
	private JCheckBox salas;
	private JCheckBox entradas;
	private JCheckBox inv;
	private JCheckBox users;
	private JCheckBox expos;
	
	
	public VistaStaffPanel(VistaSystem parent, Staff staff) {
		this.parent = parent;
		this.staff = staff;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(1100, 150));
		
		this.nombre = new JTextField(staff.getName());
		this.apellido = new JTextField(staff.getSurname());
		this.dni = new JTextField(staff.getNif());
		this.nombreLabel = new JLabel("Nombre");
		this.apellidoLabel = new JLabel("Apellido");
		this.dniLabel = new JLabel("NIF");
		this.fechaLabel = new JLabel("Fecha de Nacimiento");
		this.genderLabel = new JLabel("Género");
		String fechaString = String.format("%02d/%02d/%04d", staff.getBirthDate().getDayOfMonth(), staff.getBirthDate().getMonthValue(), staff.getBirthDate().getYear());
		this.fecha = new JTextField(fechaString);
		this.male = new JRadioButton("Masculino");
		this.female = new JRadioButton("Femenino");
		this.other = new JRadioButton("Otro");
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);
		this.privilegios = new JLabel("Privilegios");
		salas = new JCheckBox("Gestion Salas");
		salas.setSelected(staff.hasPrivilege(Privileges.GESTION_SALAS));
		entradas = new JCheckBox("Compra Entradas");
		entradas.setSelected(staff.hasPrivilege(Privileges.COMPRA_ENTRADAS));
		inv = new JCheckBox("Gestion Inventario");
		inv.setSelected(staff.hasPrivilege(Privileges.GESTION_INVENTARIO));
		users = new JCheckBox("Gestion Usuarios");
		users.setSelected(staff.hasPrivilege(Privileges.GESTION_USUARIOS));
		expos = new JCheckBox("Gestion Exposiciones");
		expos.setSelected(staff.hasPrivilege(Privileges.GESTION_EXPOSICIONES));
		
		if (staff.getGender() == Gender.MALE) {
			male.setSelected(true);
		}else if (staff.getGender() == Gender.FEMALE) {
			female.setSelected(true);
		}else if (staff.getGender() == Gender.OTHER) {
			other.setSelected(true);
		}
		
		this.confirmar = new JButton("Confirmar Cambios");
		confirmar.setBackground(Color.green);
		
		this.eliminar = new JButton("Eliminar Empleado");
		eliminar.setBackground(Color.RED);
		eliminar.setForeground(Color.WHITE);
		
		layout.putConstraint(SpringLayout.NORTH, nombreLabel, (int) ((altoPanel - dni.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombreLabel, 20, SpringLayout.WEST, this);
		nombreLabel.setPreferredSize(new Dimension(60, 20));
		this.add(nombreLabel);
		
		layout.putConstraint(SpringLayout.NORTH, apellidoLabel, 5, SpringLayout.SOUTH, nombreLabel);
		layout.putConstraint(SpringLayout.WEST, apellidoLabel, 20, SpringLayout.WEST, this);
		apellidoLabel.setPreferredSize(new Dimension(60, 20));
		this.add(apellidoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, dniLabel, (int) ((altoPanel - dni.getHeight())/2)+30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dniLabel, 20, SpringLayout.EAST, nombre);
		dniLabel.setPreferredSize(new Dimension(20, 20));
		this.add(dniLabel);

		layout.putConstraint(SpringLayout.NORTH, nombre, (int) ((altoPanel - dni.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombre, 5, SpringLayout.EAST, nombreLabel);
		nombre.setPreferredSize(new Dimension(80, 20));
		this.add(nombre);
		
		layout.putConstraint(SpringLayout.NORTH, apellido, 5, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.WEST, apellido, 5, SpringLayout.EAST, apellidoLabel);
		apellido.setPreferredSize(new Dimension(80, 20));
		this.add(apellido);
		
		layout.putConstraint(SpringLayout.NORTH, dni, (int) ((altoPanel - dni.getHeight())/2)+30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dni, 5, SpringLayout.EAST, dniLabel);
		dni.setPreferredSize(new Dimension(100, 20));
		this.add(dni);
		
		layout.putConstraint(SpringLayout.NORTH, fechaLabel, (int) ((altoPanel - fechaLabel.getHeight())/2)+15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaLabel, 20, SpringLayout.EAST, dni);
		fechaLabel.setPreferredSize(new Dimension(130, 20));
		this.add(fechaLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fecha, 0, SpringLayout.SOUTH, fechaLabel);
		layout.putConstraint(SpringLayout.WEST, fecha, 20, SpringLayout.EAST, dni);
		fecha.setPreferredSize(new Dimension(130, 20));
		this.add(fecha);
		
		layout.putConstraint(SpringLayout.NORTH, genderLabel, (int) ((altoPanel - genderLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, genderLabel, 40, SpringLayout.EAST, fechaLabel);
		genderLabel.setPreferredSize(new Dimension(130, 20));
		this.add(genderLabel);
		
		layout.putConstraint(SpringLayout.NORTH, male, 20, SpringLayout.NORTH, genderLabel);
		layout.putConstraint(SpringLayout.WEST, male, 30, SpringLayout.EAST, fecha);
		male.setPreferredSize(new Dimension(90, 20));
		this.add(male);
		
		layout.putConstraint(SpringLayout.NORTH, female, 20, SpringLayout.NORTH, male);
		layout.putConstraint(SpringLayout.WEST, female, 30, SpringLayout.EAST, fecha);
		female.setPreferredSize(new Dimension(90, 20));
		this.add(female);
		
		layout.putConstraint(SpringLayout.NORTH, other, 20, SpringLayout.NORTH, female);
		layout.putConstraint(SpringLayout.WEST, other, 30, SpringLayout.EAST, fecha);
		other.setPreferredSize(new Dimension(90, 20));
		this.add(other);
		
		layout.putConstraint(SpringLayout.NORTH, privilegios, (int) ((altoPanel - privilegios.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, privilegios, 70, SpringLayout.EAST, other);
		privilegios.setPreferredSize(new Dimension(100, 20));
		this.add(privilegios);
		
		

		layout.putConstraint(SpringLayout.NORTH, salas, 0, SpringLayout.SOUTH, privilegios);
		layout.putConstraint(SpringLayout.WEST, salas, 50, SpringLayout.EAST, other);
		this.add(salas);
		
		layout.putConstraint(SpringLayout.NORTH, entradas, 0, SpringLayout.SOUTH, salas);
		layout.putConstraint(SpringLayout.WEST, entradas, 50, SpringLayout.EAST, other);
		this.add(entradas);
		
		layout.putConstraint(SpringLayout.NORTH, inv, 0, SpringLayout.SOUTH, entradas);
		layout.putConstraint(SpringLayout.WEST, inv, 50, SpringLayout.EAST, other);
		this.add(inv);
		
		layout.putConstraint(SpringLayout.NORTH, users, 0, SpringLayout.SOUTH, inv);
		layout.putConstraint(SpringLayout.WEST, users, 50, SpringLayout.EAST, other);
		this.add(users);
		
		layout.putConstraint(SpringLayout.NORTH, expos, 0, SpringLayout.SOUTH, users);
		layout.putConstraint(SpringLayout.WEST, expos, 50, SpringLayout.EAST, other);
		this.add(expos);
		
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, privilegios);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, eliminar, (int) ((altoPanel - eliminar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, eliminar, 20, SpringLayout.EAST, confirmar);
		this.add(eliminar);
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		eliminar.addActionListener(c);
	}

	public Staff getStaff() {
		return staff;
	}
	
	
	
	
	
	
	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getApellido() {
		return apellido;
	}

	public JTextField getDni() {
		return dni;
	}

	public JCheckBox getSalas() {
		return salas;
	}

	public JCheckBox getEntradas() {
		return entradas;
	}

	public JCheckBox getInv() {
		return inv;
	}

	public JCheckBox getUsers() {
		return users;
	}

	public JCheckBox getExpos() {
		return expos;
	}

	public JTextField getFecha() {
		return fecha;
	}

	public ButtonGroup getGenderGroup() {
		return genderGroup;
	}

	public JRadioButton getMale() {
		return male;
	}

	public JRadioButton getFemale() {
		return female;
	}

	public JRadioButton getOther() {
		return other;
	}

	public static void main(String[] args) {
        // Crear una instancia de Notification para usar en VistaStaffPanel
        Staff staff = new Staff("Luis", "Nuñez", "12345678A", Gender.MALE, LocalDate.of(2000, 1, 1));

        // Crear una instancia de VistaSystem (suponiendo que existe un constructor adecuado)
        VistaSystem parent = new VistaSystem();

        // Crear el panel VistaStaffPanel con la staffficación y el parent
        VistaStaffPanel panel = new VistaStaffPanel(parent, staff);

        // Crear el JFrame y configurarlo
        JFrame frame = new JFrame("VistaStaffPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
    }


}
