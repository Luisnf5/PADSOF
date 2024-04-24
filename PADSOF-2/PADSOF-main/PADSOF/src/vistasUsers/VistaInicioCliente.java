package vistasUsers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vistasSystem.vistaSystem;

public class VistaInicioCliente extends JPanel{
	private vistaSystem parent;
	
	public VistaInicioCliente(vistaSystem parent) {
		super(new GridLayout(3,1));
		
		this.parent = parent;
		this.setLayout(new FlowLayout());
		
		
		JPanel superior = new JPanel(new GridLayout(0,6));
		superior.setPreferredSize(new Dimension(this.getWidth(), 200));
		
		JLabel imagenLogo = new JLabel();
		ImageIcon logo = new ImageIcon("logo.jpg");
		imagenLogo.setIcon(logo);
		
		JTextField buscar = new JTextField("Buscar");
		
		JButton notificaciones = new JButton("Notificaciones");
		JButton sorteos = new JButton("Sorteos");
		JButton contacto = new JButton("Contacto");
		
		superior.add(imagenLogo);
		superior.add(buscar);
		superior.add(notificaciones);
		superior.add(sorteos);
		superior.add(contacto);
		
		
		JPanel eventosCurso = new JPanel();
		eventosCurso.setPreferredSize(new Dimension(this.getWidth(), 400));
		
		
		JPanel eventosProximo = new JPanel();
		eventosProximo.setPreferredSize(new Dimension(this.getWidth(), 400));
		
		
		
		this.add(superior, BorderLayout.NORTH);
		this.add(eventosCurso);
		this.add(eventosProximo);
		
	}
}
