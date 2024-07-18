package org.example.leetcode.Sum307182024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Wrapper class for integer array
record IntArrayWrapper(int[] array) {
    IntArrayWrapper(int[] array) {
        // Store a copy of the array to avoid external modifications
        this.array = Arrays.copyOf(array, array.length);
        Arrays.sort(this.array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArrayWrapper that = (IntArrayWrapper) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}

public class Solution {
    public int[][] sum3(int[] ints) {
        int p1 = 0;
        int p2 = 1;
        int p3 = 2;

        Set<IntArrayWrapper> set = new HashSet<>();
        while (p1 != ints.length - 2) {
            int currentSum = ints[p1] + ints[p2] + ints[p3];
            if (currentSum == 0) {
                //Wrapper class sorts them and adds them to a set
                set.add(new IntArrayWrapper(new int[]{ints[p1], ints[p2], ints[p3]}));
            }

            //iterate
            if (p3 != ints.length - 1) {
                ++p3;
            } else if (p2 != ints.length - 2) {
                ++p2;
                p3 = p2 + 1;
            } else {
                ++p1;
                p2 = p1 + 1;
                p3 = p2 + 1;
            }
        }
        return set.stream().map(IntArrayWrapper::array).toArray(int[][]::new);
    }
}
