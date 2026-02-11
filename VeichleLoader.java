
import java.util.Vector;;

public class VeichleLoader<carType extends Veichle> {
    
    Vector<carType> loadingStorage = new Vector<>();

    protected int maxCapacity;

    public VeichleLoader(int maxCap) {
        maxCapacity = maxCap;
    }

    public void LoadNewVeichle(carType veichle) {
        if (loadingStorage.capacity() < this.maxCapacity) {
            loadingStorage.addElement(veichle);
        }

        return;
    }

    public carType unloadVeichle() {
        carType unloadCar = loadingStorage.getLast();
        loadingStorage.removeLast();
        return unloadCar;
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.capacity();
    }
}
