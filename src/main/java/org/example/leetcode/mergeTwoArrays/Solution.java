package org.example.leetcode.mergeTwoArrays;

public class Solution {
    public void mergeTwoArrays(int[] a, int[] b) {
        int[] c = new int[a.length];
        int i = 0, j = 0, k = 0;
        while (k < a.length) {
            if (a[j] == 0) {
                c[k++] = b[i++];
            }
            else if (a[j] < b[i]) {
                c[k++] = a[j++];
            } else if (a[j] > b[i]) {
                c[k++] = b[i++];
            } else {
                c[k++] = a[j++];
                c[k++] = b[i++];
            }
        }
        System.arraycopy(c, 0, a, 0, c.length);
    }
}
