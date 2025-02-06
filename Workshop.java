import java.util.ArrayList;

public class Workshop<T extends Car>{
    private final ArrayList<T> cars;
    private final int capacity;

    public Workshop(int capacity){
        this.cars = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addCar(T car){
        if (cars.size() < capacity) {
            cars.add(car);
        }
    }

    public void getCar(T car){
        cars.remove(car);
    }

    public int getNrOfCars(){
        return cars.size();
    }

}
