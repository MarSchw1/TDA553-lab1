import java.util.ArrayList;
import java.util.Iterator;

public class CarCollection implements Load<Vehicle>, Iterable<Vehicle>{
    private ArrayList<Vehicle> collection;

    public CarCollection(int capacity){
        collection = new ArrayList<>(capacity);
    }

    public int getSize(){
        return collection.size();
    }

    @Override
    public void load(Vehicle v){
        collection.add(v);
    }

    @Override
    public void unload() {
    }

    public Vehicle unloadFirst(){
        return collection.removeFirst();
    }

    public Vehicle unloadLast(){
        return collection.removeLast();
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return collection.iterator();
    }
}
