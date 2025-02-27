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

    private Model model;

    public CarController(Model model) {
        this.model = model;
    }

    //methods:
    // Calls the gas method for each car once
    void gas(int amount) {
        model.gas(amount);
    }

    //calls the brake method for eavh car once
    void brake(int amount) {
        model.brake(amount);
    }

     void setTurboOn() {
        model.setTurboOn();
    }

    void setTurboOff() {
        model.setTurboOff();
    }

    void raiseBed() {
        model.raiseBed();
    }

    void lowerBed() {
        model.lowerBed();
    }

    void startAllCars(){
        model.startAllCars();
    }

    void stopAllCars(){
        model.stopAllCars();
    }
    void addCar() {
        model.addCar();
    }

    void removeCar(){
        model.removeCar();
    }

}
