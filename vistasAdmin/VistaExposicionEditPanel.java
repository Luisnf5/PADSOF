package vistasAdmin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import system.ArtGallery;
import vistasSystem.VistaSystem;
import works.Exhibition;
import works.ExhibitionStatus;
import works.SubRoom;

public class VistaExposicionEditPanel extends JPanel{
	private Exhibition exhibition;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton editar;
	private JButton borrar;
	
	private JTextField nombre;
	private JTextField autor;
	private JTextField fechaInicio;
	private JTextField fechaFinal;
	private JTextField precio;
	
	private JLabel nombreLabel;
	private JLabel autorLabel;
	private JLabel fechaInicioLabel;
	private JLabel fechaFinalLabel;
	private JLabel precioLabel;
	
	private JLabel info;
	
	private JList<String> salas;
	private JScrollPane salasScroll;
	
	private ArrayList<String> salasOriginales = new ArrayList<String>();
	
	
	public VistaExposicionEditPanel(VistaSystem parent, Exhibition ex, boolean newExhibition) {
		this.parent = parent;
		this.exhibition = ex;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
        d2.width -= 450;
        d2.height = 150;
		
		this.setPreferredSize(d2);
		
		this.nombre = new JTextField(exhibition.getTitle());
		this.autor = new JTextField(exhibition.getAuthor());
		String fechaInicioString = String.format("%02d/%02d/%04d", exhibition.getStartDate().getDayOfMonth(), exhibition.getStartDate().getMonthValue(), exhibition.getStartDate().getYear());
		this.fechaInicio = new JTextField(fechaInicioString);
		String fechaFinalString = String.format("%02d/%02d/%04d", exhibition.getEndDate().getDayOfMonth(), exhibition.getEndDate().getMonthValue(), exhibition.getEndDate().getYear());
		this.fechaFinal = new JTextField(fechaFinalString);
		String precioString = String.format("%.2f€", ex.getPrice());
		this.precio = new JTextField(precioString);
		
		this.nombreLabel = new JLabel("Título");
		this.autorLabel = new JLabel("Autor");
		this.fechaInicioLabel = new JLabel("Inicio");
		this.fechaFinalLabel = new JLabel("Final");
		this.precioLabel = new JLabel("Precio");
		this.info = new JLabel("<html>Para seleccionar varias<br>salas pulse CTRL + Click</html>");
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		Set<SubRoom> rooms = ArtGallery.getSystem().getSubRooms();
		int i = 0;
		ArrayList<Integer> indexes = new ArrayList<>();
		for (SubRoom sr : rooms) {
			if (!sr.isExposing()) {
				listModel.addElement(sr.getName());
				i++;
			}else if (sr.isExposing() && sr.getSrb().getExpo() == ex) {
				listModel.addElement(sr.getName());
				indexes.add(i);
				salasOriginales.add(sr.getName());
				System.out.println(sr.getName() + "is exposing this");
				i++;
			}
			
		}
		
		salas = new JList<>(listModel);
		salas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		salasScroll = new JScrollPane(salas);
		salas.setSelectedIndices(indexes.stream().mapToInt(Integer::intValue).toArray());

		
		if (newExhibition) {
			this.confirmar = new JButton("Crear Exposición");
			confirmar.setBackground(Color.CYAN);
		}else if (exhibition.getStatus() == ExhibitionStatus.DRAFT) {
			this.confirmar = new JButton("Publicar Exposición");
			confirmar.setBackground(Color.GREEN);
		}else {
			this.confirmar = new JButton("Cancelar Exposición");
			confirmar.setBackground(Color.RED);
			confirmar.setForeground(Color.white);
		}
		
		this.editar = new JButton("Editar Exposición");
		this.editar.setBackground(Color.BLUE);
		this.editar.setForeground(Color.WHITE);
		
		this.borrar = new JButton("Borrar Selección");
		
		
		
		layout.putConstraint(SpringLayout.NORTH, nombreLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombreLabel, 20, SpringLayout.WEST, this);
		nombreLabel.setPreferredSize(new Dimension(60, 20));
		this.add(nombreLabel);
		
		layout.putConstraint(SpringLayout.NORTH, autorLabel, 5, SpringLayout.SOUTH, nombreLabel);
		layout.putConstraint(SpringLayout.WEST, autorLabel, 20, SpringLayout.WEST, this);
		autorLabel.setPreferredSize(new Dimension(60, 20));
		this.add(autorLabel);

		layout.putConstraint(SpringLayout.NORTH, nombre, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombre, 5, SpringLayout.EAST, nombreLabel);
		nombre.setPreferredSize(new Dimension(80, 20));
		this.add(nombre);
		
		layout.putConstraint(SpringLayout.NORTH, autor, 5, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.WEST, autor, 5, SpringLayout.EAST, autorLabel);
		autor.setPreferredSize(new Dimension(80, 20));
		this.add(autor);
		
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicioLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicioLabel, 10, SpringLayout.EAST, nombre);
		fechaInicioLabel.setPreferredSize(new Dimension(40, 20));
		this.add(fechaInicioLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinalLabel, 25, SpringLayout.NORTH, fechaInicioLabel);
		layout.putConstraint(SpringLayout.WEST, fechaFinalLabel, 10, SpringLayout.EAST, nombre);
		fechaFinalLabel.setPreferredSize(new Dimension(40, 20));
		this.add(fechaFinalLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fechaInicio, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaInicio, 5, SpringLayout.EAST, fechaInicioLabel);
		fechaInicio.setPreferredSize(new Dimension(130, 20));
		this.add(fechaInicio);
		
