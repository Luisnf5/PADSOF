package works;

import java.util.*;

public class RoomComposite extends Room {
	
	private List<Room> subRooms = new ArrayList();

    public RoomComposite(boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(electricity, temperature, width, length, height, humidity, capacity);
    }
    
    public Set<SubRoom> getSubRooms(){
    	Set<SubRoom> sbr = new LinkedHashSet<>();
    	
    	for (Room r : this.subRooms) {
			sbr.addAll(r.getSubRooms());
		}
    	
    	return sbr;
    }
    
    public void add(Room...rooms) {
    	if(!this.getDivided()) {
    		for(Room r : rooms)
    			this.subRooms.add(r);
    		this.setDivided(true);
    	}
    }
    
    public void remove(Room room) {
    	this.subRooms.remove(room);
    	if(this.subRooms.isEmpty()) {
    		this.setDivided(false);
    	}
    }
    
    public Room getChild(int index) {
    	return this.subRooms.get(index);
    }
    
    public void divide(double factor, Room room) {
    	double l = room.getLength();
    	
    	Room comp = new RoomComposite(this.isElectricity(), this.getTemperature(), this.getWidth(), l, this.getHeight(), this.getHumidity(), this.getCapacity());
    	comp.add(new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l - (l/factor), this.getHeight(), this.getHumidity(), this.getCapacity()));
    	comp.add(new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l/factor, this.getHeight(), this.getHumidity(), this.getCapacity()));
    	
    	this.add(comp);
    	this.remove(room);
    }

    public void collapse(RoomComposite room) {
    	this.add(new SubRoom(room.isElectricity(), room.getTemperature(), room.getWidth(), room.getLength(), room.getHeight(), room.getHumidity(), room.getCapacity()));
    	this.remove(room);
    }
}