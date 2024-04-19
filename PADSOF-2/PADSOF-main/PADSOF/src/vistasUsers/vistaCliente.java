package vistasUsers;

import javax.swing.*;

import controladores.ControladorCliente;
import systemTester.systemTester;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

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
		JLabel etiquetaNombre = new JLabel("Nombre");
		JTextField campoNombre = new JTextField(10);
		JLabel etiquetaApellido = new JLabel("Apellido");
		JTextField campoApellido = new JTextField(10);
		JLabel etiquetaNie = new JLabel("NIE");
		JTextField campoNie = new JTextField(10);
		JLabel etiquetaPwd = new JLabel("new Password");
		JTextField campoPwd = new JTextField(10);
		JLabel etiquetaDia = new JLabel("Dia");
		JTextField campoDia = new JTextField(10);
		JLabel etiquetaMes = new JLabel("Mes");
		JTextField campoMes = new JTextField(10);
		JLabel etiquetaAno = new JLabel("Año");
		JTextField campoGender = new JTextField(10);
		JLabel etiquetaGender = new JLabel("Gender");
		JTextField campoAno = new JTextField(10);
;
		JButton boton = new JButton("Haz click");
		
		// asociar acciones a componentes
		boton.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                	 systemTester.main(null);
		                      JOptionPane.showMessageDialog(null, 
		                    		  new ControladorCliente().addCliente(campoNombre.getText(), campoApellido.getText(), campoNie.getText(), campoGender.getText(), campoDia.getText(), campoMes.getText(), campoAno.getText(), campoPwd.getText())
		                      );
		                     
		                      
		                 }
		           }
		       );
		
		// aniadir componentes al contenedor
		contenedor.add(etiquetaNombre);
		contenedor.add(campoNombre);
		contenedor.add(etiquetaApellido);
		contenedor.add(campoApellido);
		contenedor.add(etiquetaNie);
		contenedor.add(campoNie);
		contenedor.add(etiquetaPwd);
		contenedor.add(campoPwd);
		contenedor.add(etiquetaDia);
		contenedor.add(campoDia);
		contenedor.add(etiquetaMes);
		contenedor.add(campoMes);
		contenedor.add(etiquetaAno);
		contenedor.add(campoAno);
		contenedor.add(etiquetaGender);
		contenedor.add(campoGender);
		contenedor.add(boton);
		
		// mostrar ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(250,140);
		ventana.setVisible(true);	
	}
}
