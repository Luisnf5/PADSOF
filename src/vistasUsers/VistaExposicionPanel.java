package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	private JButton foto;
	
	public VistaExposicionPanel(VistaSystem parent) {
		JPanel contenido = new JPanel();
		Dimension dThis = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dContenido = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.parent = parent;
		
		//Cambiamos al gusto la dimension
		dThis.height = 600;
		this.setPreferredSize(dThis);
		
		
		dContenido.height = 580;
		dContenido.width -= 100;
		contenido.setBackground(Color.cyan);
		contenido.setPreferredSize(dContenido);
		
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		SpringLayout springLayoutContenido = new SpringLayout();
		contenido.setLayout(springLayoutContenido);
		add(contenido);
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, contenido, 0, SpringLayout.VERTICAL_CENTER, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, contenido, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//Vamos a añadir una foto a un boton
		this.foto = new JButton();
		//Esta puesto al la resolucion de la imagen
		this.foto.setPreferredSize(new Dimension(375, 250));
		String pathLogo = VistaPrincipal.class.getResource("gallery.jpg").getPath();
        ImageIcon logo = new ImageIcon(pathLogo);
        this.foto.setIcon(logo);
        contenido.add(foto);
        springLayoutContenido.putConstraint(SpringLayout.NORTH, foto, 100, SpringLayout.NORTH, contenido);
        springLayoutContenido.putConstraint(SpringLayout.WEST, foto, 550, SpringLayout.WEST, contenido);
        
        
		fecha = new JLabel("Fecha de la exposicion");
		contenido.add(fecha);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 100, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 250 , SpringLayout.WEST, contenido);
		
		
		this.buton = new JButton("Volver");
		add(buton);
		springLayout.putConstraint(SpringLayout.NORTH, buton, 100, SpringLayout.SOUTH, contenido);
		springLayout.putConstraint(SpringLayout.EAST, buton, 100, SpringLayout.WEST, contenido);
		
		
	}
	
	
	public void setControlador(ActionListener c) {
		foto.addActionListener(c);
	}
	
	
	
}
