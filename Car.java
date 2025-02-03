import java.awt.*;

public abstract class Car implements Movable {
    //Bör alla vara privata för att inte kunna ändras direkt av användaren. De är specifika för bilarna.
    private int nrDoors;
    protected double enginePower;
    private double currentSpeed; // satte denna till protected för att kunna sätta faten direkt i testerna
    private Color color;
    private String modelName;
    private int direction = 0; // gör dessa privata ---
    private double x = 0;
    private double y = 0;

    //Constructor
    public Car(int nrDoors, double enginePower, Color color, String modelName){
        if (enginePower <= 0) {
            throw new IllegalArgumentException("Engine power must be positive.");
        }
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        StopEngine();
    }

    // Public getters
    public int GetNrDoors(){return nrDoors;}
    public double GetEnginePower(){return enginePower;}
    public double GetCurrentSpeed(){return currentSpeed;}

    public Color GetColor(){return color;}
    public void SetColor(Color clr){color = clr;}

    // Public functions for starting and stopping engine
    public void StartEngine(){currentSpeed = 0.1;}
    public void StopEngine(){currentSpeed = 0;}

    // protected gömmer funktionerna från utsidan men gör de tillgängliga för subklasser.
    // abstract betyder att subklasser som ex volvo240 can använda denna funktion men att de definierar den unik för varje "fordon".

    // abstract function for determining the speedFactor
    protected abstract double SpeedFactor();

    // protected function for incrementing a cars currentSpeed.
    private void IncrementSpeed(double amount){
        currentSpeed = Math.min(GetCurrentSpeed() + SpeedFactor() * amount,enginePower);
    }

    // protected function for decreasing a cars currentSpeed.
    private void DecrementSpeed(double amount) {
        currentSpeed = Math.max(GetCurrentSpeed() - SpeedFactor() * amount, 0);
    }

    // public method for increasing currentSpeed
    public void Gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Not accepted amount for gas, insert a value between 0 and 1");
        }
        IncrementSpeed(amount);
    }
    // public method i decrease currentSpeed
    public void Brake(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Not accepted amount break, insert a value between 0 and 1");
        }
        DecrementSpeed(amount);
    }

    // Changes the coordinate doubles according to the cars direction and currentSpeed.
    // O = North, 1 = East, 2 = South, 3 = West
    public void Move() {
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
    public void TurnRight() {
        direction = (direction + 1) % 4;
    }

    // turnLeft makes the car by incrementing the cars direction-variable
    public void TurnLeft() {
        direction = (direction + 3) % 4;
    }

    public double GetX() {return x;}

    public double GetY() {return y;}
}

