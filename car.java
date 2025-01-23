import java.awt.*;

public abstract class car {
    //Bör alla vara privata för att inte kunna ändras direkt av användaren. De är specifika för bilarna.
    private int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    public car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }
    public int getNrDoors(){return nrDoors;}
    public double getEnginePower(){return enginePower;}
    public double getCurrentSpeed(){return currentSpeed;}

    public Color getColor(){return color;}
    public void setColor(Color clr){color = clr;}

    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}

    // protected gömmer funktionerna från utsidan men gör de tillgängliga för subklasser.
    // abstract betyder att subklasser som ex volvo240 can använda denna funktion men att de definierar den unik för varje "fordon".
    protected abstract double speedFactor();
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
