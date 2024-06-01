package org.example.leetcode.FastStringTraversal;

import java.util.HashSet;
import java.util.TreeSet;

public class Solution {
    // Misunderstood the assignment
    static public int lengthOfLongestSubstring(String s) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (current == 0) {
                    if (2 > max) {
                        max = 2;
                        current = 2;
                    }
                } else {
                    if (++current > max) {
                        max = current;
                    }
                }
            } else {
                current = 0;
            }
        }
        return max;
    }
}
