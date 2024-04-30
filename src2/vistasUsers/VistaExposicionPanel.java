package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;

public class VistaExposicionPanel extends JPanel {
	
	private JLabel nombreExp;
	private JLabel fecha;
	private VistaSystem parent;
	private JButton buton;
	
	public VistaExposicionPanel(VistaSystem parent) {
		JPanel prueba = new JPanel();
		
		this.parent = parent;
		
		
		this.setPreferredSize(new Dimension(parent.getWidth() - 200, 300));
		this.setBackground(Color.red);
		prueba.setBackground(Color.green);
		prueba.setPreferredSize(new Dimension(300, 300));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		add(prueba);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, prueba, 0, SpringLayout.VERTICAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, prueba, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		fecha = new JLabel("Fecha de la exposicion");
		add(fecha);
		springLayout.putConstraint(SpringLayout.NORTH, fecha, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, fecha, 900, SpringLayout.WEST, this);
		
		
		this.buton = new JButton("Volver");
		add(buton);
		springLayout.putConstraint(SpringLayout.NORTH, buton, 100, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buton, 1000, SpringLayout.WEST, this);
		
		
	}
	
	
	
	
	
}
