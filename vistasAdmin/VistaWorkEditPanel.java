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
import works.Painting;
import works.Sculpture;
import works.Status;
import works.Video;
import works.Work;

public class VistaWorkEditPanel extends JPanel{
	private Work work;
	private String type = null;
	
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
	private JComboBox<String> tipo;
	
	private JLabel titleLabel;
	private JLabel autorLabel;
	private JLabel tempLabel;
	private JLabel elecLabel;
	private JLabel anchoLabel;
	private JLabel altoLabel;
	private JLabel largoLabel;
	private JLabel expoLabel;
	private JLabel salaLabel;
	private JLabel tipoLabel;
	
	
	public VistaWorkEditPanel(VistaSystem parent, Work work, boolean newRoom) {
		this.parent = parent;
		this.work = work;
		
		if (!newRoom) {
			if (work instanceof Painting) {
				type = "PAINTING";
			}else if (work instanceof Sculpture) {
				type = "SCULPTURE";
			}else if (work instanceof Video) {
				type = "VIDEO";
			}else {
				type = "PHOTO";	
			}
		}
		
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
		this.tipo = new JComboBox<String>(new String[] {"PAINTING", "SCULPTURE", "VIDEO", "PHOTO"});
		if (newRoom || work.getSta() != Status.EXHIBITED) {
			this.expo.setSelectedItem(null);
		}else {
			String expoString = work.getSubRoomExhibition().getExpo().getTitle();
			for (int i = 0; i< expo.getItemCount(); i++) {
				if (expo.getItemAt(i).equals(expoString)) {
					expo.setSelectedIndex(i);
				}
			}
		}
		
		this.sala = new JComboBox<String>();
		updateSalas();
		if (newRoom || work.getSta() == Status.EXHIBITED) {
			String salaString = work.getSubRoomExhibition().getSalaHija().getName();
			for (int i = 0; i< sala.getItemCount(); i++) {
				if (sala.getItemAt(i).equals(salaString)) {
					sala.setSelectedIndex(i);
				}
			}
		} 
		
		this.expo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSalas();
			}
		});

		
		this.titleLabel = new JLabel("Título");
		this.autorLabel = new JLabel("Autor");
		this.tempLabel = new JLabel("Temperatura");
		this.anchoLabel = new JLabel("Ancho");
		this.altoLabel = new JLabel("Alto");
		this.largoLabel = new JLabel("Largo");
		this.elecLabel = new JLabel("Electricidad");
		this.expoLabel = new JLabel("Exposición");
		this.salaLabel = new JLabel("Sala");
		this.tipoLabel = new JLabel("Tipo");
		
		
		this.editar = new JButton("Editar Obra");
		this.editar.setBackground(Color.BLUE);
		this.editar.setForeground(Color.WHITE);
		
		if (this.work.getSta() == Status.INVENTORY) {
			this.confirmar = new JButton("Exponer Obra");
			this.confirmar.setBackground(Color.GREEN);
		}else if (this.work.getSta() == Status.RESTORATION || this.work.getSta() == Status.EXHIBITED) {
			this.confirmar = new JButton("Devolver a Inventario");
			this.confirmar.setBackground(Color.CYAN);
		}
		
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
		
		layout.putConstraint(SpringLayout.NORTH, expoLabel, (int) ((altoPanel - titleLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, expoLabel, 20, SpringLayout.EAST, alto);
		expoLabel.setPreferredSize(new Dimension(80, 20));
		this.add(expoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, salaLabel, (int) ((altoPanel - titleLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, salaLabel, 20, SpringLayout.EAST, expoLabel);
		salaLabel.setPreferredSize(new Dimension(60, 20));
		this.add(salaLabel);
		
		layout.putConstraint(SpringLayout.NORTH, expo, 10, SpringLayout.SOUTH, expoLabel);
		layout.putConstraint(SpringLayout.WEST, expo, 20, SpringLayout.EAST, alto);
		expo.setPreferredSize(new Dimension(80, 20));
		this.add(expo);
		
		layout.putConstraint(SpringLayout.NORTH, sala, 10, SpringLayout.SOUTH, salaLabel);
		layout.putConstraint(SpringLayout.WEST, sala, 20, SpringLayout.EAST, expo);
		sala.setPreferredSize(new Dimension(60, 20));
		this.add(sala);
		
		layout.putConstraint(SpringLayout.NORTH, tipoLabel, (int) ((altoPanel - titleLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, tipoLabel, 20, SpringLayout.EAST, salaLabel);
		tipoLabel.setPreferredSize(new Dimension(60, 20));
		this.add(tipoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, tipo, 10, SpringLayout.SOUTH, tipoLabel);
		layout.putConstraint(SpringLayout.WEST, tipo, 20, SpringLayout.EAST, sala);
		tipo.setPreferredSize(new Dimension(100, 20));
		this.add(tipo);
	
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 20, SpringLayout.EAST, tipo);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, editar, (int) ((altoPanel - editar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, editar, 10, SpringLayout.EAST, confirmar);
		this.add(editar);
		
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		editar.addActionListener(c);
	}
	
	private void updateSalas() {
		System.out.println("LLAMAO");
		String selectedItem = (String) expo.getSelectedItem();
		if (selectedItem == null) {
			sala.removeAllItems();
			return;
		}
		
		sala.removeAllItems();
		
		ArtGallery.getSystem().searchExhibition(selectedItem).getRoomexhibitions().forEach(r -> sala.addItem(r.getSubRoom().getName()));
		
		sala.setSelectedItem(null);

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

	public JTextField getTemp() {
		return temp;
	}

	public JTextField getAncho() {
		return ancho;
	}

	public JTextField getAlto() {
		return alto;
	}

	public JTextField getLargo() {
		return largo;
	}

	public JCheckBox getElec() {
		return elec;
	}

	public JComboBox<String> getExpo() {
		return expo;
	}

	public JComboBox<String> getSala() {
		return sala;
	}
	
	public String previousType() {
		return type;
	}

	public JComboBox<String> getTipo() {
		return tipo;
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
            }
        });

        // Añadir el panel al frame
        frame.add(vistaWorkEditPanel);
        
        // Hacer el frame visible
        frame.setVisible(true);
    }




	
}
