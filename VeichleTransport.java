import java.awt.Color;
import java.util.Stack;

public class VeichleTransport extends Truck {

    Stack<Veichle> loadingStorage = new Stack<Veichle>();
    VeichleLoader<Veichle> parentLoader = new VeichleLoader<>(4);

    public VeichleTransport(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors,enginePower,color,modelName);
        setLoadingAreaDown(false);
    }

    public void LoadNewVeichle(Veichle veichle){
        if (veichle instanceof VeichleTransport) {
            return;
        }
        loadingStorage.addElement(veichle);
        return;
    }

    public void unloadVeichle(){
        loadingStorage.pop();
        return;
    }

    @Override
    public void startEngine(){
        if(!loadingAreaDown){
            super.startEngine();
        }
    }
}