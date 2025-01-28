import java.awt.*;

public abstract class car implements movable {
    //Bör alla vara privata för att inte kunna ändras direkt av användaren. De är specifika för bilarna.
    private int nrDoors;
    protected double enginePower;
    protected double currentSpeed; // satte denna till protected för att kunna sätta faten direkt i testerna
    private Color color;
    private String modelName;
    private int direction = 0; // gör dessa privata ---
    private double x = 0;
    private double y = 0;

    //Constructor
    public car(int nrDoors, double enginePower, Color color, String modelName){
        if (enginePower <= 0) {
            throw new IllegalArgumentException("Engine power must be positive.");
        }
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    // Public getters
    public int getNrDoors(){return nrDoors;}
    public double getEnginePower(){return enginePower;}
    public double getCurrentSpeed(){return currentSpeed;}

    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}

    // Public functions for starting and stopping engine
    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}

    // protected gömmer funktionerna från utsidan men gör de tillgängliga för subklasser.
    // abstract betyder att subklasser som ex volvo240 can använda denna funktion men att de definierar den unik för varje "fordon".

    // abstract function for determining the speedFactor
    protected abstract double speedFactor();

    // protected function for incrementing a cars currentSpeed.
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    // protected function for decreasing a cars currentSpeed.
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // public method for increasing currentSpeed
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Not accepted amount for gas, insert a value between 0 and 1");
        }
        incrementSpeed(amount);
    }
    // public method i decrease currentSpeed
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Not accepted amount break, insert a value between 0 and 1");
        }
        decrementSpeed(amount);
    }

    // Changes the coordinate doubles according to the cars direction and currentSpeed.
    // O = North, 1 = East, 2 = South, 3 = West
    public void move() {
        if (direction == 0) {
            y += currentSpeed;
        } else if (direction == 1) {
            x += currentSpeed;
        } else if (direction == 2) {
            y -= currentSpeed;
        } else if (direction == 3) {
            x -= currentSpeed;
        } else {
            throw new IllegalStateException("Not a valid direction (0, 1, 2, 3)");
        }
    }

    // turnRight makes the car by incrementing the cars direction-variable
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    // turnLeft makes the car by incrementing the cars direction-variable
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    public double getX() {return x;}

    public double getY() {return y;}
}

