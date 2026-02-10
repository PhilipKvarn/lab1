import java.awt.Color;
import java.util.Stack;

public class VeichleTransport extends Truck {

    Stack<Veichle> loadingStorage = new Stack<Veichle>();
    

    public VeichleTransport(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors,enginePower,color,modelName);
        setLoadingAreaDown(false);
    }

    public void LoadNewVeichle(Veichle veichle){
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