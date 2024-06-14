package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import works.Exhibition;
import works.Painting;
import works.Work;

public class VistaWorkEditPanel extends JPanel{
	private Work work;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton editar;
	
	private JTextField title;
	private JTextField autor;
	private JTextField temp;
	private JTextField ancho;
	private JTextField alto;
	private JTextField largo;
	private JCheckBox elec;
	private JComboBox<String> expo;
	private JComboBox<String> sala;
	
	private JLabel titleLabel;
	private JLabel autorLabel;
	private JLabel tempLabel;
	private JLabel elecLabel;
	private JLabel anchoLabel;
	private JLabel altoLabel;
	private JLabel largoLabel;
	private JLabel expoLabel;
	private JLabel salaLabel;
	
	
	public VistaWorkEditPanel(VistaSystem parent, Work work, boolean newExhibition) {
		this.parent = parent;
		this.work = work;
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.setPreferredSize(new Dimension(1100, 150));
		
		this.title = new JTextField(work.getTitle());
		this.autor = new JTextField(work.getAuthor());
		this.temp = new JTextField(String.valueOf(work.getTemperature()));
		this.ancho = new JTextField(String.valueOf(work.getWidth()));
		this.alto = new JTextField(String.valueOf(work.getHeight()));
		this.largo = new JTextField(String.valueOf(work.getLenght()));
		this.elec = new JCheckBox();
		this.elec.setSelected(work.getElctricity());
		Set<String> expStrings = new LinkedHashSet<>();
		ArtGallery.getSystem().getExhibitions().forEach(e -> expStrings.add(e.getTitle()));
		
		this.expo = new JComboBox<String>(expStrings.toArray(new String[expStrings.size()]));
		this.sala = new JComboBox<String>();
		
		

		this.titleLabel = new JLabel("Título");
		this.autorLabel = new JLabel("Autor");
		this.tempLabel = new JLabel("Temperatura");
		this.anchoLabel = new JLabel("Ancho");
		this.altoLabel = new JLabel("Alto");
		this.largoLabel = new JLabel("Largo");
		this.elecLabel = new JLabel("Electricidad");
		
		
		this.editar = new JButton("Editar Obra");
		this.editar.setBackground(Color.BLUE);
		this.editar.setForeground(Color.WHITE);
		
		this.confirmar = new JButton("Confirmar");
		
		layout.putConstraint(SpringLayout.NORTH, titleLabel, (int) ((altoPanel - titleLabel.getHeight())/2+40)-15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
		titleLabel.setPreferredSize(new Dimension(40, 20));
		this.add(titleLabel);
		
		layout.putConstraint(SpringLayout.NORTH, autorLabel, 5, SpringLayout.SOUTH, titleLabel);
		layout.putConstraint(SpringLayout.WEST, autorLabel, 20, SpringLayout.WEST, this);
		autorLabel.setPreferredSize(new Dimension(40, 20));
		this.add(autorLabel);

		layout.putConstraint(SpringLayout.NORTH, title, (int) ((altoPanel - title.getHeight())/2+40)-15, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.EAST, titleLabel);
		title.setPreferredSize(new Dimension(80, 20));
		this.add(title);
		
		layout.putConstraint(SpringLayout.NORTH, autor, 5, SpringLayout.SOUTH, title);
		layout.putConstraint(SpringLayout.WEST, autor, 5, SpringLayout.EAST, autorLabel);
		autor.setPreferredSize(new Dimension(80, 20));
		this.add(autor);
		
		layout.putConstraint(SpringLayout.NORTH, tempLabel, (int) ((altoPanel - title.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, tempLabel, 15, SpringLayout.EAST, title);
		tempLabel.setPreferredSize(new Dimension(80, 20));
		this.add(tempLabel);
		
		layout.putConstraint(SpringLayout.NORTH, temp, 5, SpringLayout.SOUTH, tempLabel);
		layout.putConstraint(SpringLayout.WEST, temp, 30, SpringLayout.EAST, title);
		temp.setPreferredSize(new Dimension(40, 20));
		this.add(temp);
		
		layout.putConstraint(SpringLayout.NORTH, elecLabel, (int) ((altoPanel - title.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, elecLabel, 15, SpringLayout.EAST, tempLabel);
		elecLabel.setPreferredSize(new Dimension(70, 20));
		this.add(elecLabel);
		
		layout.putConstraint(SpringLayout.NORTH, elec, 5, SpringLayout.SOUTH, elecLabel);
		layout.putConstraint(SpringLayout.WEST, elec, 35, SpringLayout.EAST, tempLabel);
		this.add(elec);
		
		layout.putConstraint(SpringLayout.NORTH, anchoLabel, (int) ((altoPanel - titleLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, anchoLabel, 10, SpringLayout.EAST, elecLabel);
		anchoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(anchoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, largoLabel, 0, SpringLayout.SOUTH, anchoLabel);
		layout.putConstraint(SpringLayout.WEST, largoLabel, 10, SpringLayout.EAST, elecLabel);
		largoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(largoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, altoLabel, 0, SpringLayout.SOUTH, largoLabel);
		layout.putConstraint(SpringLayout.WEST, altoLabel, 10, SpringLayout.EAST, elecLabel);
		altoLabel.setPreferredSize(new Dimension(40, 20));
		this.add(altoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, ancho, (int) ((altoPanel - titleLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
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
		
		layout.putConstraint(SpringLayout.NORTH, alto, 0, SpringLayout.SOUTH, largo);
		layout.putConstraint(SpringLayout.WEST, alto, 0, SpringLayout.EAST, altoLabel);
		alto.setPreferredSize(new Dimension(60, 20));
		this.add(alto);
		
		
		
	
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, altoLabel);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, editar, (int) ((altoPanel - editar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, editar, 10, SpringLayout.EAST, confirmar);
		this.add(editar);
		
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		editar.addActionListener(c);
	}

	public Work getWork() {
		return work;
	}

	public JTextField getAutor() {
		return autor;
	}


	public JTextField getTitle() {
		return title;
	}

	public static void main(String[] args) {
        // Crear una instancia de Work (puede ser Painting u otra subclase)
        Work work = new Painting("Título de Ejemplo", "Autor Ejemplo", true, 20, 30, 40, 50, 10);

        // Crear una instancia de VistaSystem (suponiendo que tienes una implementación de VistaSystem)
        VistaSystem vistaSystem = new VistaSystem();

        // Crear el JFrame principal
        JFrame frame = new JFrame("VistaWorkEditPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 150);

        // Crear una instancia de VistaWorkEditPanel
        VistaWorkEditPanel vistaWorkEditPanel = new VistaWorkEditPanel(vistaSystem, work, false);
        
        // Añadir un ActionListener de prueba
        vistaWorkEditPanel.setControlador(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vistaWorkEditPanel.getAutor()) {
                    System.out.println("Autor: " + vistaWorkEditPanel.getAutor().getText());
                } else if (e.getSource() == vistaWorkEditPanel.getTitle()) {
                    System.out.println("Título: " + vistaWorkEditPanel.getTitle().getText());
                }
                // Aquí puedes manejar más acciones
            }
        });

        // Añadir el panel al frame
        frame.add(vistaWorkEditPanel);
        
        // Hacer el frame visible
        frame.setVisible(true);
    }


	
}
