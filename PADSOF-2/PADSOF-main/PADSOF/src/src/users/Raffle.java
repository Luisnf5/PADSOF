package users;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import works.Exhibition;
import works.Ticket;

public class Raffle implements Serializable {
	String title;
	String description;
	LocalDateTime startDate;
	LocalDateTime endDate;	
	int numWinners;
	Map<Client, LocalDateTime> participants = new LinkedHashMap<>();
	Exhibition exhibition;
	
	public Raffle(String title, String description, int num, LocalDateTime startDate, LocalDateTime endDate, Exhibition exhibition) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numWinners = num;
		this.exhibition = exhibition;
	}
	
	public ArrayList<Client> getWinners() {
		ArrayList<Client> result = new ArrayList<Client>();
		ArrayList<Client> clientsLeft = new ArrayList<Client>(this.participants.keySet());
		Random rand = new Random();
		int randIndex;
		Client clientAux;

		for (int i = 0; i < this.participants.size() && result.size() < this.numWinners; i++) {
			randIndex = rand.nextInt(clientsLeft.size());
			clientAux = clientsLeft.get(randIndex);
			result.add(clientAux);
		}

		getTicketsToWinners(result);

		return result;
	}

	public void getTicketsToWinners(ArrayList<Client> winnerTickets){
		for(Client c : winnerTickets){
			c.addTickets(new Ticket(this.participants.get(c), c));
		}
	}

	public boolean addParticipant(Client c, LocalDateTime date){
		if (this.participants.containsKey(c)){
			return false;
		}

		this.participants.put(c, date);
		return true;
	}

	public void eliminateParticipant(Client c){
		this.participants.remove(c);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public int getNumWinners() {
		return numWinners;
	}

	public void setNumWinners(int numWinners) {
		this.numWinners = numWinners;
	}

	public Map<Client, LocalDateTime> getParticipants() {
		return participants;
	}

	public void setParticipants(Map<Client, LocalDateTime> participants) {
		this.participants = participants;
	}

	public Exhibition getExhibition() {
		return exhibition;
	}

	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}
}
