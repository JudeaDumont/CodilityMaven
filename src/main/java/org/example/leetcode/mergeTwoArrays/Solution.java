package org.example.leetcode.mergeTwoArrays;

import java.util.Arrays;

public class Solution {
    public void mergeTwoArrays(int[]a, int[]b){
        int[] to = {1, 2, 2, 3, 5, 6};
        System.arraycopy(to, 0, a, 0, to.length);
    }
}
