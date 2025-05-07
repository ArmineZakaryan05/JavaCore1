package practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("Queue: " + queue); // [A, B, C]

        System.out.println("Peek: " + queue.peek()); // A
        System.out.println("Poll: " + queue.poll()); // A
        System.out.println("After poll: " + queue);  // [B, C]
    }
}
