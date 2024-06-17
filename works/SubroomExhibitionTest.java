package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubroomExhibitionTest {

    @Test
    public void testSubroomExhibitionCreation() {
    	SubRoom sr = new SubRoom(true, 20, 12, 10, 10, 25, 5);
    	
    	SubroomExhibition sre = new SubroomExhibition(sr);
    	
    	assertEquals(sr, sre.getSalaHija());
    	assertEquals(sre, sr.getSrb());
    }
}
