package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

import users.Admin;
import users.Client;
import users.Gender;
import users.Notification;
import users.Staff;
import users.User;
import works.CompositeRoom;
import works.Exhibition;
import works.Inventory;
import works.Painting;
import works.Photo;
import works.Room;
import works.RoomComposite;
import works.Sculpture;
import works.SubRoom;
import works.Video;

public class ArtGallery implements Serializable{
	private static final long serialVersionUID = 1L;
	private static ArtGallery system = null;
	private User loggedUser;
	private LocalTime openTime = LocalTime.of(10, 0);
	private LocalTime closeTime = LocalTime.of(20, 0);

	private Set<Notification> notifications = new LinkedHashSet<>();
	private Set<User> users = new LinkedHashSet<>();
	private Inventory inventory = new Inventory();
	private Set<Exhibition> exhibitions = new LinkedHashSet<>();
	private Set<Room> rooms = new LinkedHashSet<>();

	String sistemTxt = "system.dat";

	
	
	private ArtGallery(){
		super();
	}
	
	
	public Set<User> getUsers() {
		return users;
	}
	
	public Set<Staff> getStaffs(){
		Set<Staff> staffs = new LinkedHashSet<>();
		
		for (User u : this.users) {
			if (u instanceof Staff) {
				staffs.add((Staff)u);
			}
		}
		
		return staffs;
	}
	
	public Set<Client> getClients(){
		Set<Client> clients = new LinkedHashSet<>();
		
		for (User u : this.users) {
			if (u instanceof Client) {
				clients.add((Client)u);
			}
		}
		
		return clients;
	}
	
	public Set<Client> getBlockedClients(){
		Set<Client> clients = new LinkedHashSet<>();
		
		for (User u : this.users) {
			if (u instanceof Client && u.isBlocked()) {
				clients.add((Client)u);
			}
		}
		
		return clients;
	}


	public Set<Exhibition> getExhibitions() {
		Set<Exhibition> exs = new LinkedHashSet<>();
		Set<Exhibition> deleteExs = new LinkedHashSet<>();
		
		for (Exhibition e : this.exhibitions) {
			if (e.getEndDate().isBefore(LocalDateTime.now())) {
				deleteExs.add(e);
			}else {
				exs.add(e);
			}
		}
		
		this.exhibitions.removeAll(deleteExs);
		return exs;
	}
	
	public void addSubRoom(SubRoom e) {
		this.rooms.add(e);
	}
	public void addSubRoom(CompositeRoom c) {
		this.rooms.add(c);
	}
	
	public Set<Room> getRooms() {
		return rooms;
	}
	
	

	public Set<Notification> getNotifications() {
		return notifications;
	}


	public Inventory getInventory() {
		return inventory;
	}


	public LocalTime getOpenTime() {
		return openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public static ArtGallery getSystem() {
		if (system == null) {
			system = new ArtGallery();
			return system;
		}
		return system;
	}
	
	public User getLoggedUser() {
		return loggedUser;
	}
	

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}


	public boolean createNotification(String title, String description, Client c){
		Notification n = new Notification(title, description);
		this.notifications.add(n);
		return c.addNotification(n);
	}

	public void deleteNotification(Notification noti){
		this.notifications.remove(noti);
	}

	public boolean newClient(String name, String surname, String nif, Gender gender, LocalDate date, String password){
		Client c = new Client(name, surname, nif, gender, date, password);
		for(User u: this.users) {
			if(u instanceof Client && u.getNif().equals(nif))
				return false;
			
		}
		this.users.add(c);
		return true;

	}
	
	public void saveSistem() {
		try {
			ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(sistemTxt));
		    oss.writeObject(this);
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
		
	}
	
