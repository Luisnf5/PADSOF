/**
 * The Exhibition class represents an exhibition with its properties and functionalities.
 * It implements Serializable.
 * 
 * <p>An exhibition includes details such as title, author, capacity, start and end dates, price, status, raffle, discounts, and tickets.</p>
 * 
 * <p>This class provides methods for managing the exhibition, such as adding discounts, buying tickets, publishing, canceling, extending, and shortening the exhibition, managing participants for raffles, and adding sub-room exhibitions.</p>
 * 
 * <p>The tickets are organized by date and time in a LinkedHashMap.</p>
 * 
 * <p>Note: This class contains commented-out methods for searching tickets by user and for managing all tickets of a user, as well as for managing child rooms, which are not currently in use.</p>
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import es.uam.eps.padsof.tickets.NonExistentFileException;
import es.uam.eps.padsof.tickets.TicketSystem;
import es.uam.eps.padsof.tickets.UnsupportedImageTypeException;
import system.ArtGallery;
import systemTester.systemTester;
import users.Client;
import users.Raffle;
import users.*;

public class Exhibition implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title; 
    private String author;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    private ExhibitionStatus status;
    private Raffle raffle;
    private Discount discount = new Discount(0);
    private Map<LocalDateTime, Set<Ticket>> tickets = new LinkedHashMap<>();
    private Set<SubroomExhibition> roomexhibitions = new LinkedHashSet<>();
    String pathTicket = Exhibition.class.getResource("CapillaSixtina.png").getPath();

    /**
     * Adds a discount to the exhibition.
     * 
     * @param discount the discount percentage to be added
     */
    public void addDiscount(int discount){
        this.discount.setDiscount(discount);
    }
    
    /**
     * Calculates the price of the exhibition.
     * 
     * @return the calculated price after applying discounts
     */
    public double getPrice() {
        return this.discount.calculatePrice(this.price);
    }

    /**
     * Constructs an Exhibition object with specified parameters.
     * 
     * @param title the title of the exhibition
     * @param author the author of the exhibition
     * @param startDate the start date and time of the exhibition
     * @param endDate the end date and time of the exhibition
     */
    public Exhibition(String title, String author, LocalDateTime startDate, LocalDateTime endDate) {
        super();
        this.title = title;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ExhibitionStatus.DRAFT;
    }

    /**
     * Retrieves the title of the exhibition.
     * 
     * @return the title of the exhibition
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the end date and time of the exhibition.
     * 
     * @param endDate the new end date and time
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Retrieves the end date and time of the exhibition.
     * 
     * @return the end date and time of the exhibition
     */
    public LocalDateTime getEndDate() { 
        return endDate;
    }
    
    public int getCapacity() {
    	return capacity;
    }
    /**
     * Checks if the given hour is valid for ticket purchase.
     * 
     * @param hour the hour to be checked
     * @return true if the hour is valid, false otherwise
     */
    public boolean isHourValid(LocalDateTime hour) {
    	if(this.tickets.get(hour) == null) {
    		return false;
    	}else if (this.tickets.get(hour).size() >= this.capacity || !this.tickets.containsKey(hour)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Buys a ticket for the exhibition.
     * 
     * @param client the client buying the ticket
     * @param hour the hour for which the ticket is bought
     * @return the bought ticket, or null if purchase is not possible
     */
    public Ticket buyTicket(Client client, LocalDateTime hour) {
        if (!this.isHourValid(hour) || this.status == ExhibitionStatus.DRAFT || this.status == ExhibitionStatus.ENDING) {
            return null;
        }

        Ticket newTicket = new Ticket(hour, this.getPrice(), client, this);
        client.addTickets(newTicket);
        
        this.tickets.get(hour).add(newTicket);
        
        return newTicket;
    }

    /**
     * Publishes the exhibition.
     * 
     * <p>If the exhibition status is not DRAFT, the method does nothing.</p>
     * <p>The method initializes tickets for each day and hour of the exhibition.</p>
     * <p>It sets the status of all sub-room exhibitions to EXHIBITED.</p>
     */
    public boolean publishExposition() {
        if (status != ExhibitionStatus.DRAFT) {
            return false;
        }
        
        int days;
        LocalDateTime actual = this.startDate.minusDays(1);
        
        days = (Period.between(this.startDate.toLocalDate(), this.endDate.toLocalDate())).getDays();
        
        for (int i = 0; i<days+1; i++) {
            actual = actual.plusDays(1);
            actual = actual.withHour(10);	
            for (int j = 0; j<10; j++) {
                this.tickets.put(actual, new LinkedHashSet<Ticket>());
                System.out.println("DEBUG: " + actual);
                actual = actual.plusHours(1);
            }
        }

        for (SubroomExhibition sbe : this.roomexhibitions){
            if(sbe != null) {
            	this.capacity += sbe.getCapacity();
                sbe.setWorkStatus(Status.EXHIBITED);
            }
        }
        
        this.status = ExhibitionStatus.PUBLISHED;
        
        return true;
    }
    
    /**
     * Cancels the exhibition.
     * 
     * <p>If the exhibition status is not PUBLISHED, the method does nothing.</p>
     * <p>The method sets the status of all sub-room exhibitions to INVENTORY and extends the end date of the exhibition by 7 days.</p>
     */
    public void cancelExibition() {
        if (this.status != ExhibitionStatus.PUBLISHED) {
            return;
        }else if (this.endDate.isBefore(LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(20, 0)))) {
        	this.status = ExhibitionStatus.ENDING;
        	return;
        }
        
        this.status = ExhibitionStatus.ENDING;
        LocalDateTime auxNow = LocalDateTime.now();
        LocalDateTime aux = LocalDateTime.of(auxNow.getYear(), auxNow.getMonth(), auxNow.getDayOfMonth(), this.endDate.getHour(), this.endDate.getMinute());
        this.endDate = aux.plusDays(7);

        for (SubroomExhibition sbe : this.roomexhibitions){
            sbe.setWorkStatus(Status.INVENTORY);
        }
        
    }
    
    /**
     * Extends the exhibition to a new end date.
     * 
     * <p>If the new end date is before the current end date, the method does nothing.</p>
     * <p>The method creates tickets for each day and hour between the current end date and the new end date.</p>
     * 
     * @param newDate the new end date of the exhibition
     */
    public void extendExibition(LocalDateTime newDate) {
        if (newDate.isBefore(this.endDate)){
            return;
        }

        LocalDateTime actual = this.endDate.minusDays(1);
        int days = (Period.between(this.endDate.toLocalDate(), newDate.toLocalDate())).getDays();
        
        for (int i = 0; i<days+1; i++) {
            actual = actual.plusDays(1);
            actual = actual.withHour(10);
            for (int j = 0; j<10; j++) {
                this.tickets.put(actual, new LinkedHashSet<Ticket>());
                System.out.println("count :" + this.tickets.size());
                actual = actual.plusHours(1);
            }
        }
        
        this.endDate = newDate;
    }

    /**
     * Shortens the exhibition to a new end date.
     * 
     * <p>If there are tickets sold for dates after the new end date, the method does nothing.</p>
     * 
     * @param newDate the new end date of the exhibition
     * @return true if the exhibition is successfully shortened, false otherwise
     */
    public boolean shortenExhibition(LocalDateTime newDate){
        Boolean ticketsExist = false;

        for (LocalDateTime ld : this.tickets.keySet()){
            if (ld.isAfter(newDate)){
                if (this.tickets.get(ld).size() != 0){
                    ticketsExist = true;
                }
            }
        }

        if (ticketsExist){
            return false;
        }

        this.endDate = newDate;
        return true;
    }

    /**
     * Adds a participant for the raffle of the exhibition.
     * 
     * <p>If the hour is not valid for ticket purchase, the method returns false.</p>
     * 
     * @param c the client participating in the raffle
     * @param date the date and time of participation
     * @return true if the participant is successfully added, false otherwise
     */
    public boolean addParticipant(Client c, LocalDateTime date){
        if (!this.isHourValid(date) || this.raffle == null || this.raffle.isParticipating(c)){
            return false;
        }

        this.raffle.addParticipant(c, date);
        return true;
    }
    
    /**
     * Removes a client from the raffle of the exhibition.
     * 
     * @param c the client to be removed from the raffle
     */
    public void exitRaffle(Client c){
        this.raffle.eliminateParticipant(c);
    }

    /**
     * Creates a raffle for the exhibition with specified parameters.
     * 
     * @param title the title of the raffle
     * @param description the description of the raffle
     * @param num the number of winners in the raffle
     * @param startDate the start date and time of the raffle
     * @param endDate the end date and time of the raffle
     */
    public void createRaffle(String title, String description, int num, LocalDateTime startDate, LocalDateTime endDate){
        this.raffle = new Raffle(title, description, num, startDate, endDate, this);
    }
    
    public void createRaffle(Raffle s){
        this.raffle = s;
    }

    /**
     * Deletes the raffle of the exhibition.
     */
    public void deleteRaffle(){
        this.raffle = null;
    }
    
    /**
     * Retrieves the number of tickets.
     * 
     * <p>This method is for testing purposes.</p>
     * 
     * @return the number of tickets
     */
    public int getNumTest() {
        return this.tickets.size(); //test 
    }
    
    /**
     * Adds a sub-room exhibition to the exhibition.
     * 
     * @param Re the sub-room exhibition to be added
     * @return true if the sub-room exhibition is successfully added, false otherwise
     */
    public boolean addRoomExhibition(SubroomExhibition Re) {
    	if (this.roomexhibitions.add(Re)) {
    		return true;
    	}
        return this.roomexhibitions.add(Re); 
    }

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public ExhibitionStatus getStatus() {
		return status;
	}

	public void setStatus(ExhibitionStatus status) {
		this.status = status;
	}

	public void setRaffle(Raffle raffle) {
		this.raffle = raffle;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Map<LocalDateTime, Set<Ticket>> getTickets() {
		return tickets;
	}

	public void setTickets(Map<LocalDateTime, Set<Ticket>> tickets) {
		this.tickets = tickets;
	}

	public Set<SubroomExhibition> getRoomexhibitions() {
		return roomexhibitions;
	}

	public void setRoomexhibitions(Set<SubroomExhibition> roomexhibitions) {
		this.roomexhibitions = roomexhibitions;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Raffle getRaffle() {
		return raffle;
	}

	public void delete() {
		ArtGallery.getSystem().removeExhibition(this);
	}
	
	public Set<Ticket> selectTickets(Client client, LocalDateTime date, int tickets) throws StaffPrivilegesException, InsufficientPrivilegesException{
	    Set<Ticket> entrselec = new LinkedHashSet<>();

	    if (client == null) {
	        if (ArtGallery.getSystem().getLoggedUser() instanceof Staff) {
	            Staff s = (Staff) ArtGallery.getSystem().getLoggedUser();
	            if (s.hasPrivilege(Privileges.VENTA)) {
	                for (int i = 0; i < tickets; i++) {
	                    Ticket newTicket = new Ticket(date, this.price, client, this);
	                    this.tickets.get(date).add(newTicket);
	                }
	                return null;
	            } else {
	                throw new StaffPrivilegesException("No hay privilegios suficientes para la venta de entradas");
	            }
	        } else {
	            throw new InsufficientPrivilegesException();
	        }
	    } else {
	        for (int i = 0; i < tickets; i++) {
	            Ticket newTicket = new Ticket(date, this.price, client, this);
	            entrselec.add(newTicket);
	        }
	        return entrselec;
	    }
	}
	
	public double calculatePrice(Client client, int tickets) {
	    double price = 0;

	    for (int i = 0; i < tickets; i++) {
	        price += this.price;
	    }

	    if (client.isUsual() == true) {
	        price = this.discount.calculatePrice(price);
	    }

	    return price;
	}
	
	public void payTicket(Client client, LocalDateTime date, int tickets, String cardn, double price)
            	throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, NonExistentFileException, UnsupportedImageTypeException {
		
		double precio;

		Set<Ticket> entradasslec = new LinkedHashSet<>();

		entradasslec = this.selectTickets(client, date, tickets);

		precio = calculatePrice(client, tickets);

		if (TeleChargeAndPaySystem.isValidCardNumber(cardn) == true) {
			TeleChargeAndPaySystem.charge(cardn, "Entrada", precio, true);
			this.tickets.get(date).addAll(entradasslec);
			client.addTickets(entradasslec);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MM - YYYY HH:mm");
			String fechahora = date.format(formatter);

			SecureRandom random = new SecureRandom();
			int rand = random.nextInt();

			TicketInfo ticket = new TicketInfo(Math.abs(rand), "ArtGallery", this.getTitle(), tickets, fechahora, this.price * tickets, this.discount.getDiscount(), precio, null);

			TicketSystem.createTicket(ticket, pathTicket); // Output folder

		}else {
			System.out.println("Tarjeta");
		}
	}
}
