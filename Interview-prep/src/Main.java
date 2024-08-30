import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        set.add(5);
        set.add(1);
        set.add(10);
        set.add(3);
        int count = 1;
        for(Integer number: set){
            System.out.println(count++  +": " + number);
        }
        List<String> list = new CopyOnWriteArrayList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Iterating over elements
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // Adding an element while iterating
        list.add("Date");

        // Iterating again to see the new element
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}