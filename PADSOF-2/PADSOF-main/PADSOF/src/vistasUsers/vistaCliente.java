package vistasUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class vistaCliente extends JFrame {
	private static final long serialVersionUID = 1L;

	public vistaCliente() {
		
		
		
		
	}
	
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Mi GUI. Ejemplo 1");
		
		// obtener contenedor, asignar layout
		Container contenedor = ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		// crear componentes
		JLabel etiqueta = new JLabel("Nombre");
		JTextField campo = new JTextField(10);
		JButton boton = new JButton("Haz click");
		
		// asociar acciones a componentes
		boton.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                      JOptionPane.showMessageDialog(null, campo.getText());
		                 }
		           }
		       );
		
		// aniadir componentes al contenedor
		contenedor.add(etiqueta);
		contenedor.add(campo);
		contenedor.add(boton);
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(250,140);
		ventana.setVisible(true);	
	}
}
