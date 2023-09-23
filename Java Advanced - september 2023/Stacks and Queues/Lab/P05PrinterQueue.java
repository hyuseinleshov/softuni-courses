package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!filename.equals("print")) {
            if (filename.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String removedFile = printerQueue.poll();
                    System.out.println("Canceled " + removedFile);
                }
            } else {
                printerQueue.offer(filename);
            }
            filename = scanner.nextLine();
        }

        for (String s : printerQueue) {
            System.out.println(s);
        }
    }
}
