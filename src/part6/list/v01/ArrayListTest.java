package part6.list.v01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("World");

        System.out.println(list);

        list.remove("Hello");
        System.out.println(list);

        System.out.println(list.get(0));
    }
}
