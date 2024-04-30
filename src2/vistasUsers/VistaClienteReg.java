

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
		
		JLabel etiquetaNombre;
		JTextField campoNombre;
		JLabel etiquetaApellido;
		JTextField campoApellido;
		JLabel etiquetaNie;
		JTextField campoNie;
		JLabel etiquetaPwd;
		JTextField campoPwd;
		JLabel etiquetaDia;
		JTextField campoDia;
		JLabel etiquetaGender;
		ButtonGroup genderGroup;
		
		JRadioButton male;
		JRadioButton female;
		JRadioButton other;

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
			etiquetaNombre = new JLabel("Nombre");
			campoNombre = new JTextField(10);
			etiquetaApellido = new JLabel("Apellido");
			campoApellido = new JTextField(10);
			etiquetaNie = new JLabel("NIF");
			campoNie = new JTextField(10);
			etiquetaPwd = new JLabel("new Password");
			campoPwd = new JTextField(10);
			etiquetaDia = new JLabel("Fecha de Nacimiento \n (DD/MM/YYYY)");
			etiquetaDia.setHorizontalAlignment(SwingConstants.CENTER);
			campoDia = new JTextField(10);
			etiquetaGender = new JLabel("Gender");
			
			male = new JRadioButton("Masculino");
			female = new JRadioButton("Femenino");
			other = new JRadioButton("Otro");
			
			genderGroup = new ButtonGroup();
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
			this.registrarse.addActionListener(c);
			this.volver.addActionListener(c);
			
		}
		public JTextField getCampoNombre() {
			return campoNombre;
		}
		public JTextField getCampoApellido() {
			return campoApellido;
		}
		public JTextField getCampoNie() {
			return campoNie;
		}
		public JTextField getCampoPwd() {
			return campoPwd;
		}
		public JTextField getCampoDia() {
			return campoDia;
		}
		public ButtonGroup getGenderGroup() {
			return genderGroup;
		}
		public JRadioButton getMale() {
			return male;
		}
		public JRadioButton getFemale() {
			return female;
		}
		public JRadioButton getOther() {
			return other;
		}
		
}
