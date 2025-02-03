import java.awt.*;

public class Scania extends Truck{
    private double angle;
    private boolean flakNere;

    public Scania () {
        super(2, 100, Color.white, "Scania");
        flakNere = true;
    }

    private void RaisePlatform(double amount){
        angle = Math.min(angle += amount, 70);
    }

    private void LowerPlatform(double amount){
        angle = Math.max(angle -= amount, 0);
    }

    public double getPlatformAngle(){return angle;}

    @Override
    protected double SpeedFactor() {
        return enginePower * 0.01;
    }
}
