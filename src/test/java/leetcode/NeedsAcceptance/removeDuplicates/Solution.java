package leetcode.NeedsAcceptance.removeDuplicates;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] a) {
        int[]b = Arrays.stream(a).distinct().toArray();
        System.arraycopy(b, 0, a, 0, b.length);
        return b.length;
    }
}
