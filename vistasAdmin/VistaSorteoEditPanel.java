package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import system.ArtGallery;
import users.Raffle;
import vistasSystem.VistaSystem;
import works.Exhibition;

public class VistaSorteoEditPanel extends JPanel{
	private Raffle sorteo;
	private boolean newSorteo;
	
	private VistaSystem parent;
	private JButton confirmar;
	private JLabel tituloLabel;
	private JLabel descripcionLabel;
	private JLabel fechaInicioLabel;
	private JLabel fechaFinalLabel;
	private JLabel exposicionLabel;
	
	
	private JTextField descripcion;
	private JTextField titulo;
	private JTextField fechaInicio;
	private JTextField fechaFinal;
	private JComboBox<String> exposicion;
	
	
	public VistaSorteoEditPanel(VistaSystem parent, Raffle sorteo, boolean n) {
		super();
		this.sorteo = sorteo;
		this.parent = parent;
		this.newSorteo = n;
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.setPreferredSize(new Dimension(1100, 150));
		
		
		SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY/HH");
		
		this.tituloLabel = new JLabel("Título");
		this.descripcionLabel = new JLabel("Descripción");
		this.fechaInicioLabel = new JLabel("Fecha de inicio");
		this.fechaFinalLabel = new JLabel("Fecha de finalización");
		this.exposicionLabel = new JLabel("Exposición");
		
		if (newSorteo) {
			this.confirmar = new JButton("Crear Sorteo");
			confirmar.setBackground(Color.GREEN);
		}else {
			this.confirmar = new JButton("Editar Sorteo");
			confirmar.setBackground(Color.CYAN);
		}
		Set<String> expStrings = new LinkedHashSet<>();
		ArtGallery.getSystem().getExhibitions().forEach(e -> expStrings.add(e.getTitle()));
		this.exposicion = new JComboBox<String>(expStrings.toArray(new String[expStrings.size()]));
		
		this.titulo = new JTextField(sorteo.getTitle());
		this.descripcion = new JTextField(sorteo.getDescription());
		
		if (sorteo == null) {
			System.out.println("SORTEO NULLLLLLLLLLLLLLLLLLLLL");
		}
		this.fechaInicio = new JTextField(String.format("%02d/%02d/%04d", sorteo.getStartDate().toLocalDate().getDayOfMonth(), sorteo.getStartDate().toLocalDate().getMonthValue(), sorteo.getStartDate().toLocalDate().getYear()));
		this.fechaFinal = new JTextField(String.format("%02d/%02d/%04d", sorteo.getEndDate().toLocalDate().getDayOfMonth(), sorteo.getEndDate().toLocalDate().getMonthValue(), sorteo.getEndDate().toLocalDate().getYear()));
		
		layout.putConstraint(SpringLayout.NORTH, tituloLabel, (int) ((altoPanel - tituloLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, tituloLabel, 50, SpringLayout.WEST, this);
		this.add(tituloLabel);
		
		layout.putConstraint(SpringLayout.NORTH, descripcionLabel, (int) ((altoPanel - descripcionLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, descripcionLabel, 140, SpringLayout.EAST, tituloLabel);
		this.add(descripcionLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicioLabel, (int) ((altoPanel - fechaInicioLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicioLabel, 90, SpringLayout.EAST, descripcionLabel);
		this.add(fechaInicioLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinalLabel, (int) ((altoPanel - fechaFinalLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaFinalLabel, 45, SpringLayout.EAST, fechaInicioLabel);
		this.add(fechaFinalLabel);
		
		layout.putConstraint(SpringLayout.NORTH, exposicionLabel, (int) ((altoPanel - exposicionLabel.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, exposicionLabel, 30, SpringLayout.EAST, fechaFinalLabel);
		this.add(exposicionLabel);
		
		layout.putConstraint(SpringLayout.NORTH, titulo, 10, SpringLayout.SOUTH, tituloLabel);
		layout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		this.titulo.setPreferredSize(new Dimension(110, 20));
		this.add(titulo);
		
		layout.putConstraint(SpringLayout.NORTH, descripcion, 10, SpringLayout.SOUTH, descripcionLabel);
		layout.putConstraint(SpringLayout.WEST, descripcion, 20, SpringLayout.EAST, titulo);
		this.descripcion.setPreferredSize(new Dimension(200, 20));
		this.add(descripcion);
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicio, 10, SpringLayout.SOUTH, fechaInicioLabel);
		layout.putConstraint(SpringLayout.WEST, fechaInicio, 20, SpringLayout.EAST, descripcion);
		this.fechaInicio.setPreferredSize(new Dimension(120, 20));
		this.add(fechaInicio);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinal, 10, SpringLayout.SOUTH, fechaFinalLabel);
		layout.putConstraint(SpringLayout.WEST, fechaFinal, 20, SpringLayout.EAST, fechaInicio);
		this.fechaFinal.setPreferredSize(new Dimension(120, 20));
		this.add(fechaFinal);
		
		layout.putConstraint(SpringLayout.NORTH, exposicion, 10, SpringLayout.SOUTH, exposicionLabel);
		layout.putConstraint(SpringLayout.WEST, exposicion, 20, SpringLayout.EAST, fechaFinal);
		exposicion.setPreferredSize(new Dimension(80, 20));
		this.add(exposicion);
		
		layout.putConstraint(SpringLayout.NORTH, confirmar, 10, SpringLayout.SOUTH, exposicionLabel);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, exposicion);
		confirmar.setPreferredSize(new Dimension(120, 20));
		this.add(confirmar);
				
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
	}
	
	public Raffle getSorteo() {
		return sorteo;
	}
	
	
	
	
	
	
	 public JTextField getDescripcion() {
		return descripcion;
	}

	public JTextField getTitulo() {
		return titulo;
	}

	public JComboBox<String> getExposicion() {
		return exposicion;
	}

	public JTextField getFechaInicio() {
		return fechaInicio;
	}

	public JTextField getFechaFinal() {
		return fechaFinal;
	}

	public static void main(String[] args) {
	        // Crear la ventana principal
	        JFrame frame = new JFrame("Editar Sorteo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1100, 150);
	        
	        // Crear instancias ficticias de VistaSystem, Raffle y Exhibition para la demostración
	        Exhibition exhibition = new Exhibition("ejemplo", "ejemplo2", LocalDateTime.now(), LocalDateTime.now().plusDays(10));
	        Raffle raffle = new Raffle("Título del Sorteo", "Descripción del Sorteo", 3, LocalDateTime.now(), LocalDateTime.now().plusDays(5), exhibition);
	        VistaSystem vistaSystem = new VistaSystem();
	        
	        // Crear una instancia de VistaSorteoEditPanel con los objetos ficticios
	        VistaSorteoEditPanel panel = new VistaSorteoEditPanel(vistaSystem, raffle, false);
	        
	        // Agregar el panel a la ventana
	        frame.add(panel);
	        
	        // Mostrar la ventana
	        frame.setVisible(true);
	    }


}
