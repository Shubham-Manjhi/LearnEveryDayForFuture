import java.util.ArrayList;
import java.util.Collections;

public class ListComparison {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Cherry");

        List<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Cherry");

        List<String> list3 = new ArrayList<>();
        list3.add("Banana");
        list3.add("Apple");
        list3.add("Cherry");

        System.out.println("list1.equals(list2): " + list1.equals(list2)); // true (same elements, same order)
        System.out.println("list1.equals(list3): " + list1.equals(list3)); // false (same elements, different order)
    }
}