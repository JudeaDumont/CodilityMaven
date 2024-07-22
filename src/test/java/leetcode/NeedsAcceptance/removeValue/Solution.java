package leetcode.NeedsAcceptance.removeValue;

import java.util.Arrays;

public class Solution {
    public int removeValue(int[] a, int r) {
        int[]b = Arrays.stream(a).filter((e)->e!=r).toArray();
        System.arraycopy(b, 0, a, 0, b.length);
        return b.length;
    }
}
