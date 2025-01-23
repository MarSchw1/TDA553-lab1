import java.awt.*;

public class volvo240 extends car{
    private final double trimFactor;

    public volvo240() {
        super(4, 100, Color.black, "Volvo240");
        trimFactor = 1.25;
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
