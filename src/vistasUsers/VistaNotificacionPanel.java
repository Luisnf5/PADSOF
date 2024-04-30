package vistasUsers;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import users.Notification;
import users.Raffle;
import vistasSystem.VistaSystem;

public class VistaNotificacionPanel extends JPanel{
	private Notification notificacion;
	
	private VistaSystem parent;
	
	private JButton borrar;
	private JLabel titulo;
	private JLabel descripcion;
	
	
	public VistaNotificacionPanel(VistaSystem parent, Notification noti) {
		this.parent = parent;
		this.notificacion = noti;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		
		this.setPreferredSize(new Dimension(1100, 100));
		
		
		this.titulo = new JLabel(noti.getTitle());
		this.descripcion = new JLabel("<html>" + noti.getDescription().replaceAll("\n", "<br>") + "<html>");
		this.borrar = new JButton("Borrar");

		layout.putConstraint(SpringLayout.NORTH, titulo, (int) ((altoPanel - titulo.getHeight())/2+40), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.WEST, this);
		this.add(titulo);
		
		layout.putConstraint(SpringLayout.NORTH, descripcion, (int) ((altoPanel - descripcion.getHeight())/2), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, descripcion, 20, SpringLayout.EAST, titulo);
		descripcion.setPreferredSize(new Dimension(800, 100));
		this.add(descripcion);
		
		layout.putConstraint(SpringLayout.NORTH, borrar, (int) ((altoPanel - borrar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, borrar, 20, SpringLayout.EAST, descripcion);
		this.add(borrar);
	}
	
	public void setControlador(ActionListener c) {
		borrar.addActionListener(c);
	}

	public Notification getNotificacion() {
		return notificacion;
	}
	
}
