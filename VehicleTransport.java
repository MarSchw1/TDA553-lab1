import java.awt.*;

public class VehicleTransport extends Truck implements Loadable<Car> {
private boolean platformUp;
private CarCollection<Car> cars;
private int maxCapacity;


    public VehicleTransport() {
        super(2, 700, Color.white, "CarTransport");
        platformUp = true;
        maxCapacity = 8;
        cars = new CarCollection(maxCapacity);
    }
    @Override
    protected double SpeedFactor() {
        return GetEnginePower() * 0.01;
    }

    private boolean IsCarInReach(Vehicle other){
        boolean inReach = false;
        double x1 = this.GetX() - other.GetX();
        double y1 = this.GetY() - other.GetY();
        if ((Math.abs(x1) <= 2) && (Math.abs(y1) <= 2)) {
            inReach = true;
        }
        return inReach;
    };

    public void raisePlatform() {
        if (GetCurrentSpeed() == 0) {
            platformUp = true;
        }
    }

    public void lowerPlatform() {
        if (GetCurrentSpeed() == 0) {
            platformUp = false;
        }
    }
    @Override
    public void load (Car car) {
        if (GetCurrentSpeed() == 0 && IsCarInReach(car) && !platformUp  && (cars.getSize() < maxCapacity)) {
            cars.load(car);
            car.SetX(GetX());
            car.SetY(GetY());
        }
    }

    public void unload () {
        if (!platformUp) {
            Vehicle vehicle = cars.unloadLast();
            vehicle.SetX(GetX() - 1);
            vehicle.SetY(GetY() - 1);
        }
    }

    @Override
    public void Move() {
        if (platformUp){
            super.Move();
        }
    }

    @Override
    public void StartEngine() {
        if (platformUp){
            super.StartEngine();
        }
        for (Vehicle vehicle : cars){
            vehicle.SetX(this.GetX());
            vehicle.SetY(this.GetY());
        }
    }
}
