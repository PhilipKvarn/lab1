import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class veichleTest {
    Saab95 s = new Saab95();

    @Test
    public void testSaab() {
        assertEquals("125", s.getEnginePower());
        assertEquals(2, s.getNrDoors());
        assertEquals("red", s.getColor());
        s.currentSpeed = 2;
        double speed = s.currentSpeed;
        s.decrementSpeed(1);
        assertTrue(speed > s.currentSpeed);
        speed = s.currentSpeed;
        s.incrementSpeed(1);
        assertTrue(speed < s.currentSpeed);
    }

}
