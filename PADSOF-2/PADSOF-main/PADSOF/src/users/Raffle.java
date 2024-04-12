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
	
	
}
