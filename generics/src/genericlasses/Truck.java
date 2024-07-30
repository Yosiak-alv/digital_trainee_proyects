package genericlasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Truck <T> implements Iterable<T>{

    private List<T> objects;
    private int max;

    public Truck(int max) {
        this.objects = new ArrayList<>();
        this.max = max;
    }

    public void add(T obj)
    {
        if(objects.size() <= max)
        {
            objects.add(obj);
        }else {
            throw  new RuntimeException("No more space");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return objects.iterator();
    }

}
