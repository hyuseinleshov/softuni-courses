package Exercise.CustomLinkedList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

     private class Node {
         private int item;
         private Node next;
         private Node prev;

         public Node(int item) {
             this.item = item;
         }
     }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {

        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;

    }

    public void addLast(int element) {

        Node newNode = new Node(element);

        if (size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;

        }

        this.size++;

    }

    public int get(int index) {

        checkIndex(index);

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current.item;
    }

    public void checkIndex(int index) {

        if (index < 0 || index > this.size - 1) {
            String message = String.format("Index %d, Size: %d", index, this.size);
            throw  new IndexOutOfBoundsException(message);
        }

    }

    public int removeFirst() {

        checkIsEmpty(size);

        int element = 0;

        if (size == 1) {
            element = this.head.item;
            this.head = this.tail = null;
        } else if (size == 2) {
            element = this.head.item;
            this.head = this.tail;
            this.tail.prev = null;
        } else {
            element = this.head.item;
            this.head = this.head.next;
            this.head.prev = null;
        }

        size--;

        return element;
    }

    public int removeLast() {

        checkIsEmpty(size);

        int element = 0;

        if (size == 1) {
            element = this.tail.item;
            this.tail = this.head = null;
        } else if (size == 2) {
            element = this.tail.item;
            this.tail = this.head;
            this.head.next = null;
        } else {
            element = this.tail.item;
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        size--;

        return element;
    }

    public void checkIsEmpty(int size) {
        if (size == 0) {
            String message = "List is empty!";
            throw new NoSuchElementException(message);
        }
    }

    public void forEach(Consumer<Integer> consumer) {

        Node current = this.head;
        int currentIndex = 0;

        while (current != null && currentIndex < this.size) {
            consumer.accept(current.item);
            current = current.next;
            currentIndex++;
        }

    }

    public int[] toArray() {

        int[] collectionToArray = new int[this.size];

        Node current = this.head;
        int currentIndex = 0;

        while (current != null && currentIndex < this.size) {
            collectionToArray[currentIndex] = current.item;
            current = current.next;
            currentIndex++;
        }

        return collectionToArray;
    }

}
