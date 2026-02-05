import java.awt.Color;

public class Scania extends Veichle {

    private int loadingAreaAngle;

    public Scania(){
        super(2, 250, Color.BLUE, "Scania");
        loadingAreaAngle = 0;
    }

    public int getLoadingAreaAngle(){
        return this.loadingAreaAngle;
    }

    public void setLoadingAreaAngle(int angle){
        if(angle <= 70 && angle >= 0){
            if(this.getCurrentSpeed() == 0){
                loadingAreaAngle = angle;
            };
        };
        return;
    }

    @Override
    public void startEngine(){
        if(loadingAreaAngle == 0){
            super.startEngine();
        }
    } 
}
