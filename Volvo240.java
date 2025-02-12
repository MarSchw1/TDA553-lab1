import java.awt.*;

public class Volvo240 extends Vehicle {
    private final double trimFactor;

    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", true, 0, 0);
        trimFactor = 1.25;
    }

    @Override
    protected double SpeedFactor() {
        return GetEnginePower() * 0.01 * trimFactor;
    }

}
