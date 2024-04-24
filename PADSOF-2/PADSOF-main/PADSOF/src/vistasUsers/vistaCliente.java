
package vistasUsers;

import javax.swing.*;

import controladores.ControladorCliente;
import systemTester.systemTester;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;





public class vistaCliente extends JPanel {
		private static final long serialVersionUID = 1L;
		

		public vistaCliente() {
		
			
			
			
			
			
			this.setLayout(new FlowLayout());
			
			
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

			JButton registrarse = new JButton("Resgistrarse");
			
			// asociar acciones a componentes
			registrarse.addActionListener(
			           new ActionListener() {
			                 public void actionPerformed(ActionEvent e) {
			                      JOptionPane.showMessageDialog(null, 
			                    		  new ControladorCliente().addCliente(campoNombre.getText(), campoApellido.getText(), campoNie.getText(), campoGender.getText(), campoDia.getText(), campoMes.getText(), campoAno.getText(), campoPwd.getText())
			                      
			                      );
			                      
			                     
			                 }
			           }
			       );
			
			// aniadir componentes al contenedor
			this.add(etiquetaNombre);
			this.add(campoNombre);
			this.add(etiquetaApellido);
			this.add(campoApellido);
			this.add(etiquetaNie);
			this.add(campoNie);
			this.add(etiquetaPwd);
			this.add(campoPwd);
			this.add(etiquetaDia);
			this.add(campoDia);
			this.add(etiquetaMes);
			this.add(campoMes);
			this.add(etiquetaAno);
			this.add(campoAno);
			this.add(etiquetaGender);
			this.add(campoGender);
			this.add(registrarse);

			
			
		}
		
		
		

	}