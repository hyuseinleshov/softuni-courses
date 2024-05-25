package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenArray = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Collections.addAll(childrenQueue, childrenArray);

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String removedChild = childrenQueue.poll();
                childrenQueue.offer(removedChild);

                System.out.println("Removed " + childrenQueue.poll());
            }
        }

        System.out.println("Last is " + childrenQueue.poll());
    }
}
