import java.util.ArrayList;

public class Workshop<T extends Vehicle> implements Loads <T>{
    private final ArrayList<T> cars;
    private final int capacity;
    private final double x;
    private final double y;

    public Workshop(int capacity, double x, double y) {
        this.cars = new ArrayList<>();
        this.capacity = capacity;
        this.x = x;
        this.y = y;
    }

    @Override
    public void load(T car){
        if (!car.loaded) {
            if (cars.size() < capacity) {
                car.loaded = true;
                cars.add(car);
            }
        }
    }

    public void unload(T car){
        cars.remove(car);
        car.loaded = false;
    }

    public int getNrOfCars(){
        return cars.size();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


}
