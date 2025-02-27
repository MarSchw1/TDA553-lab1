import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VehicleObject implements Drawable {
    private final Vehicle vehicle;
    private BufferedImage image;

    public VehicleObject(Vehicle vehicle) {
        this.vehicle = vehicle;
        try {
            this.image = ImageIO.read(View.class.getResourceAsStream("pics/"+vehicle.getModel()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setX(int newX){
        vehicle.SetX(newX);
    }

    public void setY(int newY){
        vehicle.SetY(newY);
    }

    public int getX() {
        return (int) vehicle.GetX();
    }

    public int getY() {
        return (int) vehicle.GetY();
    }

    public BufferedImage getImage() {
        return image;
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

    public void move() {
        vehicle.Move();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setTurboOn() {
        if (vehicle instanceof Saab95) {
            ((Saab95) vehicle).setTurboOn();
        }
    }
    public void setTurboOff() {
        if (vehicle instanceof Saab95) {
            ((Saab95) vehicle).setTurboOff();
        }
    }
    public void raisePlatform() {
        if (vehicle instanceof Scania) {
            ((Scania) vehicle).raisePlatform();
        }
    }
    public void lowerPlatform() {
        if (vehicle instanceof Scania) {
            ((Scania) vehicle).lowerPlatform();
        }
    }
}