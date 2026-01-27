import java.awt.*;
public class Veichle implements Movable{
    
    private int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    private double[] veichlePosition = {0,0};
    private double[] veichleDirection = {1,0};
    private int rotationSpeed = 10; // rotation of 10degrees per rotation

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

    protected double speedFactor(){
        return enginePower*0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }   

    @Override
    public void move(){
        if (currentSpeed <= 0) {
            veichlePosition[0] += getCurrentSpeed() * veichleDirection[0];
            veichlePosition[1] += getCurrentSpeed() * veichleDirection[1];
        }
    }

    @Override
    public void turnLeft(){
        double radianRotation = -rotationSpeed * (Math.PI/180);
        veichleDirection[0] = veichleDirection[0] * Math.cos(radianRotation) - veichleDirection[1] *Math.sin(radianRotation);
        veichleDirection[1] = veichleDirection[0] * Math.sin(radianRotation) + veichleDirection[1] *Math.cos(radianRotation);
    }

    @Override
    public void turnRight(){
        double radianRotation = rotationSpeed * (Math.PI/180);
        veichleDirection[0] = veichleDirection[0] * Math.cos(radianRotation) - veichleDirection[1] *Math.sin(radianRotation);
        veichleDirection[1] = veichleDirection[0] * Math.sin(radianRotation) + veichleDirection[1] *Math.cos(radianRotation);
    }
}


class TurboCar extends Veichle{
    
    private boolean activeTurbo;
    
    public TurboCar(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.activeTurbo = false;
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
    protected double speedFactor(){
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
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}