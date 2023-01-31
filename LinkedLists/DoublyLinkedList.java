package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

   private class Node {
        private int value;
        private Node next;
        private Node prev;

        private Node (int element){
            this.value = element;
        }
    }

    private void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void addFirst (int element) {
        Node newNode = new Node(element);
        if (size > 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addLast (int element) {
        if (size == 0) {
            addFirst(element);
        } else {
            Node newNode = new Node(element);
            Node currentNode = head;
            int counter = 0;
            while (counter < size - 1) {
                currentNode = currentNode.next;
                counter++;
            }
            currentNode.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public int removeFirst () {
        checkSize();
        int removedElement = head.value;
        head = head.next;

        size--;
        if (size == 0) {
            tail = null;
        } else {
            head.prev = null;
        }
        return removedElement;
    }

    public int removeLast () {
        if (size < 2) {
            return removeFirst();
        }
        Node currentNode = head;
        int counter = 0;
        while (counter < size - 2) {
            currentNode = currentNode.next;
            counter++;
        }
        int removedElement = currentNode.next.value;
        currentNode.next.prev = null;
        currentNode.next = null;
        tail = currentNode;
        size--;
        return removedElement;
    }

    public int get (int index) {
        checkIndex(index);
        Node currentNode = head;
        int counter = 0;
        while (counter < index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    public void forEach (Consumer<Integer> consumer) {
        int counter = 0;
        while (counter < size) {
            consumer.accept(get(counter));
            counter++;
        }
    }

    public int[] toArray () {
        int[] arr = new int[size];
        int counter = 0;
        Node currentNode = head;
        while (counter < size) {
            arr[counter] = currentNode.value;
            currentNode = currentNode.next;
            counter++;
        }
        return arr;
    }

}
