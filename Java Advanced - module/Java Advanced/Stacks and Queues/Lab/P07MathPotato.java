package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenArray = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> childrenQueue = new PriorityQueue<>();
        Collections.addAll(childrenQueue, childrenArray);

        int cycle = 1;

        while (childrenQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String removedChild = childrenQueue.poll();
                childrenQueue.offer(removedChild);

                if (childrenQueue.size() == 1) {
                    break;
                }
                if (isPrime(cycle)) {
                    System.out.println("Prime " + childrenQueue.peek());
                } else {
                    System.out.println("Removed " + childrenQueue.poll());
                }

                cycle++;
            }
        }

        System.out.println("Last is " + childrenQueue.poll());
    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
