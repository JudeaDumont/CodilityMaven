package playingWithJava;

import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.IntStream;

public class PlayTime {
    public static void main(String[] args) {
        int[] arrays = new int[10];
        IntStream.range(0, arrays.length).forEach(i -> arrays[i] = i);
        Assertions.assertArrayEquals(arrays, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        IntStream.range(0, arrays.length).forEach(i -> arrays[i] = i * 5);
        Assertions.assertArrayEquals(arrays, new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45});

        int[] array = IntStream.concat(IntStream.of(1, 2, 3), IntStream.of(4, 5, 6)).toArray();
        Assertions.assertArrayEquals(array, new int[]{1, 2, 3, 4, 5, 6});

        int[] hugeArray = IntStream.range(0, 1000000).toArray();
        int i = Arrays.binarySearch(hugeArray, 499999);
        Assertions.assertEquals(499999, i);

        IntSummaryStatistics statistics = Arrays.stream(hugeArray).summaryStatistics();
        double average = statistics.getAverage();
        double max = statistics.getMax();
        double min = statistics.getMin();
        double sum = statistics.getSum();

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(0);
        arrayDeque.push(7);
        arrayDeque.push(8);
        arrayDeque.add(1);
        arrayDeque.push(9);
        arrayDeque.add(10);
        System.out.println(arrayDeque.toString());
        Integer poll = arrayDeque.poll();
        System.out.println("poll: " + poll);
        System.out.println(arrayDeque.toString());
        Integer pollLast = arrayDeque.pollLast();
        System.out.println("pollLast: " + pollLast);
        System.out.println(arrayDeque.toString());
        Integer pop = arrayDeque.pop();
        System.out.println("pop: " + pop);
        System.out.println(arrayDeque.toString());
        arrayDeque.offer(20);
        System.out.println(arrayDeque.toString());
        arrayDeque.offerFirst(2);
        System.out.println(arrayDeque.toString());
        arrayDeque.offerLast(3);
        System.out.println(arrayDeque.toString());

        BitSet bitSet = new BitSet();
        bitSet.set(14);
        System.out.println("bitSet.length(): " + bitSet.length());
        System.out.println("bitSet.toString(): " + bitSet.toString());
        bitSet.set(9, 13, true);
        System.out.println("bitSet.toString(): " + bitSet.toString());
        bitSet.set(10, 12, false);
        System.out.println("bitSet.toString(): " + bitSet.toString());

        LinkedList<AnObject> linkedList = new LinkedList<>(Arrays.asList(null,null));
        System.out.println("linkedList.toString(): " + linkedList.toString());
        Collections.fill(linkedList, new AnObject());
        System.out.println("linkedList.toString(): " + linkedList.toString());

        Date date = new Date();
        System.out.println("date.toString(): " + date.toString());

        IntStream range = IntStream.range(1, 50);
        int reduce = range.reduce(0, (a, b) -> ((7*a + 11*b)) / b);
        System.out.println("reduce: " + reduce);
    }
}
