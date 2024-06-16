package activities;

import java.time.*;
import works.*;
import users.*;
import java.util.*;

import system.ArtGallery;

public class Activity {
	private String name;
	private ActivityType type;
	private String description;
	private int maxParticipants;
	private LocalDateTime date;
	private SubRoom room;
	private Set<String> participants = new LinkedHashSet<>();
	
	public Activity(String name, ActivityType type, String description, int maxParticipants, LocalDateTime date, SubRoom room) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.date = date;
		this.room = room;
		if (room != null) {
			room.setAct(this);
		}
		if (room == null) {
			this.maxParticipants = maxParticipants;
		}else if(maxParticipants > room.getCapacity()) {
			this.maxParticipants = room.getCapacity();
		}
		else {
			this.maxParticipants = maxParticipants;
		}
	}
	
	public boolean enroll(String nif) {
		if(this.participants.contains(nif))
			return false;
		
		if(this.participants.size() < this.maxParticipants) {
			this.participants.add(nif);
			return true;
		}
		
		return false;
	}

	public String getName() {
		return name;
	}

	public ActivityType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public SubRoom getRoom() {
		return room;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setRoom(SubRoom room) {
		if (this.room != null) {
			this.room.setAct(null);
		}
		this.room = room;
		room.setAct(this);
	}

	public Set<String> getParticipants() {
		return participants;
	}
	
}
