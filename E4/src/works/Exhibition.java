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
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import users.Client;
import users.Raffle;

import es.uam.eps.padsof.telecard.*;
import es.uam.eps.padsof.tickets.*;

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

    /**
     * Checks if the given hour is valid for ticket purchase.
     * 
     * @param hour the hour to be checked
     * @return true if the hour is valid, false otherwise
     */
    public boolean isHourValid(LocalDateTime hour) {
    	if(this.tickets.get(hour) == null)
    		return false;
        if (this.tickets.get(hour).size() >= this.capacity || !this.tickets.containsKey(hour)) {
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
    public void publishExposition() {
        if (status != ExhibitionStatus.DRAFT) {
            return;
        }
        
        int days;
        LocalDateTime actual = this.startDate.minusDays(1).minusHours(1);
        
        days = (Period.between(this.startDate.toLocalDate(), this.endDate.toLocalDate())).getDays();
        
        for (int i = 0; i<days+1; i++) {
            actual = actual.plusDays(1);
            for (int j = 0; j<10; j++) {
                this.tickets.put(actual, new LinkedHashSet<Ticket>());
                actual = actual.plusHours(1);
            }
        }

        for (SubroomExhibition sbe : this.roomexhibitions){
            if(sbe != null) 
                sbe.setWorkStatus(Status.EXHIBITED); 
        }
        
        this.status = ExhibitionStatus.PUBLISHED;
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

        LocalDateTime actual = this.endDate.minusDays(1).minusHours(11);
        int days = (Period.between(this.endDate.toLocalDate(), newDate.toLocalDate())).getDays();
        
        for (int i = 0; i<days+1; i++) {
            actual = actual.plusDays(1);
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
        if (!this.isHourValid(date)){
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

	public int getCapacity() {
		return capacity;
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
}
