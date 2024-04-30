package users;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import works.Exhibition;
import works.Ticket;

public class Client extends User implements Serializable{
	private int numTickets;
	private String bankAccount;
	private Boolean notificationEnable;
	private Set<Ticket> tickets = new LinkedHashSet<Ticket>();
	private Set<Notification> notifications = new LinkedHashSet<Notification>();
	private Set<Raffle> raffles = new LinkedHashSet<>();

	public Client(String name, String surname, String nif, Gender gender, LocalDate birthDate, String password){
		super(name, surname, nif, gender, birthDate, password);
		this.numTickets = 0;
		this.notificationEnable = true;
	}
	
	
	
	public int getNumTickets() {
		return numTickets;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void enableNotifications() {
		this.notificationEnable = true;
	}
	
	public void disableNotifications() {
		this.notificationEnable = false;
	}

	public void addTickets(Ticket...tickets){
		for(Ticket t : tickets){
			this.tickets.add(t);
			this.numTickets++;
		}
	}

	public void buyTickets(Exhibition exp, LocalDateTime date){
		this.tickets.add(exp.buyTicket(this, date));
		numTickets++;
	}

	public boolean participateRaffle(Exhibition exp, LocalDateTime date){
		for(Raffle r : this.raffles) {
			if(r.getExhibition().equals(exp))
				return false;
		}
		
		if (exp.addParticipant(this, date) == true) {
			this.raffles.add(exp.getRaffle());
			return true;
		}else {
			return false;
		}
	}

	public void exitRaffle(Exhibition exp){
		exp.exitRaffle(this);
	}

	public boolean addNotification(Notification notification){
		if (this.notificationEnable == false){
			return false;
		}

		this.notifications.add(notification);
		return true;
	}
	
	public Boolean getNotificationEnable() {
		return notificationEnable;
	}
	
	public Set<Notification> getNotifications() {
		return notifications;
	}
	
	@Override
	public String toString() {
		return "NOMBRE: " + this.getName() + " APELLIDO: " + this.getSurname() + " NIF: " + this.getNif() + " PWD: " + this.getPassword() +  " DATE: " + this.getBirthDate() + " GENDER: " + this.getGender();
	}



	public Set<Raffle> getRaffles() {
		return raffles;
	}
	
	
	
	
}
