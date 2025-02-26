import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class Model {
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>(); // Tillhör modell-delen

    Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(2,400,30);

    ArrayList<ModelUpdateObserver> observers = new ArrayList<ModelUpdateObserver>();

    public Model() {
        vehicles = new ArrayList<Vehicle>();
        timer = new Timer(delay, new TimerListener());
        initObjects();
        startTimer();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateModel();
        }
    }

    public void addObserver(ModelUpdateObserver observer) {observers.add(observer);}

    public void notifyObservers(){
        for (ModelUpdateObserver observer : observers) {
            observer.OnModelUpdate();
        }
    }

    private void updateModel() {
        for (Vehicle vehicle : vehicles) {
            vehicle.Move();
            tryLoading(vehicle);
            chekVehicleInFrame(vehicle);
            notifyObservers();
        }
    }

    private Workshop getWorkshop() { return volvo240Workshop;}

    private void tryLoading(Vehicle vehicle) {
        int wx = (int) Math.round(getWorkshop().getX());
        int wy = (int) Math.round(getWorkshop().getY());
        int x = (int) Math.round(vehicle.GetX());
        int y = (int) Math.round(vehicle.GetY());

        if ((x + 100) > wx && x < (wx + 100) &&
                (y + 60) > wy && y < (wy + 100)) {
            if (vehicle instanceof Volvo240 volvo) {
                volvo240Workshop.load(volvo);
                vehicle.SetX(wx);
                vehicle.SetY(wy);
            }
        }
    }

    private void chekVehicleInFrame(Vehicle vehicle) {
        if(vehicle.GetX() > 690){
            vehicle.SetX(690);
            vehicle.StopEngine();
            vehicle.invertDirection();
            vehicle.StartEngine();
        } else if (vehicle.GetX() < 0) {
            vehicle.SetX(0);
            vehicle.StopEngine();
            vehicle.invertDirection();
            vehicle.StartEngine();
        }
    }
    public void initObjects(){
        addVehicle(VehicleFactory.createSaab());
        addVehicle(VehicleFactory.createVolvo());
        addVehicle(VehicleFactory.createScania());
    }

    public void startTimer(){
        timer.start();
    }

    public  void stopTimer(){
        timer.stop();
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.Gas(gas);
        }
    }

    //calls the brake method for eavh car once
    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.Brake(gas);
        }
    }

    void setTurboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raisePlatform();
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerPlatform();
            }
        }
    }

    void startAllCars(){
        for (Vehicle car : vehicles) {
            car.StartEngine();
        }
    }

    void stopAllCars(){
        for (Vehicle car : vehicles) {
            car.StopEngine();
        }
    }
    void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < 10){
            vehicles.add(vehicle);
            notifyObservers();
        }
    }

    public void addCar() {
        addVehicle(VehicleFactory.createVolvo());
    }

    public void removeVehicle() {
        if (vehicles.size() > 0) {
            vehicles.remove(vehicles.size() - 1);
            notifyObservers();
        }
    }

    public void removeCar() {
        removeVehicle();
    }

}
