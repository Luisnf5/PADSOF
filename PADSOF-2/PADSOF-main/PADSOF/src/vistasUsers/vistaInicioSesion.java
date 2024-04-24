package vistasUsers;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import users.Gender;
import users.User;
import vistasSystem.vistaSystem;

public class vistaInicioSesion extends JPanel {
	vistaSystem parent;

	public vistaInicioSesion(vistaSystem parent) {
		this.parent = parent;
		
		this.setLayout(new GridLayout(4,1));
		
		JLabel etiquetaNif = new JLabel("NIF");
		JTextField campoNif = new JTextField(10);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña");
		JTextField campoContraseña = new JTextField(10);
		
		JButton iniciarSesion = new JButton("Iniciar Sesión");
		JButton volver = new JButton("Volver");
		
		volver.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {
		                	returnToMain();
		                 }
		           }
		       );
		
		iniciarSesion.addActionListener(
		           new ActionListener() {
		                 public void actionPerformed(ActionEvent e) {

		            		String pwd = campoContraseña.getText();
		            		String nif = campoNif.getText();
							
							if (nif.equals("")) {
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
		                 }
		           }
		       );
		
		this.add(etiquetaNif);
		this.add(campoNif);
		this.add(etiquetaContraseña);
		this.add(campoContraseña);
		this.add(iniciarSesion);
		this.add(volver);
		
		
	}
	
	private void returnToMain() {
		this.parent.returnToMain(this);
	}
}