import java.awt.*;

public class Saab95 extends car{
    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;}

    public void setTurboOff() {
        turboOn = false;}

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }

}
