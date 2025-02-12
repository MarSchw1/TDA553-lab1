import java.awt.*;

public class Scania extends Vehicle implements HasPlatform{
    private double angle;

    public Scania () {
        super(2, 80, Color.white, "Scania", false,0, 200);
    }

    public double getAngle(){
        return angle;
    }

    // Standard raisePlatform för att höja till max.
    public void raisePlatform() {
        if (GetCurrentSpeed() == 0){
            angle = 70;
        }
    }

    // Overloada raisPlatform för att kunna höja ett visst antal grader.
    public void raisePlatform(double amount){
        if (GetCurrentSpeed() == 0){
            angle = Math.min(angle += amount, 70);
        }
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

    @Override
    public void StartEngine() {
        if (angle == 0){
            super.StartEngine();
        }
    }

    @Override
    public void Move() {
        if (angle == 0){
            super.Move();
        }
    }
}

