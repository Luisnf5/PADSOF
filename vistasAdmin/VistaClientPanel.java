package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import users.Client;
import users.Gender;
import users.Staff;
import vistasSystem.VistaSystem;

public class VistaClientPanel extends JPanel{
	private Client client;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton eliminar;
	private JButton block;
	
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField fecha;
	
	private ButtonGroup genderGroup;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton other;
	
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	private JLabel fechaLabel;
	private JLabel genderLabel;
	
	
	public VistaClientPanel(VistaSystem parent, Client client) {
		this.parent = parent;
		this.client = client;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(1100, 100));
		
		this.nombre = new JTextField(client.getName());
		this.apellido = new JTextField(client.getSurname());
		this.dni = new JTextField(client.getNif());
		String fechaString = String.format("%02d/%02d/%04d", client.getBirthDate().getDayOfMonth(), client.getBirthDate().getMonthValue(), client.getBirthDate().getYear());
		this.fecha = new JTextField(fechaString);
		this.male = new JRadioButton("Masculino");
		this.female = new JRadioButton("Femenino");
		this.other = new JRadioButton("Otro");
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);
		
		if (client.getGender() == Gender.MALE) {
			male.setSelected(true);
		}else if (client.getGender() == Gender.FEMALE) {
			female.setSelected(true);
		}else if (client.getGender() == Gender.OTHER) {
			other.setSelected(true);
		}
		
		this.nombreLabel = new JLabel("Nombre");
		this.apellidoLabel = new JLabel("Apellido");
		this.dniLabel = new JLabel("NIF");
		this.fechaLabel = new JLabel("Fecha de Nacimiento");
		this.genderLabel = new JLabel("Género");
		
		this.confirmar = new JButton("Confirmar Cambios");
		confirmar.setBackground(Color.green);
		
		this.eliminar = new JButton("Eliminar Usuario");
		eliminar.setBackground(Color.RED);
		eliminar.setForeground(Color.WHITE);
		
		if (!client.isBlocked()) {
			this.block = new JButton("Bloquear Cuenta");
			block.setBackground(Color.CYAN);
		}else {
			this.block = new JButton("Desbloquear Cuenta");
			block.setBackground(Color.BLUE);
			block.setForeground(Color.white);
		}
		
		
		
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
		
	
		
		
		
		
		
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, other);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, eliminar, (int) ((altoPanel - eliminar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, eliminar, 20, SpringLayout.EAST, confirmar);
		this.add(eliminar);
		
		layout.putConstraint(SpringLayout.NORTH, block, (int) ((altoPanel - block.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, block, 20, SpringLayout.EAST, eliminar);
		this.add(block);
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		eliminar.addActionListener(c);
		block.addActionListener(c);
	}

	public Client getClient() {
		return client;
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


	public JTextField getFecha() {
		return fecha;
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

	public ButtonGroup getGenderGroup() {
		return genderGroup;
	}

	public static void main(String[] args) {
        // Crear una instancia de Notification para usar en VistaStaffPanel
        Client client = new Client("Luis", "Nuñez", "12345678A", Gender.FEMALE, LocalDate.of(2000, 1, 1), "Hola123");

        // Crear una instancia de VistaSystem (suponiendo que existe un constructor adecuado)
        VistaSystem parent = new VistaSystem();

        // Crear el panel VistaStaffPanel con la staffficación y el parent
        VistaClientPanel panel = new VistaClientPanel(parent, client);

        // Crear el JFrame y configurarlo
        JFrame frame = new JFrame("VistaStaffPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
    }


	
}
