import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(2,400,30);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // cc.cars.add(new Volvo240());
        // cc.cars.add(new Saab95());
        // cc.cars.add(new Scania());

        cc.cars.add(VehicleFactory.createVolvo());
        cc.cars.add(VehicleFactory.createSaab());
        cc.cars.add(VehicleFactory.createScania());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int wx = (int) Math.round(volvo240Workshop.getX());
            int wy = (int) Math.round(volvo240Workshop.getY());
            frame.drawPanel.volvoWorkshopPoint.x = wx;
            frame.drawPanel.volvoWorkshopPoint.y = wy;

            for (Vehicle car : cars) {
                car.Move();
                int x = (int) Math.round(car.GetX());
                int y = (int) Math.round(car.GetY());

                if ((x + 100) > wx && x < (wx + 100) &&
                        (y + 60) > wy && y < (wy + 100)) {
                    if (car instanceof Volvo240 volvo) {
                        volvo240Workshop.load(volvo);
                        car.SetX(wx);
                        car.SetY(wy);
                    }
                }

                if(x > 690){
                    car.SetX(690);
                    car.StopEngine();
                    car.TurnRight();
                    car.TurnRight();
                    car.StartEngine();
                } else if (x < 0) {
                    car.SetX(0);
                    car.StopEngine();
                    car.TurnRight();
                    car.TurnRight();
                    car.StartEngine();
                }

                frame.updateCarPosition(car, x,y);
                /* frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint(); */
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle car : cars
                ) {
            car.Gas(gas);
        }
    }

    //calls the brake method for eavh car once
    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.Brake(gas);
        }
    }

     void setTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void raiseBed() {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raisePlatform();
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : cars) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerPlatform();
            }
        }
    }

    void startAllCars(){
        for (Vehicle car : cars) {
            car.StartEngine();
        }
    }

    void stopAllCars(){
        for (Vehicle car : cars) {
            car.StopEngine();
        }
    }



}
