package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;
import works.SubRoom;

public class VistaSalaPanel extends JPanel{
	private SubRoom room;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton dividir;
	private JButton colapsar;
	

	private JTextField alto;
	private JTextField ancho;
	private JTextField largo;
	private JTextField temperatura;
	private JTextField capacidad;
	
	private JLabel nombre;
	
	private JLabel altoLabel;
	private JLabel anchoLabel;
	private JLabel largoLabel;
	private JLabel temperaturaLabel;
	private JLabel electricidadLabel;
	private JLabel capacidadLabel;
	
	private JCheckBox electricidad;
	
	
	public VistaSalaPanel(VistaSystem parent, SubRoom room, boolean newRoom) {
		this.parent = parent;
		this.room = room;
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(900, 120));
		
		this.nombre = new JLabel(room.getName());
		this.alto = new JTextField(String.valueOf(room.getHeight()));
		this.ancho = new JTextField(String.valueOf(room.getWidth()));
		this.largo = new JTextField(String.valueOf(room.getLength()));
		this.temperatura = new JTextField(String.valueOf(room.getTemperature()));
		this.capacidad = new JTextField(String.valueOf(room.getCapacity()));
		this.electricidad = new JCheckBox();
		
		
		electricidad.setSelected(room.isElectricity());
		
		
		
		this.altoLabel = new JLabel("Altura");
		this.anchoLabel = new JLabel("Ancho");
		this.largoLabel = new JLabel("Largo");
		this.temperaturaLabel = new JLabel("Temperatura");
		this.electricidadLabel = new JLabel("Electricidad");
		this.capacidadLabel = new JLabel("Capacidad");
		
		if(newRoom) {
			this.confirmar = new JButton("Crear Sala");
			confirmar.setBackground(Color.green);
		}
		else {
			this.confirmar = new JButton("Confirmar Cambios");
			confirmar.setBackground(Color.green);
		}
		
		
		this.dividir = new JButton("Dividir Sala");
		dividir.setBackground(Color.RED);
		dividir.setForeground(Color.WHITE);
		
		this.colapsar = new JButton("Colapsar Sala");
		colapsar.setBackground(Color.RED);
		colapsar.setForeground(Color.WHITE);
		

		layout.putConstraint(SpringLayout.NORTH, nombre, 15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombre, 20, SpringLayout.WEST, this);
		nombre.setPreferredSize(new Dimension(80, 20));
		this.add(nombre);
		
		layout.putConstraint(SpringLayout.NORTH, anchoLabel , 0 , SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.WEST, anchoLabel, 10, SpringLayout.EAST, nombre);
		anchoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(anchoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, largoLabel, 0, SpringLayout.SOUTH, anchoLabel);
		layout.putConstraint(SpringLayout.WEST, largoLabel, 10, SpringLayout.EAST, nombre);
		largoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(largoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, altoLabel, 0, SpringLayout.SOUTH, largoLabel);
		layout.putConstraint(SpringLayout.WEST, altoLabel, 10, SpringLayout.EAST, nombre);
		altoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(altoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, ancho, 0, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.WEST, ancho, 0, SpringLayout.EAST, anchoLabel);
		ancho.setPreferredSize(new Dimension(60, 20));
		this.add(ancho);
		
		layout.putConstraint(SpringLayout.NORTH, largo, 0, SpringLayout.SOUTH, ancho);
		layout.putConstraint(SpringLayout.WEST, largo, 0, SpringLayout.EAST, largoLabel);
		largo.setPreferredSize(new Dimension(60, 20));
		this.add(largo);
		
		layout.putConstraint(SpringLayout.NORTH, alto, 0, SpringLayout.SOUTH, largo);
		layout.putConstraint(SpringLayout.WEST, alto, 0, SpringLayout.EAST, altoLabel);
		alto.setPreferredSize(new Dimension(60, 20));
		this.add(alto);
		
		layout.putConstraint(SpringLayout.NORTH, temperaturaLabel, 0, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.WEST, temperaturaLabel, 20, SpringLayout.EAST, alto);
		this.add(temperaturaLabel);
		
		layout.putConstraint(SpringLayout.NORTH, temperatura, 20, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, temperatura, 0, SpringLayout.HORIZONTAL_CENTER, temperaturaLabel);
		temperatura.setPreferredSize(new Dimension(50, 20));
		this.add(temperatura);
		
		layout.putConstraint(SpringLayout.NORTH, electricidadLabel, 0, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.WEST, electricidadLabel, 20, SpringLayout.EAST, temperaturaLabel);
		this.add(electricidadLabel);
		
		layout.putConstraint(SpringLayout.NORTH, electricidad, 20, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, electricidad, 0, SpringLayout.HORIZONTAL_CENTER, electricidadLabel);
		this.add(electricidad);
		
		layout.putConstraint(SpringLayout.NORTH, capacidadLabel, 0, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.WEST, capacidadLabel, 20, SpringLayout.EAST, electricidadLabel);
		this.add(capacidadLabel);
		
		layout.putConstraint(SpringLayout.NORTH, capacidad, 20, SpringLayout.NORTH, nombre);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, capacidad, 0, SpringLayout.HORIZONTAL_CENTER, capacidadLabel);
		capacidad.setPreferredSize(new Dimension(50, 20));
		this.add(capacidad);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmar, 20, SpringLayout.VERTICAL_CENTER, nombre);
		layout.putConstraint(SpringLayout.WEST, confirmar, 40, SpringLayout.EAST, dividir);
		confirmar.setPreferredSize(new Dimension(150, 30));
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, dividir, 0, SpringLayout.VERTICAL_CENTER, nombre);
		layout.putConstraint(SpringLayout.WEST, dividir, 40, SpringLayout.EAST, capacidadLabel);
		dividir.setPreferredSize(new Dimension(130, 30));
		this.add(dividir);
		
		layout.putConstraint(SpringLayout.NORTH, colapsar, 10, SpringLayout.SOUTH, dividir);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, colapsar, 0, SpringLayout.HORIZONTAL_CENTER, dividir);
		colapsar.setPreferredSize(new Dimension(130, 30));
		this.add(colapsar);
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		dividir.addActionListener(c);
		colapsar.addActionListener(c);
	}
	
	public SubRoom getRoom() {
		return room;
	}
	
	public JTextField getTemperature() {
		return temperatura;
	}
	
	public JTextField getAlto() {
		return alto;
	}

	public JTextField getAncho() {
		return ancho;
	}

	public JTextField getLargo() {
		return largo;
	}
	
	public JTextField getCapacidad() {
		return capacidad;
	}
	
	public JCheckBox getElecticidad() {
		return electricidad;
	}
	

	public static void main(String[] args) {
        // Crear el objeto SubRoom de ejemplo
        SubRoom exampleRoom = new SubRoom(false, 23.00, 20.00, 20 , 5, 0, 100);

        // Crear la instancia de VistaSystem de ejemplo
        VistaSystem parent = new VistaSystem();

        // Configurar y mostrar la ventana en el hilo de despacho de eventos
        VistaSalaPanel panel = new VistaSalaPanel(parent, exampleRoom, false);

        // Crear el JFrame y configurarlo
        JFrame frame = new JFrame("VistaExposicionEditPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
    }


}
