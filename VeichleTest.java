import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.Test;

public class VeichleTest {

    /*
    Veichle myVeichle;
    @BeforeAll
    public void setUp(){
        myVeichle = new Veichle(0, 0, null, null);
    }
    */

    @Test
    public void testSaab() {
        Veichle s = new Saab95();
        assertEquals("125", s.getEnginePower());
        assertEquals(2, s.getNrDoors());
        assertEquals("red", s.getColor());
        s.incrementSpeed(2);
        double speed = s.getCurrentSpeed();
        s.decrementSpeed(1);
        assertTrue(speed > s.getCurrentSpeed());
        speed = s.getCurrentSpeed();
        s.incrementSpeed(1);
        assertTrue(speed < s.getCurrentSpeed());
    }

    @Test
    public void accelerateTest() {
        Veichle saab95 = new Saab95();
        Vector2 pos = saab95.getPosition();
        Vector2 zeroVector = new Vector2(0, 0);
        assertEquals(pos.x, zeroVector.x);
        assertEquals(pos.y, zeroVector.y);
        saab95.startEngine();
        assertEquals(saab95.getCurrentSpeed(), 0.1);
        saab95.move();
        assertEquals(pos.x, 0.1);
        assertEquals(pos.y, zeroVector.y);
        saab95.incrementSpeed(10); // 0.1 + 1.25*10 = 12.6
        assertEquals(saab95.getCurrentSpeed(), 12.6);
        saab95.move();
        assertEquals(pos.x, 12.7);
        saab95.decrementSpeed(6.08); // 12.6 - 1.25*6.08 = 5
        assertEquals(saab95.getCurrentSpeed(), 5);
        saab95.move();
        assertEquals(pos.x, 17.7);
    }

    @Test
    public void steeringTest() {
        Veichle saab95 = new Saab95();
        saab95.turnLeft();
        Vector2 dir = saab95.getDirection();
        double x = Math.round(dir.x * 1000.0) / 1000.0;
        double y = Math.round(dir.y * 1000.0) / 1000.0;
        assertEquals(0.985, x);
        assertEquals(0.174, y);
        saab95.turnRight();
        saab95.turnRight();
        dir = saab95.getDirection();
        x = Math.round(dir.x * 1000.0) / 1000.0;
        y = Math.round(dir.y * 1000.0) / 1000.0;
        assertEquals(0.985, x);
        assertEquals(-0.174, y);
    }

    @Test
    public void activateTurbo(){
        
    }

    @Test
    public void compareTrim(){
        TrimmedCar trim = new Volvo240();
        Veichle normalCar = new Veichle(2, 100, Color.red, "ABC123");

        trim.startEngine();
        normalCar.startEngine();

        trim.incrementSpeed(10);      // 0.1 + 1.25*10 = 12.6
        normalCar.incrementSpeed(10); // 0.1 + 1*10 = 10.1

        assertNotEquals(trim.getCurrentSpeed(), normalCar.getCurrentSpeed());

        // Assert Not Equal mellan bilarnas hastighet.
        // Efter att de har accelererat med en magnitud av 10.
    }

}
