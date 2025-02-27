import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VehicleObject implements Drawable {
    private final Vehicle vehicle;
    private int x;
    private int y;
    private BufferedImage image;

    public VehicleObject(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.x = (int) vehicle.GetX();
        this.y = (int) vehicle.GetY();
        try {
            this.image = ImageIO.read(View.class.getResourceAsStream("pics/"+vehicle.getModel()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setX(int newX){
        x = newX;
    }

    public void setY(int newY){
        y = newY;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setTurboOn() {
        if (vehicle instanceof setTurbo){
            ((setTurbo) vehicle).setTurboOn();
        }
    }
    public void setTurboOff() {
        if (vehicle instanceof setTurbo){
            ((setTurbo) vehicle).setTurboOff();
        }
    }
    public void raisePlatform() {
        if (vehicle instanceof HasPlatform){
            ((HasPlatform) vehicle).raisePlatform();
        }
    }
    public void lowerPlatform() {
        if (vehicle instanceof HasPlatform){
            ((HasPlatform) vehicle).lowerPlatform();
        }
    }
    public void Gas(double amount) {
        vehicle.Gas(amount);
    }
    public void Brake(double amount) {
        vehicle.Brake(amount);
    }
    public void StartEngine() {
        vehicle.StartEngine();
    }
    public void StopEngine() {
        vehicle.StopEngine();
    }
    public void invertDirection() {
        vehicle.TurnLeft();
        vehicle.TurnLeft();
    }

    public void moveit(){
        x = (int) vehicle.GetX();
        y = (int) vehicle.GetY();
    }
    public void move() {
        vehicle.Move();
        moveit();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}