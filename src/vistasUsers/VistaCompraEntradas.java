package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;

public class VistaCompraEntradas  extends JPanel{
	
	private VistaSystem parent;
	
	private JPanel panelNum;
	private JLabel numEntradas;
	
	private JButton botonMas;
    private JButton botonMenos;
    private JTextField seleccion;
	
	public VistaCompraEntradas(VistaSystem parent) {
		
		
		this.parent = parent;
		
		SpringLayout thisspringLayout = new SpringLayout();
		setLayout(thisspringLayout);
		
		
		Dimension dThis = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setPreferredSize(dThis);
		
		SpringLayout panelNumLayout = new SpringLayout();
		Dimension dpanelNum = Toolkit.getDefaultToolkit().getScreenSize();
		 
		panelNum = new JPanel();
		panelNum.setLayout(panelNumLayout);
		panelNum.setPreferredSize(new Dimension(300, 300));
		panelNum.setBackground(Color.LIGHT_GRAY);
		
		
		numEntradas = new JLabel("Seleccione el número de entradas");
		panelNum.add(numEntradas);
		panelNumLayout.putConstraint(SpringLayout.VERTICAL_CENTER, numEntradas, -100, SpringLayout.VERTICAL_CENTER, panelNum);
		panelNumLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, numEntradas, 0, SpringLayout.HORIZONTAL_CENTER, panelNum);
		
		botonMas = new JButton("+");
		botonMas.setPreferredSize(new Dimension(50, 30));
		panelNum.add(botonMas);
		panelNumLayout.putConstraint(SpringLayout.NORTH, botonMas, 110, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, botonMas, -50, SpringLayout.EAST, panelNum);
		
		botonMenos = new JButton("-");
		botonMenos.setPreferredSize(new Dimension(50, 30));
		panelNum.add(botonMenos);
		panelNumLayout.putConstraint(SpringLayout.NORTH, botonMenos, 140, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, botonMenos, -50, SpringLayout.EAST, panelNum);
		
		seleccion = new JTextField("0", 5);
		seleccion.setPreferredSize(new Dimension(70, 30));
		panelNum.add(seleccion);
		panelNumLayout.putConstraint(SpringLayout.NORTH, seleccion, 125, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, seleccion, -100, SpringLayout.EAST, panelNum);
		
		botonMas.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                incrementar();
            }
        });

        botonMenos.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                decrementar();
            }
        });
		
		
		add(panelNum);
		thisspringLayout.putConstraint(SpringLayout.NORTH, panelNum, 300, SpringLayout.NORTH, this);
		thisspringLayout.putConstraint(SpringLayout.EAST, panelNum, -200, SpringLayout.EAST, this);
		
		
		
	}
	
	
	private void incrementar() {
	        int valorActual = Integer.parseInt(seleccion.getText());
	        seleccion.setText(Integer.toString(valorActual + 1));
	    }
	
	private void decrementar() {
	        int valorActual = Integer.parseInt(seleccion.getText());
	        seleccion.setText(Integer.toString(valorActual - 1));
	    }
	
	
	public void setControlador(ActionListener c) {
		//this.botonMas
	}
	
	
	
}
