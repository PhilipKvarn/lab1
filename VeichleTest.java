import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class VeichleTest {

    @Test
    public void steeringTest(){
        Veichle saab95 = new Veichle(2,150,Color.red,"Saab95");
        saab95.turnLeft();
        Vector2 dir = saab95.getDirection();
        System.out.println(dir);
        double x = Math.round(dir.x*1000.0)/1000.0;
        double y = Math.round(dir.y*1000.0)/1000.0;
        assertEquals(0.985, x);
        assertEquals(-0.174, y);
    }

}
