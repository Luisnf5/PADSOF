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
import works.Exhibition;

public class VistaExposicionPanel extends JPanel{
	private JLabel fecha;
	private JLabel precio; 
	private JLabel foto;
	private JLabel nombreExp;
	private JButton comprar;
	private VistaSystem parent;
	
	private Exhibition exhibition; 
	
	public VistaExposicionPanel(VistaSystem parent, Exhibition e) {
		this.parent = parent;
		this.exhibition = e;
		
		JPanel contenido = new JPanel();
		Dimension dContenido = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dThis = Toolkit.getDefaultToolkit().getScreenSize();
		
		dThis.width -= 200;
		dThis.height = 580;
		setPreferredSize(dThis);
		
		SpringLayout thisspringLayout = new SpringLayout();
		setLayout(thisspringLayout);
		SpringLayout springLayoutContenido = new SpringLayout();
		contenido.setLayout(springLayoutContenido);
		
		//Cambiamos al gusto

		dContenido.height = 520;
		dContenido.width -= 250;
		contenido.setPreferredSize(dContenido);
		contenido.setBackground(Color.cyan);
		
		add(contenido);
		thisspringLayout.putConstraint(SpringLayout.VERTICAL_CENTER, contenido, 0, SpringLayout.VERTICAL_CENTER, this);
		thisspringLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, contenido, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		//Vamos a añadir una foto a un boton
		this.foto = new JLabel();
		//Esta puesto al la resolucion de la imagen
		this.foto.setPreferredSize(new Dimension(375, 250));
		String pathLogo = VistaPrincipal.class.getResource("gallery.jpg").getPath();
        ImageIcon logo = new ImageIcon(pathLogo);
        this.foto.setIcon(logo);
        
        contenido.add(foto);
        springLayoutContenido.putConstraint(SpringLayout.VERTICAL_CENTER, foto, -50 , SpringLayout.VERTICAL_CENTER, contenido);
		springLayoutContenido.putConstraint(SpringLayout.HORIZONTAL_CENTER, foto, 0 , SpringLayout.HORIZONTAL_CENTER, contenido);
         
         
 		fecha = new JLabel("Fecha de la exposicion ");
 		contenido.add(fecha);
 		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 115, SpringLayout.NORTH, contenido);
 		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 200 , SpringLayout.WEST, contenido);
 		
 		fecha = new JLabel("Comienzo: ");
		contenido.add(fecha);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 130, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 200 , SpringLayout.WEST, contenido);
		
		fecha = new JLabel(this.exhibition.getStartDate().toLocalDate().toString());
		contenido.add(fecha);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 130, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 270 , SpringLayout.WEST, contenido);
		
		fecha = new JLabel("Fin: ");
		contenido.add(fecha);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 145, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 200 , SpringLayout.WEST, contenido);
		
		fecha = new JLabel(this.exhibition.getEndDate().toLocalDate().toString());
		contenido.add(fecha);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, fecha, 145, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.WEST, fecha, 270 , SpringLayout.WEST, contenido);
        
		precio = new JLabel("Precio entrada: ");
		contenido.add(precio);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, precio, 115, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.EAST, precio, -250 , SpringLayout.EAST, contenido);
		
		precio = new JLabel(String.format( "%.2f€",this.exhibition.getPrice()));
		contenido.add(precio);
		springLayoutContenido.putConstraint(SpringLayout.NORTH, precio, 130, SpringLayout.NORTH, contenido);
		springLayoutContenido.putConstraint(SpringLayout.EAST, precio, -260 , SpringLayout.EAST, contenido);
		
		nombreExp = new JLabel("EXPOSICION");
		contenido.add(nombreExp);
		springLayoutContenido.putConstraint(SpringLayout.VERTICAL_CENTER, nombreExp, -250 , SpringLayout.VERTICAL_CENTER, contenido);
		springLayoutContenido.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreExp, 0 , SpringLayout.HORIZONTAL_CENTER, contenido);
		
		nombreExp = new JLabel(this.exhibition.getTitle());
		contenido.add(nombreExp);
		springLayoutContenido.putConstraint(SpringLayout.VERTICAL_CENTER, nombreExp, -230 , SpringLayout.VERTICAL_CENTER, contenido);
		springLayoutContenido.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreExp, 0 , SpringLayout.HORIZONTAL_CENTER, contenido);
		
		comprar = new JButton("Comprar Entradas");
		contenido.add(comprar);
		springLayoutContenido.putConstraint(SpringLayout.VERTICAL_CENTER, comprar, 150 , SpringLayout.VERTICAL_CENTER, contenido);
		springLayoutContenido.putConstraint(SpringLayout.HORIZONTAL_CENTER, comprar, 0 , SpringLayout.HORIZONTAL_CENTER, contenido);
		
		
		
	}
	
	public Exhibition getExhibition() {
		return exhibition;
	}
	
	public void setControlador(ActionListener c) {
		comprar.addActionListener(c);
	}
}
