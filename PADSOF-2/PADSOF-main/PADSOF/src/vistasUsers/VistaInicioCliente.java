package vistasUsers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vistasSystem.VistaSystem;

public class VistaInicioCliente extends JPanel{
	private VistaSystem parent;
	
	public VistaInicioCliente(VistaSystem parent) {
		super(new GridLayout(4,1));
		
		this.parent = parent;
		this.setPreferredSize(new Dimension(1500, 900));
		
		
		JPanel superior = new JPanel(new GridLayout(1,6));
		
		superior.setBackground(Color.BLUE);
		superior.setVisible(true);
		JLabel imagenLogo = new JLabel();
		ImageIcon logo = new ImageIcon("logo.jpg");
		imagenLogo.setIcon(logo);
		imagenLogo.setLocation(40, 50);
		
		JTextField buscar = new JTextField("Buscar");
		
		JButton notificaciones = new JButton("Notificaciones");
		JButton sorteos = new JButton("Sorteos");
		JButton contacto = new JButton("Contacto");
		
		superior.add(imagenLogo);
		superior.add(buscar);
		superior.add(notificaciones);
		superior.add(sorteos);
		superior.add(contacto);
		superior.setPreferredSize(new Dimension((int)this.getWidth(), 50));
		
		
		JPanel eventosCurso = new JPanel();
		eventosCurso.setPreferredSize(new Dimension(500, 200));
		
		
		JPanel eventosProximo = new JPanel();
		eventosProximo.setPreferredSize(new Dimension(500, 200));
		
		
		
		this.add(superior);
		eventosCurso.setBackground(Color.RED);
		this.add(new JPanel());
		this.add(eventosCurso);
		eventosProximo.setBackground(Color.MAGENTA);
		this.add(eventosProximo);
		
	}
}
