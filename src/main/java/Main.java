import datastructures.list.impl.MyArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> numbers2 = new MyArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(4);

        numbers2.forEach(System.out::println);
    }
}
