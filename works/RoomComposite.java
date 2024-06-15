package works;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RoomComposite extends Room {
	
	private List<Room> subRooms = new ArrayList();

    public RoomComposite(boolean electricity, double temperature, double width, double length, double height, double humidity, int capacity){
        super(electricity, temperature, width, length, height, humidity, capacity);
    }
    
    public Set<SubRoom> getSubRooms(){
    	Set<SubRoom> sbr = new LinkedHashSet<>();
    	System.out.println("getSubRooms llamada desde RoomComposite");
    	for (Room r : this.subRooms) {
			sbr.addAll(r.getSubRooms());
		}
    	
    	return sbr;
    }
    
    public List<Room> getDaughters(){
    	return subRooms;
    }
    
    
    @Override
    public void remove(Room room) {
    	this.subRooms.remove(room);
    	if(this.subRooms.isEmpty()) {
    		this.setDivided(false);
    	}
    }
    
    public Room getChild(int index) {
    	return this.subRooms.get(index);
    }
     
    public void divide(double factor, SubRoom room) {
    	System.out.println("dividir llamado desde roomCompsite para " + room.getName());
    	double l = room.getLength();
    	Double newCap =  (room.getCapacity()/factor);
    	int newCapInt = newCap.intValue();
    	
    	SubRoom sr1 = new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l - (l/factor), this.getHeight(), this.getHumidity(), newCapInt);
    	SubRoom sr2 = new SubRoom(this.isElectricity(), this.getTemperature(), this.getWidth(), l/factor, this.getHeight(), this.getHumidity(),  newCapInt);
    	RoomComposite comp = new RoomComposite(this.isElectricity(), this.getTemperature(), this.getWidth(), l, this.getHeight(), this.getHumidity(), room.getCapacity());
    	
    	sr1.setParent(comp);
    	sr2.setParent(comp);
    	
    	comp.subRooms.add(sr1);
    	comp.subRooms.add(sr2);
    	
    	comp.setParent(this);
    	
    	this.subRooms.add(comp);
    	this.remove(room);
    }

    public void collapse(RoomComposite room) {
    	SubRoom sr = new SubRoom(room.isElectricity(), room.getTemperature(), room.getWidth(), room.getLength(), room.getHeight(), room.getHumidity(), room.getCapacity());
    	sr.setParent(this);
    	this.subRooms.add(sr);
    	this.remove(room);
    }

	@Override
	public boolean isExposing() {
		boolean ret = false;
		for (Room r : this.subRooms) {
			if (r.isExposing()) {
				ret = true;
			}
		}
		
		return ret;
	}
    
    
}