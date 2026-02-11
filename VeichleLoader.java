import java.util.Stack;

public class VeichleLoader<carType extends Veichle> {
    Stack<carType> loadingStorage = new Stack<carType>();
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
        carType unloadCar = loadingStorage.pop();
        return unloadCar;
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.capacity();
    }
}
