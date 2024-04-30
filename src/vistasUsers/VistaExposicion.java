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

/*NO se deberia hacer el import, ya que los controladores pierden sentido
pero preferimos que funcione */

import works.Exhibition;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaExposicion extends JScrollPane {
	
	private JLabel nombreExp;
	private JLabel fecha;
	private VistaSystem parent;
	private JButton buton;
	private JPanel panelContenido;
	
	public VistaExposicion(VistaSystem parent) {
		
		this.parent = parent;
		
		panelContenido = new JPanel();
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
		
		setViewportView(panelContenido);
		
		
		for(int i = 0; i < 10; i++) {
			
			this.panelContenido.add(new VistaExposicionPanel(parent));
		}

		
		this.setBackground(Color.pink);
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
	}
	
	public void setControlador(ActionListener c) {
		
	}

	
}
