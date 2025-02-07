import java.awt.*;

public class Saab95 extends Vehicle {
    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "Saab95", true);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;}

    public void setTurboOff() {
        turboOn = false;}

    @Override
    protected double SpeedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return GetEnginePower() * 0.01 * turbo;
    }

}
