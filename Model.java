import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Model {
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    ArrayList<VehicleObject> vehicles = new ArrayList<>(); // Tillhör modell-delen

    //Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(2,400,30);
    WorkshopObject volvo240Workshop = VehicleFactory.createVolvoWorkshop(2,400,50);

    ArrayList<ModelUpdateObserver> observers = new ArrayList<ModelUpdateObserver>();

    public Model() {
        vehicles = new ArrayList<VehicleObject>();
        timer = new Timer(delay, new TimerListener());
        initObjects();
        startTimer();
    }

    public ArrayList<Drawable> getImages() {
        ArrayList<Drawable> images = new ArrayList<>();
        for (VehicleObject vehicleObject : vehicles) {
            images.add(vehicleObject);
        }
        // TODO: Lägg till workshoppen  också. Kan behövas en WorkshopObejkt på samma sätt som för bilarna.
        images.add(volvo240Workshop);

        return images;
    }

    public void initObjects(){
        addVehicle(VehicleFactory.createSaab());
        addVehicle(VehicleFactory.createVolvo());
        addVehicle(VehicleFactory.createScania());
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
        for (VehicleObject vehicleObject : vehicles) {
            vehicleObject.move();
            tryLoading(vehicleObject);
            chekVehicleInFrame(vehicleObject);
            notifyObservers();
        }
    }

    private WorkshopObject getWorkshop() { return volvo240Workshop;}

    private void tryLoading(VehicleObject vehicle) {
        int wx = (int) Math.round(getWorkshop().getX());
        int wy = (int) Math.round(getWorkshop().getY());
        int x = (int) Math.round(vehicle.getX());
        int y = (int) Math.round(vehicle.getY());

        if ((x + 100) > wx && x < (wx + 100) &&
                (y + 60) > wy && y < (wy + 100)) {
            if (vehicle.getVehicle() instanceof Volvo240 volvo) {
                volvo240Workshop.getWorkshop().load(volvo);
                vehicle.setX(wx);
                vehicle.setY(wy);
            }
        }
    }

    private void chekVehicleInFrame(VehicleObject vehicle) {
        if(vehicle.getX() > 690){
            vehicle.setX(690);
            vehicle.StopEngine();
            vehicle.invertDirection();
            vehicle.StartEngine();
        } else if (vehicle.getX() < 0) {
            vehicle.setX(0);
            vehicle.StopEngine();
            vehicle.invertDirection();
            vehicle.StartEngine();
        }
    }

    public void startTimer(){
        timer.start();
    }

    public  void stopTimer(){
        timer.stop();
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject vehicle : vehicles) {
            vehicle.Gas(gas);
        }
    }

    //calls the brake method for eavh car once
    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject vehicleObject : vehicles) {
            vehicleObject.getVehicle().Brake(gas);
        }
    }

    void setTurboOn() {
        for (VehicleObject vehicleObject : vehicles) {
            if (vehicleObject.getVehicle() instanceof Saab95) {
                ((Saab95) vehicleObject.getVehicle()).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (VehicleObject vehicleObject : vehicles) {
            if (vehicleObject.getVehicle() instanceof Saab95) {
                ((Saab95) vehicleObject.getVehicle()).setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (VehicleObject vehicleObject : vehicles) {
            if (vehicleObject.getVehicle() instanceof Scania) {
                ((Scania) vehicleObject.getVehicle()).raisePlatform();
            }
        }
    }

    void lowerBed() {
        for (VehicleObject vehicleObject : vehicles) {
            if (vehicleObject.getVehicle() instanceof Scania) {
                ((Scania) vehicleObject.getVehicle()).lowerPlatform();
            }
        }
    }

    void startAllCars(){
        for (VehicleObject vehicleObject : vehicles) {
            vehicleObject.getVehicle().StartEngine();
        }
    }

    void stopAllCars(){
        for (VehicleObject vehicleObject : vehicles) {
            vehicleObject.getVehicle().StopEngine();
        }
    }
    void addVehicle(VehicleObject vehicle) {
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
