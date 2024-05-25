package Exercise.CustomLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(3);

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(5);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(6);

        int[] collectiontoArray = doublyLinkedList.toArray();

        for (int i = collectiontoArray.length - 1; i >= 0 ; i--) {
            System.out.println(collectiontoArray[i]);
        }

    }

}
