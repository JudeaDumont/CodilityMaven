package quizSolutions.java.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class ListExample {
    public static void main(String[] args) {
        // Using ArrayList
        List<String> arrayList = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("ArrayList Elements:");
        printList(arrayList);

        // Removing an element from ArrayList
        removeElement(arrayList, 1);
        System.out.println("ArrayList after removal:");
        printList(arrayList);

        System.out.println();

        // Using LinkedList
        List<String> linkedList = new LinkedList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("LinkedList Elements:");
        printList(linkedList);

        // Removing an element from LinkedList
        removeElement(linkedList, 1);
        System.out.println("LinkedList after removal:");
        printList(linkedList);
    }

    // Method to print elements of a list using streams
    private static void printList(List<String> list) {
        list.forEach(name -> System.out.println("Element: " + name));
    }

    // Method to remove an element at a specified index
    private static void removeElement(List<String> list, int index) {
        list.remove(index);
    }
}