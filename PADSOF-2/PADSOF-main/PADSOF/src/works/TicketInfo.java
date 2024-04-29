/**
 * The TicketInfo class represents information about a ticket.
 * It implements the ITicketInfo interface.
 * 
 * @author Javier Gael Luis

 */
package works;

import es.uam.eps.padsof.tickets.*;

public class TicketInfo implements ITicketInfo {
    private int idTicket;
    private String exhibitionCenterName;
    private String exhibitionName;
    private int numberOfTickets;
    private String ticketDateTime;
    private double price;
    private double discount;
    private double payedPrice;
    private String picture;

    /**
     * Constructs a TicketInfo object with specified parameters.
     * 
     * @param idTicket the ID of the ticket
     * @param exhibitionCenterName the name of the exhibition center
     * @param exhibitionName the name of the exhibition
     * @param numberOfTickets the number of tickets
     * @param ticketDateTime the date and time of the ticket
     * @param price the price of the ticket
     * @param discount the discount applied to the ticket
     * @param payedPrice the price paid for the ticket
     * @param picture the picture associated with the ticket
     */
    public TicketInfo(int idTicket, String exhibitionCenterName, String exhibitionName, int numberOfTickets, String ticketDateTime, double price, double discount, double payedPrice, String picture) {
        this.idTicket = idTicket;
        this.exhibitionCenterName = exhibitionCenterName;
        this.exhibitionName = exhibitionName;
        this.numberOfTickets = numberOfTickets;
        this.ticketDateTime = ticketDateTime;
        this.price = price;
        this.discount = discount;
        this.payedPrice = payedPrice;
        this.picture = picture;
    }

    @Override
    public int getIdTicket() {
        return idTicket;
    }

    @Override
    public String getExhibitionCenterName() {
        return exhibitionCenterName;
    }

    @Override
    public String getExhibitionName() {
        return exhibitionName;
    }

    @Override
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String getTicketDateTime() {
        return ticketDateTime;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public double getPayedPrice() {
        return payedPrice;
    }

    @Override
    public String getPicture() {
        return picture;
    }
}
