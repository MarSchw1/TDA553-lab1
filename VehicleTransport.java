import java.awt.*;
import java.util.ArrayList;

public class VehicleTransport extends Vehicle implements HasPlatform, Loads<Vehicle> {
private boolean platformUp;
private ArrayList<Vehicle> vehicles;
private int maxCapacity;


    public VehicleTransport(int maxCapacity) {
        super(2, 700, Color.white, "CarTransport", 0, 300);
        platformUp = true;
        vehicles = new ArrayList<>(maxCapacity);
        this.maxCapacity = maxCapacity;
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

    public void load (Vehicle vehicle) {
        if (this.GetCurrentSpeed() == 0 && IsCarInReach(vehicle) && !platformUp  && (vehicles.size() < maxCapacity) && !(vehicle instanceof VehicleTransport)) {
            vehicle.StopEngine();
            vehicles.add(vehicle);
            vehicle.loaded = true;
            vehicle.SetX(GetX());
            vehicle.SetY(GetY());
        }
    }

    public void UnloadCar () {
        if (!platformUp) {
            Vehicle vehicle = vehicles.removeLast();
            vehicle.loaded = false;
            vehicle.SetX(GetX() - 1);
            vehicle.SetY(GetY() - 1);
        }
    }

    public int GetNrCars(){
        return vehicles.size();
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
        for (Vehicle vehicle : vehicles){
            vehicle.SetX(this.GetX());
            vehicle.SetY(this.GetY());
        }
    }

    public boolean GetPlatformStatus(){
        return platformUp;
    }
}