		layout.putConstraint(SpringLayout.NORTH, fechaFinal, 5, SpringLayout.SOUTH, fechaInicio);
		layout.putConstraint(SpringLayout.WEST, fechaFinal, 5, SpringLayout.EAST, fechaFinalLabel);
		fechaFinal.setPreferredSize(new Dimension(130, 20));
		this.add(fechaFinal);
		
		layout.putConstraint(SpringLayout.NORTH, precioLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, precioLabel, 10, SpringLayout.EAST, fechaFinal);
		precioLabel.setPreferredSize(new Dimension(40, 20));
		this.add(precioLabel);
		
		layout.putConstraint(SpringLayout.NORTH, precio, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, precio, 10, SpringLayout.EAST, precioLabel);
		precio.setPreferredSize(new Dimension(40, 20));
		this.add(precio);
		
		layout.putConstraint(SpringLayout.NORTH, info, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-45, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.EAST, precio);
		info.setPreferredSize(new Dimension(150, 40));
		this.add(info);
		
		layout.putConstraint(SpringLayout.NORTH, salasScroll, 5, SpringLayout.SOUTH, info);
		layout.putConstraint(SpringLayout.WEST, salasScroll, 40, SpringLayout.EAST, precio);
		salasScroll.setPreferredSize(new Dimension(80, 70));
		this.add(salasScroll);
		
		layout.putConstraint(SpringLayout.NORTH, borrar, (int) ((altoPanel - borrar.getHeight())/2+30)+40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, borrar, 10, SpringLayout.EAST, salasScroll);
		this.add(borrar);
		
		
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 80, SpringLayout.EAST, borrar);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, editar, (int) ((altoPanel - editar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, editar, 10, SpringLayout.EAST, confirmar);
		this.add(editar);
		
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		editar.addActionListener(c);
		borrar.addActionListener(c);
	}

	public ArrayList<String> getSalasOriginales() {
		return salasOriginales;
	}
	
	public ArrayList<String> getSalasSeleccionadas(){
		
		ArrayList<String> list = new ArrayList<>(salas.getSelectedValuesList());
		System.out.println("Selected Rooms: " + list);
		return list;
	
	}

	public Exhibition getExposicion() {
		return exhibition;
	}
	
	public Exhibition getExhibition() {
		return exhibition;
	}

	public JTextField getAutor() {
		return autor;
	}

	public JTextField getFechaInicio() {
		return fechaInicio;
	}

	public JTextField getFechaFinal() {
		return fechaFinal;
	}

	public JTextField getNombre() {
		return nombre;
	}


	public JTextField getPrecio() {
		return precio;
	}

	public JList<String> getSalas() {
		return salas;
	}

	public static void main(String[] args) {
        // Crear una instancia de Notification para usar en VistaStaffPanel
        Exhibition client = new Exhibition("EX1", "Picasso", LocalDateTime.of(2024, 11, 29, 10, 0), LocalDateTime.of(2024, 11, 30, 20, 0));
        client.publishExposition();
        // Crear una instancia de VistaSystem (suponiendo que existe un constructor adecuado)
        VistaSystem parent = new VistaSystem();

        // Crear el panel VistaStaffPanel con la staffficación y el parent
        VistaExposicionEditPanel panel = new VistaExposicionEditPanel(parent, client, false);

        // Crear el JFrame y configurarlo
        JFrame frame = new JFrame("VistaExposicionEditPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar en la pantalla
        frame.setVisible(true);
    }


	
}
