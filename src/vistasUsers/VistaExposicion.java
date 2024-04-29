package vistasUsers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vistasSystem.VistaSystem;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaExposicion extends JPanel {
	
	private JLabel nombreExp;
	private JLabel fecha;
	private VistaSystem parent;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public VistaExposicion(VistaSystem parent) {
		
this.parent = parent;
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		fecha = new JLabel("Fecha de la exposicion");
		springLayout.putConstraint(SpringLayout.WEST, fecha, 20, SpringLayout.EAST, this);
		
		JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 37, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -192, SpringLayout.EAST, this);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 110, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -177, SpringLayout.EAST, this);
		add(btnNewButton);
	}
	

	
}
