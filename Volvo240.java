import java.awt.*;

public class Volvo240 extends Car {
    private final double trimFactor;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
        trimFactor = 1.25;
    }

    @Override
    protected double SpeedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