	public boolean readSistem() throws FileNotFoundException{
		try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sistemTxt));
            ArtGallery sistemRead = (ArtGallery) ois.readObject();
            ois.close();
            copyLastSystem(sistemRead);
            return true; 
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
            return false;
        } catch (IOException ex) {
        	throw new FileNotFoundException();
        }
	}
	
	public void copyLastSystem(ArtGallery last) {
		this.notifications = new LinkedHashSet<>(last.notifications);
		this.users = new LinkedHashSet<>(last.users);
		this.inventory = new Inventory(last.inventory);
		this.exhibitions = new LinkedHashSet<>(last.exhibitions);
		this.rooms = new LinkedHashSet<>(last.rooms);
		
	}
	public void newStaff(String name, String surname, String nif, Gender gender, LocalDate date){
		Staff s = new Staff(name, surname, nif, gender, date);
		for(User u: this.users) {
			if(u instanceof Staff && u.getNif().equals(nif))
				return;
			
		}
		this.users.add(s);
	}
	
	public void newStaff(Staff s) {
		for(User u: this.users) {
			if(u instanceof Staff && u.getNif().equals(s.getNif()))
				return;
			
		}
		this.users.add(s);
	}

	public void newAdmin(String name, String surname, String nif, Gender gender, LocalDate date, String password){
		Admin a = new Admin(name, surname, nif, gender, date, password);
		for(User u: this.users) {
			if(u instanceof Admin && u.getNif().equals(nif))
				return;
			
		}
		this.users.add(a);
		
	}
	
	public boolean isPwdValid(String pwd) {
		char c;
		Boolean hasUppCase = false;
		Boolean hasLowCase = false;
		Boolean hasNumb = false;
		
		for (int i=0 ; i<pwd.length(); i++) {
			c = pwd.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				hasUppCase = true;
			}
			if (c >= 'a' && c <= 'z') {
				hasLowCase = true;
			}
			if (c >= '0' && c <= '9') {
				hasNumb = true;
			}
		}
		
		if (hasUppCase && hasLowCase && hasNumb) {
			return true;
		}
		return false;
	}
	
	public void createPainting(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
	double height, double humidity){
		Painting p = new Painting(title, author, elctricity, temperature, width, lenght, height, humidity);
		this.inventory.addWorks(p);
	}

	public void createSculpture(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
	double height, double humidity, String material, String tool){
		Sculpture s = new Sculpture(title, author, elctricity, temperature, width, lenght, height, humidity, material, tool);
		this.inventory.addWorks(s);
	}

	public void createVideo(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
	double height, double humidity, Boolean color, String format, int resolution){
		Video v = new Video(title, author, elctricity, temperature, width, lenght, height, humidity, color, format, resolution);
		this.inventory.addWorks(v);
	}

	public void createPhoto(String title, String author, Boolean elctricity, double temperature, double width, double lenght,
	double height, double humidity, Boolean color, String format, int resolution){
		Photo ph = new Photo(title, author, elctricity, temperature, width, lenght, height, humidity, color, format, resolution);
		this.inventory.addWorks(ph);
	}

	public boolean createExhibition(String title, String author, LocalDateTime startDate, LocalDateTime endDate){
		Exhibition e = new Exhibition(title, author, startDate, endDate);
		for(Exhibition u: this.exhibitions) {
			if(u.getTitle().equals(title))
				return false;
			
		}
		return this.exhibitions.add(e);
	}
	
	public boolean createExhibition(Exhibition e){
		for(Exhibition u: this.exhibitions) {
			if(u.getTitle().equals(e.getTitle()))
				return false;
			
		}
		return this.exhibitions.add(e);
	}

	public Exhibition searchExhibition(String title) {
		for(Exhibition e: this.exhibitions) {
			if(e.getTitle().equals(title))
				return e;
		}
		return null;
	}
	
	/*public void newRoom(int roomID, boolean electricity, double temperature, double width, double length, double height, double humidity){
		Room s = new Room(roomID, electricity, temperature, width, length, height, humidity);
		this.rooms.add(s);
		
	}*/
	
	public User getUserFromNif(String nif) {
		for (User u : this.users) {
			if (u.getNif().equals(nif)){
				return u;
			}
		}
		return null;
	}
	
	public void deleteUser(User u) {
		this.users.remove(u);
	}
	
	public void removeExhibition(Exhibition e) {
		this.exhibitions.remove(e);
	}
	
	public Exhibition getExhibitionFromName(String name) {
		for (Exhibition e : this.getExhibitions()) {
			if (e.getTitle().equals(name)) {
				return e;
			}
		}
		
		return null;
	}
	
	public Set<String> getClientsStrings(){
		Set<String> cls = new LinkedHashSet<>();
		Set<Client> clients = getClients();
		
		for (Client cl : clients) {
			cls.add(cl.getNif());
		}
		
		return cls;
	}
	
	public SubRoom createSalaFisica(boolean electricidad, double temp, double width, double length, double height, double humidity, int capacity) {
		Room r = new RoomComposite(electricidad, temp, width, length, height, humidity, capacity);
		SubRoom sr = new SubRoom(electricidad, temp, width, length, height, humidity, capacity);
		r.add(sr);
		this.rooms.add(r);
		
		return sr;
	}
	
	public Set<SubRoom> getSubRooms(){
		Set<SubRoom> sbr = new LinkedHashSet<>();
		
		for (Room r : this.rooms) {
			sbr.addAll(r.getSubRooms());
		}
		
		return sbr;
	}
	
}
