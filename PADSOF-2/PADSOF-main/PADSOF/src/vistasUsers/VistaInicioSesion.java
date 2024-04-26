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

import controladores.ControladorClienteReg;
import users.Gender;
import users.User;
import vistasSystem.VistaSystem;

public class VistaInicioSesion extends JPanel {
	VistaSystem parent;

	public VistaInicioSesion(VistaSystem parent) {
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
							}else if (!ControladorClienteReg.iniciarSesion(nif, pwd)) {
								JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
								return;
							}
							JOptionPane.showMessageDialog(null, "Bienvenido");
							goToInicioCliente();
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
	
	private void goToInicioCliente() {
		parent.goToInicioCliente(this);
	}
}