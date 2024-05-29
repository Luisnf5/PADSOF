package vistasUsers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import vistasSystem.VistaSystem;
import works.Exhibition;

public class VistaCompraEntradas  extends JPanel{
	
	private VistaSystem parent;
	
	private JPanel panelNum;
	private JLabel numEntradas;
	
	private JLabel generic;
	private JButton bGeneric;
	
	private JLabel nombreExpo; 
	private JLabel fechaInicio;
	private JLabel fechaFin;
	private JLabel precio;
	private JTextField fechaElegida;
	private JButton comprar;
	
	private JButton botonMas;
    private JButton botonMenos;
    private JTextField seleccion;
    private JPasswordField pass;
    
    private Exhibition exhibition;
	
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
		panelNum.setPreferredSize(new Dimension(600, 400));
		panelNum.setBackground(Color.LIGHT_GRAY);
		
		
		
		nombreExpo = new JLabel();
		panelNum.add(nombreExpo);
		panelNumLayout.putConstraint(SpringLayout.NORTH, nombreExpo, 10, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, nombreExpo, 5, SpringLayout.WEST, panelNum);
		
		fechaFin = new JLabel();
		panelNum.add(fechaFin);
		panelNumLayout.putConstraint(SpringLayout.NORTH, fechaFin, 50, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, fechaFin, 5, SpringLayout.WEST, panelNum);
		
		fechaInicio = new JLabel();
		panelNum.add(fechaInicio);
		panelNumLayout.putConstraint(SpringLayout.NORTH, fechaInicio, 70, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, fechaInicio, 5, SpringLayout.WEST, panelNum);
		
		generic = new JLabel("Introduzca fecha y hora (DD/MM/YYYY/HH): ");
		panelNum.add(generic);
		panelNumLayout.putConstraint(SpringLayout.NORTH, generic, 90, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, generic, 5, SpringLayout.WEST, panelNum);
		
		generic = new JLabel("(Elige de 10 a 19 horas, sesión por hora)");
		panelNum.add(generic);
		panelNumLayout.putConstraint(SpringLayout.NORTH, generic, 105, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, generic, 5, SpringLayout.WEST, panelNum);
		
		fechaElegida = new JTextField();
		fechaElegida.setPreferredSize(new Dimension(100, 30));
		panelNum.add(fechaElegida);
		panelNumLayout.putConstraint(SpringLayout.NORTH, fechaElegida, 125, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.WEST, fechaElegida, 30, SpringLayout.WEST, panelNum);
		
		generic = new JLabel("Total a pagar: ");
		panelNum.add(generic);
		panelNumLayout.putConstraint(SpringLayout.NORTH, generic, 200, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, generic, -480, SpringLayout.EAST, panelNum);
		
		precio = new JLabel();
		panelNum.add(precio);
		panelNumLayout.putConstraint(SpringLayout.NORTH, precio, 200, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, precio, -350, SpringLayout.EAST, panelNum);

		
		numEntradas = new JLabel("Seleccione el número de entradas");
		panelNum.add(numEntradas);
		panelNumLayout.putConstraint(SpringLayout.NORTH, numEntradas, 90, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, numEntradas, -50, SpringLayout.EAST, panelNum);
		
		bGeneric = new JButton("Volver");
		panelNum.add(bGeneric);
		panelNumLayout.putConstraint(SpringLayout.NORTH, bGeneric, 250, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, bGeneric, -450, SpringLayout.EAST, panelNum);
		
		comprar = new JButton("Comprar");
		panelNum.add(comprar);
		panelNumLayout.putConstraint(SpringLayout.NORTH, comprar, 250, SpringLayout.NORTH, panelNum);
		panelNumLayout.putConstraint(SpringLayout.EAST, comprar, -50, SpringLayout.EAST, panelNum);
		
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
                updateExhibition(exhibition);
            }
        });

        botonMenos.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                decrementar();
                updateExhibition(exhibition);
            }
        });
		
		
		add(panelNum);
		thisspringLayout.putConstraint(SpringLayout.VERTICAL_CENTER, panelNum, -100, SpringLayout.VERTICAL_CENTER, this);
		thisspringLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panelNum, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		
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
		comprar.addActionListener(c);
		bGeneric.addActionListener(c);
	}
	
	public void updateExhibition(Exhibition e) {
		this.exhibition = e;
		
		this.nombreExpo.setText("PROCESO DE COMPRA DE: "+ e.getTitle());
		this.fechaFin.setText("Hasta: " + e.getEndDate().toLocalDate().toString());
		this.fechaInicio.setText("Desde: " + e.getStartDate().toLocalDate().toString());
		this.precio.setText(String.format("%.2f€", Double.parseDouble(seleccion.getText())* e.getPrice()));
		
	}



	public JTextField getFechaElegida() {
		return fechaElegida;
	}



	public Exhibition getExhibition() {
		return exhibition;
	}



	public JTextField getSeleccion() {
		return seleccion;
	}
	
	
	
}
