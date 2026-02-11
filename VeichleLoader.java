
import java.util.Vector;
import java.util.function.Consumer;;

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

    public void forEachItem(Consumer<carType> func){
        for (carType car : loadingStorage){
            func.accept(car);
        }
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.capacity();
    }
}
