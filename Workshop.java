import java.util.ArrayList;

public class Workshop<T extends Vehicle> implements Load<T>{
    private final CarCollection cars;
    private final int capacity;

    public Workshop(int capacity){
        this.cars = new CarCollection(capacity);
        this.capacity = capacity;
    }

    public void load(T car){
        if (cars.getSize() < capacity) {
            cars.load(car);
        }
    }

    public void unload(){
        cars.unloadFirst();
    }

    //public void getCar(T car){
//        cars.remove(car);
//    }

    public int getNrOfCars(){
        return cars.getSize();
    }

}
