
package vistasUsers;

import javax.swing.*;

import controladores.ControladorClienteReg;
import systemTester.systemTester;
import users.Client;
import users.Gender;
import users.User;
import vistasSystem.VistaSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;





public class VistaClienteReg extends JPanel {
		private static final long serialVersionUID = 1L;
		VistaSystem parent; 
		
		JButton registrarse;
		JButton volver;

		public VistaClienteReg(VistaSystem parent) {
			
			
			super(new GridLayout(6, 1));
			this.parent = parent;
			
			this.setLocation(0, 0);
			setPreferredSize(new Dimension(600, 400));
			
			JPanel row1 = new JPanel(new GridLayout(2,2));
			JPanel row2 = new JPanel(new GridLayout(2,4));
			JPanel row3 = new JPanel(new GridLayout(1,3));
			JPanel row4 = new JPanel(new GridLayout(1,3));
			
			
			
			// crear componentes
			JLabel etiquetaNombre = new JLabel("Nombre");
			JTextField campoNombre = new JTextField(10);
			JLabel etiquetaApellido = new JLabel("Apellido");
			JTextField campoApellido = new JTextField(10);
			JLabel etiquetaNie = new JLabel("NIF");
			JTextField campoNie = new JTextField(10);
			JLabel etiquetaPwd = new JLabel("new Password");
			JTextField campoPwd = new JTextField(10);
			JLabel etiquetaDia = new JLabel("Fecha de Nacimiento \n (DD/MM/YYYY)");
			etiquetaDia.setHorizontalAlignment(SwingConstants.CENTER);
			JTextField campoDia = new JTextField(10);
			JTextField campoGender = new JTextField(10);
			JLabel etiquetaGender = new JLabel("Gender");
			
			JRadioButton male = new JRadioButton("Masculino");
			JRadioButton female = new JRadioButton("Femenino");
			JRadioButton other = new JRadioButton("Otro");
			
			ButtonGroup genderGroup = new ButtonGroup();
			genderGroup.add(male);
			genderGroup.add(female);
			genderGroup.add(other);
			
			this.registrarse = new JButton("Resgistrarse");
			this.volver = new JButton("Volver");
			
			
			
			// aniadir componentes al contenedor
			
			row1.add(etiquetaDia);
			row1.add(etiquetaNie);
			row1.add(campoDia);
			row1.add(campoNie);
			row1.setBackground(Color.cyan);
			this.add(row1);
			this.setBackground(Color.cyan);
			
			row2.add(etiquetaNombre);
			row2.add(etiquetaApellido);
			row2.add(campoNombre);
			row2.add(campoApellido);
			row2.setBackground(Color.cyan);
			this.add(row2);
			
			
			row3.add(etiquetaGender);
			row3.add(male);
			row3.add(female);
			row3.add(other);
			row3.setBackground(Color.cyan);
			this.add(row3);
			
			
			
			row4.add(etiquetaPwd);
			row4.add(campoPwd);
			row4.setBackground(Color.cyan);
			this.add(row4);
			
			this.add(registrarse);
			this.add(volver);
			
		}
		
		public void setControlador(ActionListener c) {
			registrarse.addActionListener(c);
			volver.addActionListener(c);
			
		}
		
}