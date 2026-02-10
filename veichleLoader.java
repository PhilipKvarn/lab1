import java.util.Stack;

public class veichleLoader {
    Stack<Veichle> loadingStorage = new Stack<Veichle>();
    protected int maxCapacity;

    public veichleLoader(int maxCap) {
        maxCapacity = maxCap;
    }

    public void LoadNewVeichle(Veichle veichle) {
        if (loadingStorage.capacity() != this.maxCapacity) {
            loadingStorage.addElement(veichle);
        }

        return;
    }

    public void unloadVeichle() {
        loadingStorage.pop();
        return;
    }

    public int getMax() {
        return maxCapacity;
    }

    public int getCapacity() {
        return loadingStorage.capacity();
    }
}
