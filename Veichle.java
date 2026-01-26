import java.awt.*;

public class Veichle {
    
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    public String modelName;

    public Veichle(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower*0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }   
}


class TurboCar extends Veichle{
    
    private boolean activeTurbo;
    
    public TurboCar(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
    }

    public boolean getTurboActive(){
        return activeTurbo;
    }

    public void setTurboActive(){
        activeTurbo = true;
    }

    public void setTurboInactive(){
        activeTurbo = false;
    }


    @Override
    public double speedFactor(){
        double turbo = 1.0;
        if(activeTurbo){turbo = 1.3;}
        return enginePower * 0.01 * turbo ;
    }

}

class TrimmedCar extends Veichle{
    private double trimFactor;

    public TrimmedCar(int nrDoors, double enginePower, Color color, String modelName, double trimFactor){
        super(nrDoors, enginePower, color, modelName);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}