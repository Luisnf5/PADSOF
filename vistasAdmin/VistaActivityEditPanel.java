package vistasAdmin;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import activities.Activity;
import activities.ActivityType;
import system.ArtGallery;
import vistasSystem.VistaSystem;
import works.SubRoom;

public class VistaActivityEditPanel extends JPanel{
	private Activity activity;
	
	private VistaSystem parent;
	
	private JButton confirmar;
	private JButton editar;
	
	private JTextField nombre;
	private JTextField desc;
	private JTextField fecha;
	private JTextField nif;
	private JComboBox<String> tipo;
	
	
	
	private JLabel nombreLabel;
	private JLabel descLabel;
	private JLabel fechaLabel;
	private JLabel info;
	private JLabel nifLabel;
	private JLabel tipoLabel;
	
	
	private JList<String> salas;
	private JScrollPane salasScroll;
	
	private ArrayList<String> salasOriginales = new ArrayList<String>();
	
	
	public VistaActivityEditPanel(VistaSystem parent, Activity act, boolean newActivity) {
		this.parent = parent;
		this.activity = act;
		
		
		
		int anchoPanel = this.getWidth();
		int altoPanel = this.getHeight();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		Dimension d2 = Toolkit.getDefaultToolkit().getScreenSize();
        d2.width -= 250;
        d2.height = 150;
		
		this.setPreferredSize(d2);
		
		this.nombre = new JTextField(activity.getName());
		this.desc = new JTextField(activity.getDescription());
		String fechaString = String.format("%02d/%02d/%04d/%02d", activity.getDate().getDayOfMonth(), activity.getDate().getMonthValue(), activity.getDate().getYear(), activity.getDate().getHour());
		this.fecha = new JTextField(fechaString);
		this.nif = new JTextField("");
		this.tipo = new JComboBox<String>(new String[] {"CONFERENCIA", "MESA", "PROYECCION", "ACTUACION", "VISITA", "FORMATIVA", "OTROS"});
		
		if (!newActivity) {
			if (activity.getType() == ActivityType.CONFERENCIA) {
				tipo.setSelectedIndex(0);
			}else if (activity.getType() == ActivityType.MESA) {
				tipo.setSelectedIndex(1);
			}else if (activity.getType() == ActivityType.PROYECCION) {
				tipo.setSelectedIndex(2);
			}else if (activity.getType() == ActivityType.ACTUACION) {
				tipo.setSelectedIndex(3);
			}else if (activity.getType() == ActivityType.VISITA) {
				tipo.setSelectedIndex(4);
			}else if (activity.getType() == ActivityType.FORMATIVA) {
				tipo.setSelectedIndex(5);
			}else if (activity.getType() == ActivityType.OTROS) {
				tipo.setSelectedIndex(6);
			}
		}
		
		this.nombreLabel = new JLabel("Título");
		this.descLabel = new JLabel("Descripción");
		this.fechaLabel = new JLabel("Fecha");
		this.info = new JLabel("Sala");
		this.nifLabel = new JLabel("NIF");
		this.tipoLabel = new JLabel("Tipo");
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		Set<SubRoom> rooms = ArtGallery.getSystem().getSubRooms();
		int i = 0;
		ArrayList<Integer> indexes = new ArrayList<>();
		for (SubRoom sr : rooms) {
			if (!sr.isActiviting()) {
				listModel.addElement(sr.getName());
				i++;
			}else if (sr.isActiviting() && sr.getAct() == activity) {
				listModel.addElement(sr.getName());
				indexes.add(i);
				salasOriginales.add(sr.getName());
				i++;
			}
			
		}
		
		salas = new JList<>(listModel);
		salas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		salasScroll = new JScrollPane(salas);
		salas.setSelectedIndices(indexes.stream().mapToInt(Integer::intValue).toArray());

		
		this.confirmar = new JButton("Inscribir NIF");
		
		if (newActivity) {
			this.editar = new JButton("Crear Actividad");
		}else {
			this.editar = new JButton("Editar");
		}
		
		
		
		layout.putConstraint(SpringLayout.NORTH, nombreLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombreLabel, 20, SpringLayout.WEST, this);
		nombreLabel.setPreferredSize(new Dimension(60, 20));
		this.add(nombreLabel);
		
		layout.putConstraint(SpringLayout.NORTH, descLabel, 5, SpringLayout.SOUTH, nombreLabel);
		layout.putConstraint(SpringLayout.WEST, descLabel, 20, SpringLayout.WEST, this);
		descLabel.setPreferredSize(new Dimension(60, 20));
		this.add(descLabel);

		layout.putConstraint(SpringLayout.NORTH, nombre, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nombre, 5, SpringLayout.EAST, nombreLabel);
		nombre.setPreferredSize(new Dimension(80, 20));
		this.add(nombre);
		
		layout.putConstraint(SpringLayout.NORTH, desc, 5, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.WEST, desc, 5, SpringLayout.EAST, descLabel);
		desc.setPreferredSize(new Dimension(80, 20));
		this.add(desc);
		
		layout.putConstraint(SpringLayout.NORTH, fechaLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fechaLabel, 10, SpringLayout.EAST, nombre);
		fechaLabel.setPreferredSize(new Dimension(40, 20));
		this.add(fechaLabel);
		
		layout.putConstraint(SpringLayout.NORTH, fecha, (int) ((altoPanel - nombre.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, fecha, 5, SpringLayout.EAST, fechaLabel);
		fecha.setPreferredSize(new Dimension(130, 20));
		this.add(fecha);
		
		layout.putConstraint(SpringLayout.NORTH, nifLabel, 5, SpringLayout.SOUTH, fecha);
		layout.putConstraint(SpringLayout.WEST, nifLabel, 10, SpringLayout.EAST, nombre);
		nifLabel.setPreferredSize(new Dimension(40, 20));
		this.add(nifLabel);
		
		layout.putConstraint(SpringLayout.NORTH, nif, 5, SpringLayout.SOUTH, fecha);
		layout.putConstraint(SpringLayout.WEST, nif, 5, SpringLayout.EAST, nifLabel);
		nif.setPreferredSize(new Dimension(130, 20));
		this.add(nif);
		
		layout.putConstraint(SpringLayout.NORTH, info, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-45, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, info, 90, SpringLayout.EAST, fecha);
		info.setPreferredSize(new Dimension(40, 20));
		this.add(info);
		
		layout.putConstraint(SpringLayout.NORTH, salasScroll, 5, SpringLayout.SOUTH, info);
		layout.putConstraint(SpringLayout.WEST, salasScroll, 60, SpringLayout.EAST, fecha);
		salasScroll.setPreferredSize(new Dimension(80, 70));
		this.add(salasScroll);
		
		layout.putConstraint(SpringLayout.NORTH, tipoLabel, (int) ((altoPanel - nombreLabel.getHeight())/2+40)-20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, tipoLabel, 95, SpringLayout.EAST, info);
		tipoLabel.setPreferredSize(new Dimension(60, 20));
		this.add(tipoLabel);
		
		layout.putConstraint(SpringLayout.NORTH, tipo, 0, SpringLayout.SOUTH, tipoLabel);
		layout.putConstraint(SpringLayout.WEST, tipo, 30, SpringLayout.EAST, salasScroll);
		tipo.setPreferredSize(new Dimension(130, 20));
		this.add(tipo);
		
		
		layout.putConstraint(SpringLayout.NORTH, confirmar, (int) ((altoPanel - confirmar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, confirmar, 40, SpringLayout.EAST, tipo);
		this.add(confirmar);
		
		layout.putConstraint(SpringLayout.NORTH, editar, (int) ((altoPanel - editar.getHeight())/2+30), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, editar, 10, SpringLayout.EAST, confirmar);
		this.add(editar);
		
		if (newActivity) {
			this.confirmar.setVisible(false);
			this.nifLabel.setVisible(false);
			this.nif.setVisible(false);
		}
		
	}
	
	public void setControlador(ActionListener c) {
		confirmar.addActionListener(c);
		editar.addActionListener(c);
	}

	public ArrayList<String> getSalasOriginales() {
		return salasOriginales;
	}
	
	public ArrayList<String> getSalasSeleccionadas(){
		
		ArrayList<String> list = new ArrayList<>(salas.getSelectedValuesList());
		System.out.println("Selected Rooms: " + list);
		return list;
	
	}

	public Activity getActivity() {
		return activity;
	}

	public JTextField getDescription() {
		return desc;
	}

	public JTextField getFecha() {
		return fecha;
	}

	public JTextField getNombre() {
		return nombre;
	}


	public JList<String> getSalas() {
		return salas;
	}

	public JComboBox<String> getTipo() {
		return tipo;
	}

	public JTextField getNif() {
		return nif;
	}

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create the JFrame
                    JFrame frame = new JFrame("Test VistaActivityEditPanel");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(1100, 150);
                    
                    // Create a mock VistaSystem and an Activity instance
                    VistaSystem vistaSystem = new VistaSystem(); // Assuming this has a default constructor
                    Activity activity = new Activity("Actividad 1",ActivityType.ACTUACION, "Descripción 1",10, LocalDateTime.now(), new SubRoom(true, 10, 10, 10, 10, 10, 10));
                    
                    // Create the VistaActivityEditPanel instance
                    VistaActivityEditPanel editPanel = new VistaActivityEditPanel(vistaSystem, activity, false);
                    
                    // Add the panel to the frame
                    frame.add(editPanel);
                    
                    // Set the frame visible
                    frame.setVisible(true);
                    
                    // Add a simple action listener to demonstrate button functionality
                    editPanel.setControlador(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Button clicked");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


	
}
