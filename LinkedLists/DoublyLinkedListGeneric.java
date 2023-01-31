package Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedListGeneric <T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private T value;
        private Node next;
        private Node prev;

        private Node (T element){
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

    public void addFirst (T element) {
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

    public void addLast (T element) {
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

    public T removeFirst () {
        checkSize();
        T removedElement = head.value;
        head = head.next;

        size--;
        if (size == 0) {
            tail = null;
        } else {
            head.prev = null;
        }
        return removedElement;
    }

    public T removeLast () {
        if (size < 2) {
            return removeFirst();
        }
        Node currentNode = head;
        int counter = 0;
        while (counter < size - 2) {
            currentNode = currentNode.next;
            counter++;
        }
        T removedElement = currentNode.next.value;
        currentNode.next.prev = null;
        currentNode.next = null;
        tail = currentNode;
        size--;
        return removedElement;
    }

    public T get (int index) {
        checkIndex(index);
        Node currentNode = head;
        int counter = 0;
        while (counter < index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    public void forEach (Consumer<T> consumer) {
        int counter = 0;
        while (counter < size) {
            consumer.accept(get(counter));
            counter++;
        }
    }

    @SuppressWarnings("unchecked")
    public T[] toArray () {
        Object[] arr = new Object[size];
        int counter = 0;
        Node currentNode = head;
        while (counter < size) {
            arr[counter] = currentNode.value;
            currentNode = currentNode.next;
            counter++;
        }
        return (T[]) arr;
    }

}
