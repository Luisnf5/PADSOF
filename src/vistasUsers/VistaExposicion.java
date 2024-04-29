package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
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
	private JButton buton;
	
	public VistaExposicion(VistaSystem parent) {
		this.parent = parent;

		
		SpringLayout springLayout = new SpringLayout();
		buton = new JButton("DOnt give");
		add(buton);
		
		for(int i = 0; i < 10; i++) {
			this.add(new VistaExposicionPanel(parent));
		}
		
		
		
		
		
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void setControlador(ActionListener c) {
		
	}

	
}
