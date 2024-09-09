package homework.dynamicArray;

public class DynamicArrayDemo {

    public static void main(String[] args) {

        DynamicArray dy = new DynamicArray();

        dy.add(21);
        dy.add(20);
        dy.add(3);
        dy.add(8);
        dy.add(9);

        dy.set(2, 33);
        dy.print();
        dy.add(2, 28);
        dy.add(19);
        dy.print();
        System.out.println(dy.exists(9));
        System.out.println(dy.getIndexByValue(33));
    }
}
