package works;

import java.util.*;

public class RoomComposite extends Room {
	
	private List<Room> subRooms = new ArrayList();

    public RoomComposite(boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(electricity, temperature, width, length, height, humidity, capacity);
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
    
    public void divide(double factor, Room...rooms) {
    	for(Room r : rooms) {
    		if(r == null) {
    			break;
    		}else {
    			double l = r.getLength();
    			r.setLength(l/factor);
    			this.add(new SubRoom(r.isElectricity(), r.getTemperature(), r.getWidth(), l - (l/factor), r.getHeight(), r.getHumidity(), r.getCapacity()));
    		}
    	}
    	double l = this.getLength();
    	this.add(new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l, this.getHeight(), this.getHumidity(), this.getCapacity()));
		this.add(new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l - (l/factor), this.getHeight(), this.getHumidity(), this.getCapacity()));
    	
    }

}
