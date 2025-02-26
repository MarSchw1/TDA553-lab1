import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VehicleObject implements Drawable {
    private Vehicle vehicle;
    private Point position;
    private BufferedImage image;

    public VehicleObject(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.position = new Point();
        this.position.x = (int) vehicle.GetX();
        this.position.y = (int) vehicle.GetY();
        try {
            this.image = ImageIO.read(view.class.getResourceAsStream("pics/"+vehicle.getModel()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }
    public int getX() {
        return position.x;
    }
    public int getY() {
        return position.y;
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
    public void flipDirection() {
        vehicle.TurnLeft();
        vehicle.TurnLeft();
    }

    public void moveit(){
        position.x = (int) vehicle.GetX();
        position.y = (int) vehicle.GetY();
    }
    public void move() {
        vehicle.Move();
        moveit();
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
}