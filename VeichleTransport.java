import java.awt.Color;
import java.util.Stack;

public class VeichleTransport extends Truck {

    VeichleLoader<Veichle> parentLoader = new VeichleLoader<>(4);

    public VeichleTransport(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors,enginePower,color,modelName);
        setLoadingAreaDown(false);
    }

    public void LoadNewVeichle(Veichle veichle){
        if (veichle instanceof VeichleTransport) {
            return;
        }
        parentLoader.LoadNewVeichle(veichle);
        return;
    }

    public Veichle unloadVeichle(){
        Veichle unloaded_car = parentLoader.unloadVeichle();
        return unloaded_car;
    }

    @Override
    public void startEngine(){
        if(!loadingAreaDown){
            super.startEngine();
        }
    }
}