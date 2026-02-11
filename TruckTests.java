import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.Test;

public class TruckTests {
    
    @Test
    public void testScania() {
        Scania s = new Scania();
        assertEquals(s.getLoadingAreaAngle(), 0);
        s.startEngine();
        assertNotEquals(s.getCurrentSpeed(), 0);  
        s.stopEngine();
        s.setLoadingAreaAngle(20);
        assertEquals(s.getLoadingAreaAngle(), 20);
        s.startEngine();
        assertEquals(s.getCurrentSpeed(), 0);
        s.stopEngine();
    }

    @Test
    public void testVeichleTransport(){
        VeichleTransport v = new VeichleTransport(2, 120, Color.black, "sc", 4);
        
        Saab95 s = new Saab95();

        v.LoadNewVeichle(v);
        Veichle V = v.unloadVeichle();
        assertEquals(V, null);

    }

}
