package works;

import static org.junit.Assert.*;
import org.junit.Test;

public class SubroomExhibitionTest {

    @Test
    public void testSubroomExhibitionCreation() {
    	int roomID = 789;
        double width = 8.0;
        double length = 10.0;
        double height = 4.0;
        SubRoom room = new SubRoom(roomID, true, 30, width, length, height, 20);

        SubroomExhibition subroomExhibition = new SubroomExhibition(room);

        assertNotNull(subroomExhibition);
    }

    @Test
    public void testSubroomExhibitionAddWorks() {
        int roomID = 789;
        double width = 8.0;
        double length = 10.0;
        double height = 4.0;
        SubRoom room = new SubRoom(roomID, true, 30, width, length, height, 20);
        
        SubroomExhibition subroomExhibition = new SubroomExhibition(room);

        assertEquals(0, subroomExhibition.getWorks().size());

        Work work1 = new Painting("Starry Night", "Vincent van Gogh", false, 10, 75.0, 92.0, 0.0, 0.0, "oleo");
        Work work2 = new Sculpture("David", "Michelangelo", false, 15, 100.0, 150.0, 200.0, 30.0, "Mármol", "Cincel");

        subroomExhibition.addWorks(work1, work2);

        assertEquals(2, subroomExhibition.getWorks().size());
        assertTrue(subroomExhibition.getWorks().contains(work1));
        assertTrue(subroomExhibition.getWorks().contains(work2));
    }

    @Test
    public void testSubroomExhibitionSetWorkStatus() {
        int roomID = 789;
        double width = 8.0;
        double length = 10.0;
        double height = 4.0;
        
        SubRoom room = new SubRoom(roomID, true, 30, width, length, height, 20);

        SubroomExhibition subroomExhibition = new SubroomExhibition(room);

        Work work1 = new Painting("Starry Night", "Vincent van Gogh", false, 10, 75.0, 92.0, 0.0, 0.0, "oleo");
        Work work2 = new Sculpture("David", "Michelangelo", false, 15, 100.0, 150.0, 200.0, 30.0, "Mármol", "Cincel");

        subroomExhibition.addWorks(work1, work2);

        subroomExhibition.setWorkStatus(Status.BORROWED);

        for (Work work : subroomExhibition.getWorks()) {
            assertEquals(Status.BORROWED, work.getStatus());
        }
    }
}
