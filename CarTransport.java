import com.sun.jdi.connect.Transport;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class CarTransport extends Car implements HasPlatform {
private boolean platformUp;
private ArrayList<Car> cars;
private int maxCapacity;


    public CarTransport() {
        super(2, 700, Color.white, "CarTransport");
        platformUp = true;
        maxCapacity = 8;
        cars = new ArrayList<>(maxCapacity);
    }
    @Override
    protected double SpeedFactor() {
        return GetEnginePower() * 0.01;
    }

    private boolean IsCarInReach(Car other){
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

    public void LoadCar (Car car) {
        if (GetCurrentSpeed() == 0 && IsCarInReach(car) && !platformUp  && (cars.size() < maxCapacity) && car.getClass() != CarTransport.class) {
            cars.add(car);
            car.SetX(GetX());
            car.SetY(GetY());
        }
    }

    public void UnloadCar () {
        if (!platformUp) {
            Car car = cars.removeLast();
            car.SetX(GetX() - 1);
            car.SetY(GetY() - 1);
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
        for (Car car : cars){
            car.SetX(this.GetX());
            car.SetY(this.GetY());
        }
    }
}
