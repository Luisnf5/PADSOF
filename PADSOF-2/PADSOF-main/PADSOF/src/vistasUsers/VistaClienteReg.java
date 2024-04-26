
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
		ControladorClienteReg controlador = new ControladorClienteReg();
		VistaSystem parent;

		public VistaClienteReg(VistaSystem parent) {
			
		
			
			
			
			super(new GridLayout(6, 1));
			this.parent = parent;
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			this.setLocation(0, 0);
			setPreferredSize(new Dimension((int)screenSize.getWidth()/3, (int)screenSize.getHeight()/3));
			
			JPanel row1 = new JPanel(new GridLayout(2,2));
			JPanel row2 = new JPanel(new GridLayout(2,4));
			JPanel row3 = new JPanel(new GridLayout(1,3));
			JPanel row4 = new JPanel(new GridLayout(1,3));
			JPanel row5 = new JPanel(new BorderLayout());
			
			
			
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
			
			JButton registrarse = new JButton("Resgistrarse");
			JButton volver = new JButton("Volver");
			
			registrarse.setPreferredSize(new Dimension(150, 25));
			
			// asociar acciones a componentes
			registrarse.addActionListener(
			           new ActionListener() {
			                 public void actionPerformed(ActionEvent e) {
			                	String fecha = campoDia.getText();
			            		String nombre = campoNombre.getText();
			            		String apellido = campoApellido.getText();
			            		String pwd = campoPwd.getText();
			            		String nie = campoNie.getText();
			            		String patronFecha = "\\d{2}/\\d{2}/\\d{4}";
			            		String patronNif = "\\d{8}[A-Za-z]";
			            		ButtonModel selected = genderGroup.getSelection();
								Gender genderSelected = null;
								
								if (fecha.equals("")) {
									JOptionPane.showMessageDialog(null, "Introduzca una fecha de nacimiento");
									return;
								}else if (nombre.equals("")) {
									JOptionPane.showMessageDialog(null, "Introduzca un nombre");
									return;
								}
								else if (apellido.equals("")) {
									JOptionPane.showMessageDialog(null, "Introduzca un apellido");
									return;
								}
								else if (nie.equals("")) {
									JOptionPane.showMessageDialog(null, "introduzca un NIF");
									return;
								}
								else if (pwd.equals("")) {
									JOptionPane.showMessageDialog(null, "Introduzca una contraseña");
									return;
								}else if (!fecha.matches(patronFecha)) {
									JOptionPane.showMessageDialog(null, "Introduzca una fecha con un formato valido \n(DD/MM/YYYY)");
									return;
								}else if (!User.isPwdValidStatic(pwd)) {
									JOptionPane.showMessageDialog(null, "Introduzca una contraseña valida. Debe contener:\n\tUn numero\n\tUna letra minúscula\n\tUna letra mayúscula\n\tSu longitud debe ser mayor o igual a 8");
									return;
								}else if (!nie.matches(patronNif)) {
									JOptionPane.showMessageDialog(null, "Introduzca un NIF valido con 8 numeros y una letra mayúscula");
									return;
								}else if (selected == null) {
									JOptionPane.showMessageDialog(null, "Seleccione un genero");
									return;
								}
								 
								if (selected == male.getModel()) {
									genderSelected = Gender.MALE;
								}else if (selected == female.getModel()) {
									genderSelected = Gender.MALE;
								}else if (selected == other.getModel()) {
									genderSelected = Gender.OTHER;
								}
 

								int dia_f = Integer.parseInt(fecha.split("/")[0]);
								int mes_f = Integer.parseInt(fecha.split("/")[1]);
								int ano_f = Integer.parseInt(fecha.split("/")[2]);

								if (controlador.addCliente(nombre, apellido, nie, genderSelected, dia_f, mes_f, ano_f, pwd)) {
									JOptionPane.showMessageDialog(null, "Nuevo cliente creado con éxito");
									returnToMain();
								}else {
									JOptionPane.showMessageDialog(null, "Error, ya existe un cliente con ese NIF");
									return;
								}
							
		
			                 }
			           }
			       );
			
			volver.addActionListener(
			           new ActionListener() {
			                 public void actionPerformed(ActionEvent e) {
			                	returnToMain();
			                 }
			           }
			       );
			
			// aniadir componentes al contenedor
			
			row1.add(etiquetaDia);
			row1.add(etiquetaNie);
			row1.add(campoDia);
			row1.add(campoNie);

			this.add(row1);
			
			row2.add(etiquetaNombre);
			row2.add(etiquetaApellido);
			row2.add(campoNombre);
			row2.add(campoApellido);
			this.add(row2);
			
			
			row3.add(etiquetaGender);
			row3.add(male);
			row3.add(female);
			row3.add(other);
			this.add(row3);
			
			
			
			row4.add(etiquetaPwd);
			row4.add(campoPwd);
			this.add(row4);
			
			row5.add(registrarse, BorderLayout.EAST);
			row5.add(volver, BorderLayout.WEST);
			this.add(row5);
			
			
		}
		
		private void returnToMain() {
			this.parent.returnToMain(this);
		}
}