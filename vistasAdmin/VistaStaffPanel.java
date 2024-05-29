package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel dniLabel;
	
	private JLabel privilegios;
	
	
	private JCheckBox temp;
	
	
	public VistaStaffPanel(VistaSystem parent, Staff staff) {
		this.parent = parent;
		this.staff = staff;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(1100, 100));
		
		this.nombre = new JTextField(staff.getName());
		this.apellido = new JTextField(staff.getSurname());
		this.dni = new JTextField(staff.getNif());
		this.nombreLabel = new JLabel("Nombre");
		this.apellidoLabel = new JLabel("Apellido");
		this.dniLabel = new JLabel("NIF");
		this.privilegios = new JLabel("Privilegios");
		temp = new JCheckBox("Temperatura");
		temp.setSelected(staff.hasPrivilege(Privileges.TEMPERATURA));
		
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
		
		layout.putConstraint(SpringLayout.NORTH, privilegios, (int) ((altoPanel - privilegios.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, privilegios, 70, SpringLayout.EAST, dni);
		privilegios.setPreferredSize(new Dimension(100, 20));
		this.add(privilegios);
		
		

		layout.putConstraint(SpringLayout.NORTH, temp, 10, SpringLayout.SOUTH, privilegios);
		layout.putConstraint(SpringLayout.WEST, temp, 50, SpringLayout.EAST, dni);
		this.add(temp);
		
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

	public JCheckBox getTemp() {
		return temp;
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
