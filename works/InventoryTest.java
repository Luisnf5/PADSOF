package works;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
	
	@Test
    public void testAddWorks() {
        Inventory inventory = new Inventory();
        Work work1 = new Painting("La Mona Lisa", "Leonardo da Vinci", false, 20, 77.0, 53.0, 2.0, 40.0);
        Work work2 = new Painting("Guernica", "Pablo Picasso", false, 15, 349.0, 776.0, 7.8, 60.0);
        
        inventory.addWorks(work1, work2);
        
        Set<Work> expectedWorks = new HashSet<>();
        expectedWorks.add(work1);
        expectedWorks.add(work2);
        
        assertEquals(expectedWorks, inventory.getWorks());
    }
	
	@Test
    public void testSendReparation() {
		 Inventory inventory = new Inventory();
	     Work work1 = new Painting("La Mona Lisa", "Leonardo da Vinci", false, 20, 77.0, 53.0, 2.0, 40.0);
	     Work work2 = new Painting("Guernica", "Pablo Picasso", false, 15, 349.0, 776.0, 7.8, 60.0);
	        
	    inventory.addWorks(work1, work2);
	        
        Work workToRepair = inventory.getWorks().iterator().next();
        assertTrue(inventory.sendReparation(workToRepair));
        ((Painting)workToRepair).setStatus(Status.RESTORATION);
        assertEquals(Status.RESTORATION, workToRepair.getSta());
    }

    @Test
    public void testSetWorks() {
    	Inventory inventory = new Inventory();
        Set<Work> newWorks = new HashSet<>();
        inventory.addWorks(new Painting("Nueva Obra 1", "Nuevo Autor 1", false, 36, 5.0, 15.0, 3.0, 25.0), new Photo("Nueva Obra 2", "Nuevo Autor 2", true, 13, 8.0, 18.0, 4.0, 30.0, true, "16:9", 1080));
        assertEquals(inventory.getWorks(), newWorks);
    }
}
