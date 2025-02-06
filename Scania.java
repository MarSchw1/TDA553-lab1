import java.awt.*;

public class Scania extends Car implements HasPlatform{
    private double angle;

    public Scania () {
        super(2, 100, Color.white, "Scania");
    }

    // Standard raisePlatform för att höja till max.
    public void raisePlatform() {
        angle = 70;
    }

    // Overloada raisPlatform för att kunna höja ett visst antal grader.
    public void raisePlatform(double amount){
        angle = Math.min(angle += amount, 70);
    }

    public void lowerPlatform() {
        angle = 0;
    }

    // standard lower platform
    public void lowerPlatform(double amount){
        angle = Math.max(angle -= amount, 0);
    }

    // overloadad lowerPlatform för att sänka platformen ett viss antal grader
    public double getPlatformAngle(){return angle;}

    @Override
    protected double SpeedFactor() {
        return GetEnginePower() * 0.01;
    }
}

