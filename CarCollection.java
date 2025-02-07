import java.util.ArrayList;
import java.util.Iterator;

public class CarCollection<T extends Vehicle> implements Iterable<T>{
    private ArrayList<T> collection;

    public CarCollection(int capacity){
        collection = new ArrayList<>(capacity);
    }

    public int getSize(){
        return collection.size();
    }

    public void load(T t) {
        collection.add(t);
    }

    public Vehicle unloadFirst(){
        return collection.removeFirst();
    }

    public Vehicle unloadLast(){
        return collection.removeLast();
    }

    @Override
    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
