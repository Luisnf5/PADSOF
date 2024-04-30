/**
 * The Ticket class represents a ticket for an exhibition.
 * It implements Serializable.
 * 
 * @author Javier Gael Luis
 */
package works;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import users.Client;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDateTime hour;
    private double price; 
    private Client client;
    private Exhibition exhibition;
    
    /**
     * Constructs a Ticket object with specified parameters.
     * 
     * @param hour the hour of the ticket
     * @param price the price of the ticket
     * @param client the client who owns the ticket
     * @param exhibition the exhibition associated with the ticket
     */
    public Ticket(LocalDateTime hour, double price, Client client, Exhibition exhibition) {
        super();
        this.hour = hour;
        this.price = price;
        this.client = client;
        this.exhibition = exhibition;
    }

    /**
     * Constructs a Ticket object with specified parameters.
     * 
     * @param hour the hour of the ticket
     * @param client the client who owns the ticket
     */
    public Ticket(LocalDateTime hour, Client client) {
        super();
        this.hour = hour;
        this.client = client;
        this.price = 0;
    }

    /**
     * Gets the client who owns the ticket.
     * 
     * @return the client who owns the ticket
     */
    public Client getClient() {
        return client;
    }

    /**
     * Gets the hour of the ticket.
     * 
     * @return the hour of the ticket
     */
    public LocalDateTime getHour() {
        return hour;
    }

    /**
     * Gets the price of the ticket.
     * 
     * @return the price of the ticket
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the exhibition associated with the ticket.
     * 
     * @return the exhibition associated with the ticket
     */
    public Exhibition getExhibition() {
        return exhibition;
    }  
}
