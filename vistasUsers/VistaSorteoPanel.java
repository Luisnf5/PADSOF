package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import users.Raffle;
import vistasSystem.VistaSystem;
import works.Exhibition;

public class VistaSorteoPanel extends JPanel{
	private Raffle sorteo;
	
	private VistaSystem parent;
	private JButton participar;
	private JLabel titulo;
	private JLabel descripcion;
	private JLabel fechaInicio;
	private JLabel fechaFinal;
	private JLabel participando;
	private JTextField selectedHora;
	
	
	public VistaSorteoPanel(VistaSystem parent, Raffle sorteo) {
		super();
		this.sorteo = sorteo;
		this.parent = parent;
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.setPreferredSize(new Dimension(700, 40));
		
		
		SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY/HH");
		
		this.titulo = new JLabel(sorteo.getTitle());
		this.descripcion = new JLabel(sorteo.getDescription());
		this.fechaInicio = new JLabel(sorteo.getExhibition().getStartDate().toString());
		this.fechaFinal = new JLabel(sorteo.getExhibition().getEndDate().toString());
		this.selectedHora = new JTextField("DD/MM/YYYY/HH");
		this.selectedHora.setPreferredSize(new Dimension(100, 25));
		this.participar = new JButton("Participar");
		this.participando = new JLabel("Ya estas participando en este sorteo");
		
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
		this.participar.setVisible(false);
		this.add(participar);
		
		
		layout.putConstraint(SpringLayout.NORTH, participando, (int) ((altoPanel - participar.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, participando, 20, SpringLayout.EAST, selectedHora);
		this.participando.setVisible(false);
		this.add(participando);
		
		updatePart();
	}
	
	public void setControlador(ActionListener c) {
		participar.addActionListener(c);
	}
	
	public Raffle getSorteo() {
		return sorteo;
	}
	
	public void updatePart() {
		if (this.sorteo.isParticipating(this.parent.getControladorVistaPrincipal().getLoggedClient())) {
			this.participar.setVisible(false);
			this.participando.setVisible(true);
		}else {
			this.participar.setVisible(true);
			this.participando.setVisible(false);
		}
	}
	
	public JTextField getSelectedHora() {
		return selectedHora;
	}


}
