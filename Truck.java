import java.awt.Color;

public class Truck extends Veichle {

    boolean loadingAreaDown;

    public Truck(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        loadingAreaDown = true;
    }

    public boolean getLoadingAreaDown(){
        return loadingAreaDown;
    }

    public void setLoadingAreaDown(boolean loadingState){
        loadingAreaDown = loadingState;
        return;
    }

    @Override
    public void startEngine(){
        if(loadingAreaDown){
            super.startEngine();
        }
    } 

}
