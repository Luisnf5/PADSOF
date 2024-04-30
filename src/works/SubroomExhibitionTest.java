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

        SubroomExhibition subroomExhibition = new SubroomExhibition(roomID, width, length, height);

        assertNotNull(subroomExhibition);
        assertEquals(roomID, subroomExhibition.getRoomID());
        assertEquals(width, subroomExhibition.getWidth(), 0.01);
        assertEquals(length, subroomExhibition.getLength(), 0.01);
        assertEquals(height, subroomExhibition.getHeight(), 0.01);
    }

    @Test
    public void testSubroomExhibitionAddWorks() {
        int roomID = 789;
        double width = 8.0;
        double length = 10.0;
        double height = 4.0;

        SubroomExhibition subroomExhibition = new SubroomExhibition(roomID, width, length, height);

        assertEquals(0, subroomExhibition.getWorks().size());

        Work work1 = new Painting("Starry Night", "Vincent van Gogh", false, false, 75.0, 92.0, 0.0, 0.0, "oleo");
        Work work2 = new Sculpture("David", "Michelangelo", false, false, 100.0, 150.0, 200.0, 30.0, "Mármol", "Cincel");

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

        SubroomExhibition subroomExhibition = new SubroomExhibition(roomID, width, length, height);

        Work work1 = new Painting("Starry Night", "Vincent van Gogh", false, false, 75.0, 92.0, 0.0, 0.0, "oleo");
        Work work2 = new Sculpture("David", "Michelangelo", false, false, 100.0, 150.0, 200.0, 30.0, "Mármol", "Cincel");

        subroomExhibition.addWorks(work1, work2);

        subroomExhibition.setWorkStatus(WorkStatus.BORROWED);

        for (Work work : subroomExhibition.getWorks()) {
            assertEquals(WorkStatus.BORROWED, work.getSta());
        }
    }
}
