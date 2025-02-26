import javax.swing.*;
import java.util.ArrayList;

public class Model {
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>(); // Tillhör modell-delen

    Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(2,400,30);

    public Model() {
        vehicles = new ArrayList<>();
        timer = new Timer(delay, new TimerListener());
        initObjects();
        startTimer();
    }
    public void initObjects(){
        vehicles.add(VehicleFactory.createSaab());
        vehicles.add(VehicleFactory.createVolvo());
        vehicles.add(VehicleFactory.createScania());
    }
    public void startTimer(){
        timer.start();
    }
    public  void stopTimer(){
        timer.stop();
    }
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
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
}
