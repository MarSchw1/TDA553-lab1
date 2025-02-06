import java.awt.*;

public class Scania extends Truck{
    private double angle;

    public Scania () {
        super(2, 100, Color.white, "Scania");
    }

    public void RaisePlatform(double amount){
        angle = Math.min(angle += amount, 70);
    }

    public void LowerPlatform(double amount){
        angle = Math.max(angle -= amount, 0);
    }

    public double getPlatformAngle(){return angle;}

    @Override
    protected double SpeedFactor() {
        return GetEnginePower() * 0.01;
    }
}

