package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
import works.Exhibition;
import works.ExhibitionStatus;

public class VistaExposicionEditPanel extends JPanel{
	private Exhibition exhibition;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton editar;
	
	private JTextField nombre;
	private JTextField autor;
	private JTextField fechaInicio;
	private JTextField fechaFinal;
	
	private JLabel nombreLabel;
	private JLabel autorLabel;
	private JLabel fechaInicioLabel;
	private JLabel fechaFinalLabel;
	
	
	public VistaExposicionEditPanel(VistaSystem parent, Exhibition ex, boolean newExhibition) {
		this.parent = parent;
		this.exhibition = ex;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(1100, 100));
		
		this.nombre = new JTextField(exhibition.getTitle());
		this.autor = new JTextField(exhibition.getAuthor());
		String fechaInicioString = String.format("%02d/%02d/%04d", exhibition.getStartDate().getDayOfMonth(), exhibition.getStartDate().getMonthValue(), exhibition.getStartDate().getYear());
		this.fechaInicio = new JTextField(fechaInicioString);
		String fechaFinalString = String.format("%02d/%02d/%04d", exhibition.getEndDate().getDayOfMonth(), exhibition.getEndDate().getMonthValue(), exhibition.getEndDate().getYear());
		this.fechaFinal = new JTextField(fechaFinalString);
		
		this.nombreLabel = new JLabel("Título");
		this.autorLabel = new JLabel("Autor");
		this.fechaInicioLabel = new JLabel("Inicio");
		this.fechaFinalLabel = new JLabel("Final");
		
		if (newExhibition) {
			this.confirmar = new JButton("Crear Exposición");
			confirmar.setBackground(Color.CYAN);
		}else if (exhibition.getStatus() == ExhibitionStatus.DRAFT) {
			this.confirmar = new JButton("Publicar Exposición");
			confirmar.setBackground(Color.GREEN);
		}else {
			this.confirmar = new JButton("Cancelar Exposición");
			confirmar.setBackground(Color.RED);
			confirmar.setForeground(Color.white);
		}
		
		this.editar = new JButton("Editar Exposición");
		
		
		
		layout.putConstraint(SpringLayout.NORTH, nombreLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombreLabel, 20, SpringLayout.WEST, this);
		nombreLabel.setPreferredSize(new Dimension(60, 20));
		this.add(nombreLabel);
		
		layout.putConstraint(SpringLayout.NORTH, autorLabel, 5, SpringLayout.SOUTH, nombreLabel);
		layout.putConstraint(SpringLayout.WEST, autorLabel, 20, SpringLayout.WEST, this);
		autorLabel.setPreferredSize(new Dimension(60, 20));
		this.add(autorLabel);

		layout.putConstraint(SpringLayout.NORTH, nombre, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombre, 5, SpringLayout.EAST, nombreLabel);
		nombre.setPreferredSize(new Dimension(80, 20));
		this.add(nombre);
		
		layout.putConstraint(SpringLayout.NORTH, autor, 5, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.WEST, autor, 5, SpringLayout.EAST, autorLabel);
		autor.setPreferredSize(new Dimension(80, 20));
		this.add(autor);
		
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicioLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicioLabel, 10, SpringLayout.EAST, nombre);
		fechaInicioLabel.setPreferredSize(new Dimension(40, 20));
		this.add(fechaInicioLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinalLabel, 25, SpringLayout.NORTH, fechaInicioLabel);
		layout.putConstraint(SpringLayout.WEST, fechaFinalLabel, 10, SpringLayout.EAST, nombre);
		fechaFinalLabel.setPreferredSize(new Dimension(40, 20));
		this.add(fechaFinalLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicio, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicio, 5, SpringLayout.EAST, fechaInicioLabel);
		fechaInicio.setPreferredSize(new Dimension(130, 20));
		this.add(fechaInicio);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinal, 5, SpringLayout.SOUTH, fechaInicio);
		layout.putConstraint(SpringLayout.WEST, fechaFinal, 5, SpringLayout.EAST, fechaFinalLabel);
		fechaFinal.setPreferredSize(new Dimension(130, 20));
		this.add(fechaFinal);
	
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, fechaFinal);
		this.add(confirmar);
		
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
	}

	public Exhibition getExposicion() {
		return exhibition;
	}
	
	public Exhibition getExhibition() {
		return exhibition;
	}

	public JTextField getAutor() {
		return autor;
	}

	public JTextField getFechaInicio() {
		return fechaInicio;
	}

	public JTextField getFechaFinal() {
		return fechaFinal;
	}

	public JTextField getNombre() {
		return nombre;
	}


	public static void main(String[] args) {
        // Crear una instancia de Notification para usar en VistaStaffPanel
        Exhibition client = new Exhibition("EX1", "Picasso", LocalDateTime.of(2024, 11, 29, 10, 0), LocalDateTime.of(2024, 11, 30, 20, 0));

        // Crear una instancia de VistaSystem (suponiendo que existe un constructor adecuado)
        VistaSystem parent = new VistaSystem();

        // Crear el panel VistaStaffPanel con la staffficación y el parent
        VistaExposicionEditPanel panel = new VistaExposicionEditPanel(parent, client, false);

        // Crear el JFrame y configurarlo
        JFrame frame = new JFrame("VistaExposicionEditPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
    }


	
}
