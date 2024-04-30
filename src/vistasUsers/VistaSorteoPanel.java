package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import users.Raffle;
import works.Exhibition;

public class VistaSorteoPanel extends JPanel{
	private Raffle sorteo;
	
	private JButton participar;
	private JLabel titulo;
	private JLabel descripcion;
	private JLabel fechaInicio;
	private JLabel fechaFinal;
	private JFormattedTextField selectedHora;
	
	
	public VistaSorteoPanel(Raffle sorteo) {
		super();
		this.sorteo = sorteo;
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.setPreferredSize(new Dimension(700, 40));
		
		
		SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY/HH");
		
		this.titulo = new JLabel(sorteo.getTitle());
		this.descripcion = new JLabel(sorteo.getDescription());
		this.fechaInicio = new JLabel(sorteo.getStartDate().toString());
		this.fechaFinal = new JLabel(sorteo.getEndDate().toString());
		this.selectedHora = new JFormattedTextField(format);
		this.selectedHora.setPreferredSize(new Dimension(100, 25));
		this.participar = new JButton("Participar");
		
		layout.putConstraint(SpringLayout.NORTH, titulo, (int) ((altoPanel - titulo.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		this.add(titulo);
		
		layout.putConstraint(SpringLayout.NORTH, descripcion, (int) ((altoPanel - descripcion.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, descripcion, 20, SpringLayout.EAST, titulo);
		this.add(descripcion);
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicio, (int) ((altoPanel - fechaInicio.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicio, 20, SpringLayout.EAST, descripcion);
		this.add(fechaInicio);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinal, (int) ((altoPanel - fechaFinal.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaFinal, 20, SpringLayout.EAST, fechaInicio);
		this.add(fechaFinal);
		
		layout.putConstraint(SpringLayout.NORTH, selectedHora, (int) ((altoPanel - selectedHora.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, selectedHora, 20, SpringLayout.EAST, fechaFinal);
		this.add(selectedHora);
		
		layout.putConstraint(SpringLayout.NORTH, participar, (int) ((altoPanel - participar.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, participar, 20, SpringLayout.EAST, selectedHora);
		this.add(participar);
	}
	
	public static void main(String[] args) {
        // Crear una instancia del sorteo (supongamos que ya está creado)
		Exhibition expoPrueba = new Exhibition("expPrueba", "autorPrueba", LocalDateTime.of(2024, 01, 30, 19, 00), LocalDateTime.of(2024, 05, 30, 19, 00));
		expoPrueba.createRaffle("prueba", "descripcion prueba", 1, LocalDateTime.of(2024, 03, 30, 19, 00), LocalDateTime.of(2024, 04, 30, 19, 00));
		Raffle sorteo = expoPrueba.getRaffle();
		if (sorteo == null) {
			System.out.println("tonto qui no hay na");
		}

        // Crear una instancia del JPanel
        VistaSorteoPanel panel = new VistaSorteoPanel(sorteo);

        // Crear un JFrame
        JFrame frame = new JFrame("Ejemplo de Vista de Sorteo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el JPanel al JFrame
        frame.getContentPane().add(panel);

        // Empaquetar el JFrame y hacerlo visible
        frame.pack();
        frame.setVisible(true);
    }
}
