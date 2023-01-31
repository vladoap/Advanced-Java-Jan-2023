package Workshop;

import functionalProgramming.lab.P05FilterByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DoublyLinkedListGeneric<Integer> list = new DoublyLinkedListGeneric<>();


       list.addFirst(1);
       list.addFirst(2);
       list.addFirst(3);
       list.addFirst(4);
       list.addFirst(5);


        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        System.out.println();


    }
}
